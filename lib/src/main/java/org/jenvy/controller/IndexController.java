package org.jenvy.controller;

import org.jenvy.interactor.IndexInteractor;
import org.jenvy.model.IndexModel;
import org.jenvy.model.Model;
import org.jenvy.view.IndexView;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Region;

public abstract  class IndexController <
    M extends IndexModel,    
    V extends IndexView, 
    I extends IndexInteractor
>  extends Controller{
    protected  final V view;
    protected final M model;
    protected final I interactor;


    public IndexController(){
        this.model = initModel();
        this.interactor = initInteractor();
        this.view = initView();
       
        listeners();
       System.out.println("COntrolador index");
    }

    public Region getView(){
        return view.build();
    }

    protected abstract V initView();
    protected abstract M initModel();
    protected abstract I initInteractor();

    @Override
    protected  void listeners(){

        model.items().addListener((ListChangeListener)change->{
            while (change.next()) {
                interactor.updatePagination();
            }
        });

        model.pageCount().addListener((obs, oldVal, newValue) -> {
            view.getPagination().setPageCount(newValue.intValue());
        });

        model.index().addListener((observable, oldValue, newValue) -> {
            
            System.out.println("Cambio index :"+ newValue);
            if(model.search().get().equals("")){
                interactor.updatePagination();
                if (view.getPagination().getCurrentPageIndex() != newValue.intValue()) {
                    view.getPagination().setCurrentPageIndex(newValue.intValue());
                }
            }
        });

        view.searchProperty().addListener((observable, oldValue, newValue) -> {
            model.search().set(newValue);
        });
        
        model.search().addListener((obs, oldVal, newValue)->{
            System.out.println("Nuevo valor: "+ newValue);
            interactor.search(newValue);
        });

    }
    @Override
    protected void bindings(){
        view.build().visibleProperty().bind(model.visible());
    }

    @Override
    public Model getModel() {
        return model;
    }



    
}
