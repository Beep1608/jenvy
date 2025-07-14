package org.jenvy.controller;

import org.jenvy.interactor.ShowInteractor;
import org.jenvy.model.Model;
import org.jenvy.model.ShowModel;
import org.jenvy.view.ShowView;

public abstract class ShowController extends Controller {
    
    protected  final ShowModel model;
    protected final  ShowInteractor interactor;
    protected  final ShowView view;
    
    public ShowController(){
        
        this.model = initModel();
        this.interactor = initInteractor();
        this.view = initView();
    }

    protected abstract ShowModel initModel();
    protected abstract ShowInteractor initInteractor();
    protected abstract ShowView initView();


    @Override
    protected void listeners() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Model getModel() {
        return model;
    }
}
