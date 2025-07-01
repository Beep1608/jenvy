package org.jenvy.controller;

import org.jenvy.model.Model;
import org.jenvy.view.View;

public abstract  class Controller {
    
    private final View view;
    private final Model model;

    //Controllers
    private final IndexController indexController;
    private final CreateController createController;
    private final EditController editController;
    private final ShowController showController;

    public  Controller (){

        this.indexController = indexController();
        this.createController = createController();
        this.editController = editController();
        this.showController = showController();
        
        this.model = model();
        this.view = this.view();
    }

    
    protected abstract IndexController indexController();
    protected abstract CreateController createController();
    protected abstract EditController editController();
    protected abstract ShowController showController();


    protected abstract View view();
    protected abstract Model model();

}
