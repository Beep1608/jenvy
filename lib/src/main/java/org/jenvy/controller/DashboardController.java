package org.jenvy.controller;

import org.jenvy.interactor.DashboardInteractor;
import org.jenvy.model.DashboardModel;
import org.jenvy.view.DashboardView;

import javafx.scene.layout.Region;

public abstract  class DashboardController extends Controller<DashboardModel, DashboardInteractor, DashboardView> {
    
    protected  final DashboardView view;
    protected final DashboardModel model;
    protected final DashboardInteractor interactor;

    //Controllers
    protected  final IndexController indexController;
    protected  final CreateController createController;
    protected  final EditController editController;
    protected  final ShowController showController;

    public  DashboardController (){

        this.indexController = indexController();
        this.createController = createController();
        this.editController = editController();
        this.showController = showController();
        
        this.model = initModel();
        this.interactor = initInteractor();
        this.view = initView();

        listeners();
        bindings();
    }

    
    protected abstract IndexController indexController();
    protected abstract CreateController createController();
    protected abstract EditController editController();
    protected abstract ShowController showController();


    @Override
    protected void listeners(){

        model.index().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.create().set(false);
                model.edit().set(false);
                model.show().set(false);
            }
        });

         model.create().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.index().set(false);
                model.edit().set(false);
                model.show().set(false);
            }
        });

        model.edit().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.create().set(false);
                model.index().set(false);
                model.show().set(false);
            }
        });

        model.show().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.create().set(false);
                model.edit().set(false);
                model.index().set(false);
            }
        });
       
    }

    @Override
    protected void bindings() {
        indexController.getModel().visible().bind(model.index());
        createController.getModel().visible().bind(model.create());
        editController.getModel().visible().bind(model.edit());
        showController.getModel().visible().bind(model.show());

    }

    @Override
    public DashboardModel getModel() {
        return  model;
    }
    @Override
    public DashboardInteractor getInteractor() {
        return  interactor;
    }

    @Override
    public Region getView() {
        return  view.build();
    }

}
