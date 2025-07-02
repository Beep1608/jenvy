package org.jenvy.controller;

import org.jenvy.interactor.Interactor;
import org.jenvy.model.IndexModel;
import org.jenvy.view.IndexView;

import javafx.scene.layout.Region;

public abstract  class IndexController <
    M extends IndexModel,    
    V extends IndexView, 
    I extends Interactor
> {
    protected  final V view;
    protected final M model;
    protected final I interactor;
    
    public IndexController(){
        this.model = initModel();
        this.view = initView();
       
        this.interactor = initInteractor();
    }

    public Region getView(){
        return view.build();
    }

    protected abstract V initView();
    protected abstract M initModel();
    protected abstract I initInteractor();
}
