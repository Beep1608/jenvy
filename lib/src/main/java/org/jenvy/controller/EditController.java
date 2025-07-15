package org.jenvy.controller;

import org.jenvy.interactor.EditInteractor;
import org.jenvy.model.EditModel;
import org.jenvy.view.EditView;

public abstract  class EditController extends Controller<EditModel, EditInteractor, EditView> {
   
    protected  final EditModel model;
    protected final EditInteractor interactor;
    protected  final EditView view;
    
    public EditController(){
        this.model = initModel();
        this.interactor = initInteractor();
        this.view = initView();

        listeners();
        bindings();
    }

    @Override
    protected abstract EditView initView();
    @Override
    protected abstract EditModel initModel();
    @Override
    protected abstract EditInteractor initInteractor();

    @Override
    protected void listeners() {
          model.visible().addListener((obs, oldVal, newValue) ->{
            System.out.println("Modelo edit nuevo valor : "+ newValue);
        });
    }

    
    @Override
    protected void bindings(){
        System.out.println("BINDINGS EN EDIT");
        view.build().visibleProperty().bind(model.visible());
        System.out.println("EDIT: "+ view.build().visibleProperty());
    }


    @Override
    public EditModel getModel() {
        return model;
    }
}
