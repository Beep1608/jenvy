package org.jenvy.view;

import org.jenvy.model.Model;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public abstract  class View implements Builder<Region> {

    protected final Model model;
    
    public View (Model model){
        this.model = model;
    }
    
    @Override
    public Region build() {
        throw new UnsupportedOperationException("View build() not supported yet.");
    }

    protected abstract Model getModel();
    
}
