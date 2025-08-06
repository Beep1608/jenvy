package org.jenvy.components;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.jenvy.view.router.Page;

public class DefaultPage extends VBox implements Page {

    public  DefaultPage(){
        getChildren().add(new Label("DEFAUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUULT"));
    }
    @Override
    public String getName() {
        return "Default";
    }

    @Override
    public Parent getView() {
        return this;
    }

    @Override
    public void reset() {
        System.out.println("reset Default");
    }
}
