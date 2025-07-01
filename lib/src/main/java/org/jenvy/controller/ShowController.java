package org.jenvy.controller;

import org.jenvy.model.ShowModel;
import org.jenvy.view.ShowView;

public abstract class ShowController {
    
    private final ShowView view;
    private final ShowModel model;
    
    public ShowController(){
        this.view = initView();
        this.model = initModel();
    }

    protected abstract ShowView initView();
    protected abstract ShowModel initModel();
}
