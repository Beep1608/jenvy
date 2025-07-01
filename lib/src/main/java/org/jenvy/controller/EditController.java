package org.jenvy.controller;

import org.jenvy.model.EditModel;
import org.jenvy.view.EditView;

public abstract  class EditController {
    private final EditView view;
    private final EditModel model;
    
    public EditController(){
        this.view = initView();
        this.model = initModel();
    }

    protected abstract EditView initView();
    protected abstract EditModel initModel();
}
