package org.jenvy.controller;

import org.jenvy.model.Model;
import org.jenvy.model.ShowModel;
import org.jenvy.view.ShowView;

public abstract class ShowController extends Controller {
    
    private final ShowView view;
    private final ShowModel model;
    
    public ShowController(){
        this.view = initView();
        this.model = initModel();
    }

    protected abstract ShowView initView();
    protected abstract ShowModel initModel();

    @Override
    protected void listeners() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Model getModel() {
        return model;
    }
}
