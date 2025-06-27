package org.jenvy.view;

import org.jenvy.model.Model;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public abstract  class View implements Builder<Region> {

    private final StackPane container;
    private final Model model;
    public View( Model model, Region ...views){
        container = new StackPane(views);
        this.model = model;
    }
    public View( Model model, Region index , Region create, Region edit){
        container = new StackPane(index, create, edit);
        this.model = model;
    }

    @Override
    public Region build() {
     
        return  container;
    }
}