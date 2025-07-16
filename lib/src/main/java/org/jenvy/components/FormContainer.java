package org.jenvy.components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormContainer extends VBox {

    private final String title;

    private final HBox titleContainer = new HBox();
    private final VBox contentContainer = new VBox();
    public FormContainer(String title) {
        this.title = title;
        initialize();
    }

    private void initialize() {
        getStyleClass().add("form-container");
        setPadding(new Insets(10,0,0,20));
        setSpacing(10);
        

        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("form-title");
        titleContainer.getChildren().add(titleLabel);
        titleContainer.setPrefHeight(50);
       
        contentContainer.getStyleClass().add("form-content");
        
        this.getChildren().addAll(titleContainer,contentContainer);

        
    }
    
    public VBox getContentContainer() {
        return contentContainer;
    }

    public HBox getTitleContainer(){
        return titleContainer;
    }

    public VBox getFormContainer(){
        return this;
    }
    
}
