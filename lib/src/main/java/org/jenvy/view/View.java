package org.jenvy.view;

import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public abstract  class View implements Builder<Region> {

    protected final Model model;
    protected final Interactor interactor;
    public View (Model model , Interactor interactor){
        this.model = model;
        this.interactor = interactor;
    }
    
    @Override
    public Region build() {
        throw new UnsupportedOperationException("View build() not supported yet.");
    }

    protected abstract Model getModel();
    
}
