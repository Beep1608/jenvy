package org.jenvy.controller;

import org.jenvy.model.IndexModel;
import org.jenvy.view.IndexView;

public abstract  class IndexController {
    private final IndexView view;
    private final IndexModel model;
    
    public IndexController(){
        this.view = initView();
        this.model = initModel();
    }

    protected abstract IndexView initView();
    protected abstract IndexModel initModel();
}
