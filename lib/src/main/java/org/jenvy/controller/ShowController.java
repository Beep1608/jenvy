package org.jenvy.controller;

import org.jenvy.interactor.ShowInteractor;
import org.jenvy.model.ShowModel;
import org.jenvy.view.ShowView;

public abstract class ShowController extends Controller<ShowModel, ShowInteractor, ShowView> {
    
    protected  final ShowModel model;
    protected final  ShowInteractor interactor;
    protected  final ShowView view;
    
    public ShowController(){
        
        this.model = initModel();
        this.interactor = initInteractor();
        this.view = initView();

        listeners();
        this.bindings();
        System.out.println("Show controller");
    }

    protected abstract ShowModel initModel();
    protected abstract ShowInteractor initInteractor();
    protected abstract ShowView initView();


    @Override
    protected void listeners() {
           model.visible().addListener((obs, oldVal, newValue) ->{
            System.out.println("Modelo show nuevo valor : "+ newValue);
        });
    }

    @Override
    protected void bindings(){
        System.out.println("BINDINGS DE SHOW");
        view.build().visibleProperty().bind(model.visible());
        System.out.println("Visible show : "+ view.build().visibleProperty());
    }

    @Override
    public ShowModel getModel() {
        return model;
    }
}
