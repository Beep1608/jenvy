package org.jenvy.controller;

import org.jenvy.interactor.CreateInteractor;
import org.jenvy.model.CreateModel;
import org.jenvy.view.CreateView;

public abstract  class CreateController extends Controller<CreateModel, CreateInteractor, CreateView> {
    
    protected  final CreateView view;
    protected  final CreateModel model;
    protected  final CreateInteractor interactor;
    
    public CreateController(){
        this.model = initModel();
        this.interactor = initInteractor();
        this.view = initView();

        listeners();
        bindings();

    }

    @Override
    public CreateView getView(){
        return view;
    }


    @Override
    protected abstract CreateView initView();
    @Override
    protected abstract CreateModel initModel();
    @Override
    protected abstract CreateInteractor initInteractor();

    @Override
    protected void listeners() {
             
          model.visible().addListener((obs, oldVal, newValue) ->{
            System.out.println("Modelo create nuevo valor : "+ newValue);
        });
    }
     @Override
    protected void bindings(){
      System.out.println("BINDINGS EN CREATE");
        view.build().visibleProperty().bind(model.visible());
        System.out.println("CREATE : "+ view.build().visibleProperty());
    }

    
    @Override
    protected void actions(){

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
