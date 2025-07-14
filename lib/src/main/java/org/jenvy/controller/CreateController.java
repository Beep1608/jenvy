package org.jenvy.controller;

import org.jenvy.interactor.CreateInteractor;
import org.jenvy.model.CreateModel;
import org.jenvy.view.CreateView;

import javafx.scene.layout.Region;

public abstract  class CreateController extends Controller<CreateModel, CreateInteractor, CreateView> {
    
    protected  final CreateView view;
    protected  final CreateModel model;
    protected  final CreateInteractor interactor;
    
    public CreateController(){
        this.model = initModel();
        this.interactor = initInteractor();
        this.view = initView();

    }

    public Region getView(){
        return view.build();
    }


    @Override
    protected abstract CreateView initView();
    @Override
    protected abstract CreateModel initModel();
    @Override
    protected abstract CreateInteractor initInteractor();

    @Override
    protected void listeners() {
        throw new UnsupportedOperationException("Listeners not supported yet.");
    }

    @Override
    public CreateModel getModel() {
        return model;
    }

    @Override
    public CreateInteractor getInteractor(){
        return  interactor;
    }
}
