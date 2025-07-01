package org.jenvy.controller;

import org.jenvy.model.CreateModel;
import org.jenvy.view.CreateView;

public abstract  class CreateController {
    
    private final CreateView view;
    private final CreateModel model;
    
    public CreateController(){
        this.view = initView();
        this.model = initModel();
    }

    public CreateView getView(){
        return view;
    }


    protected abstract CreateView initView();
    protected abstract CreateModel initModel();
}
