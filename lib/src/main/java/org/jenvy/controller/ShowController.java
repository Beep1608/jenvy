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
 
    }

    protected abstract ShowModel initModel();
    protected abstract ShowInteractor initInteractor();
    protected abstract ShowView initView();


    @Override
    protected void listeners() {
           model.visible().addListener((obs, oldVal, newValue) ->{
           
        });
    }

    @Override
    protected void bindings(){
        
        view.build().visibleProperty().bind(model.visible());
        
    }

    
    @Override
    protected void actions(){

    }

    @Override
    public ShowModel getModel() {
        return model;
    }

    @Override
    public ShowView getView(){
        return view;
    }

}
