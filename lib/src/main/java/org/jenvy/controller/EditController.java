package org.jenvy.controller;

import org.jenvy.model.EditModel;
import org.jenvy.model.Model;
import org.jenvy.view.EditView;

public abstract  class EditController extends Controller {
    private final EditView view;
    private final EditModel model;
    
    public EditController(){
        this.view = initView();
        this.model = initModel();
    }

    protected abstract EditView initView();
    protected abstract EditModel initModel();

    @Override
    protected void listeners() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Model getModel() {
        return model;
    }
}
