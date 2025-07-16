package org.jenvy.controller;

import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.view.View;

public abstract  class Controller<M extends Model, I extends Interactor, V extends  View> {
    
    protected abstract M initModel();
    protected abstract I initInteractor();
    protected abstract V initView();

    protected abstract void listeners();

    protected abstract void bindings();

    protected abstract void actions();

    public abstract M getModel();

    public abstract I getInteractor();

    public abstract  View getView();

}
