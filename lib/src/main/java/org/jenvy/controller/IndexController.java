package org.jenvy.controller;

import java.util.HashMap;
import java.util.function.Function;

import org.jenvy.interactor.Interactor;
import org.jenvy.model.IndexModel;
import org.jenvy.view.IndexView;

import javafx.collections.FXCollections;
import javafx.scene.layout.Region;

public abstract  class IndexController <
    M extends IndexModel,    
    V extends IndexView, 
    I extends Interactor
> {
    protected  final V view;
    protected final M model;
    protected final I interactor;
    
    protected final HashMap<String, Function<Object,Object>> actions = new HashMap<>();

    public IndexController(){
        this.model = initModel();
        this.interactor = initInteractor();
        actions.put("createPage", this::createPage);
        this.view = initView();
       
      
       
    }

    public Region getView(){
        return view.build();
    }

    protected abstract V initView();
    protected abstract M initModel();
    protected abstract I initInteractor();

    private Void createPage(Object index){
        int fromIndex = (int)index * model.pagination().get();
        int toIndex = Math.min(fromIndex + model.pagination().get(), model.items().size());

        model.tempItems().set(
            FXCollections.observableArrayList(
                model.items().subList(fromIndex, toIndex)
            )
        );

        return null;
    }

    
}
