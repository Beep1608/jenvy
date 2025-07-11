package org.jenvy.controller;

import org.jenvy.model.Model;

public abstract  class Controller {
    

    protected abstract void listeners();

    protected abstract void bindings();

    public abstract Model getModel();
}
