package org.jenvy.controller;

import org.jenvy.model.CreateModel;
import org.jenvy.model.Model;
import org.jenvy.view.CreateView;

public abstract  class CreateController extends Controller {
    
    private final CreateView view;
    private final CreateModel model;
    
    public CreateController(){
        this.model = initModel();
        this.view = initView();

    }

    public CreateView getView(){
        return view;
    }


    protected abstract CreateView initView();
    protected abstract CreateModel initModel();

    @Override
    protected void listeners() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Model getModel() {
        return model;
    }
}
