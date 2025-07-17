package org.jenvy.components;

import org.jenvy.utils.Responsive;

import javafx.scene.control.ComboBox;

public abstract  class FormComboBox extends FormContainer{

    private ComboBox input;
    public FormComboBox(String title) {
        super(title);
        init();
    }
    
    private void init(){
        input =new ComboBox();
        input.getItems().setAll(setItems());
        Responsive.bindingToParentWidth(input, 1);
        getTitleContainer().setPrefHeight(2);

        getContentContainer().getChildren().add(input);

        getFormContainer().setSpacing(0);
    }

    public ComboBox getInput(){
        return  input;
    }

    protected abstract  Object[] setItems();

    
    
}
