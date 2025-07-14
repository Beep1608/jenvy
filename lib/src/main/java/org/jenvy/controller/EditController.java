package org.jenvy.controller;

import org.jenvy.interactor.EditInteractor;
import org.jenvy.model.EditModel;
import org.jenvy.view.EditView;

public abstract  class EditController extends Controller<EditModel, EditInteractor, EditView> {
   
    protected  final EditModel model;
    protected final EditInteractor interactor;
    protected  final EditView view;
    
    public EditController(){
        this.view = initView();
        this.model = initModel();
        this.interactor = initInteractor();
    }

    protected abstract EditView initView();
    protected abstract EditModel initModel();
    protected abstract EditInteractor initInteractor();

    @Override
    protected void listeners() {
        throw new UnsupportedOperationException("Listeners not supported yet.");
    }

    
    @Override
    protected void bindings() {
        throw new UnsupportedOperationException("Bindings not supported yet.");
    }

    @Override
    public EditModel getModel() {
        return model;
    }
}
