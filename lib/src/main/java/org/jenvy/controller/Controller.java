package org.jenvy.controller;

import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.view.View;

public abstract  class Controller {
    
    private final Model model;
    private final Interactor interactor;
    private final View view;

    public  Controller (Model model){
        this.model  = model;
    }

    protected abstract  void run();
}
