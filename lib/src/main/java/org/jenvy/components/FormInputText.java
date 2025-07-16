package org.jenvy.components;



import org.jenvy.utils.Responsive;

import javafx.scene.control.TextField;

public class FormInputText extends FormContainer{

    private TextField input;
    public FormInputText(String title) {
        super(title);
       init();
    }

    private void init(){
        input =new TextField();
        
        Responsive.bindingToParentWidth(input, 1);
        getTitleContainer().setPrefHeight(2);

        getContentContainer().getChildren().add(input);

        getFormContainer().setSpacing(0);
    }
    
}
