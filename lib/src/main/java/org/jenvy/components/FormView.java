package org.jenvy.components;

import org.jenvy.utils.Responsive;
import org.jenvy.view.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
public abstract class FormView extends  View {

    private VBox mainContainer  =new VBox();
    private ScrollPane scrollPane = new ScrollPane(); 
    protected FormContainer generalDataCotainer;
    protected FormContainer specialDataContainer;

   
    //Create 
    protected  Button createButton;

    protected  Button backButton;
    @Override
    public Region build() {

       
        scrollPane.setContent(mainContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.getStyleClass().add("buy-scroll");
        Responsive.bindingToParentHeight(mainContainer, 1);

        return scrollPane;
    }


    protected  void makeView() {
        mainContainer.getStyleClass().add("buy");
        mainContainer.setPadding(new Insets(20, 150, 10, 200));
        mainContainer.setSpacing(20);
        backButton = new Button("Regresar");
        backButton.setOnAction((evt) -> {
            addActionsToBackButton();
        });
        mainContainer.getChildren().add(backButton);
        createGeneralDataContainer();
        addFieldsToGeneralDataContainer();

        createSpecialDataContainer();
        addFieldsToSpecialDataContainer();
        
        addCreateButton();
        addActionsToCreateButton();
    }

    private void createGeneralDataContainer() {
        generalDataCotainer = new FormContainer("Información General");
        

        generalDataCotainer.setPrefHeight(300);
        generalDataCotainer.getContentContainer().setAlignment(Pos.CENTER);

        mainContainer.getChildren().add(generalDataCotainer);
    }

    protected abstract void addFieldsToGeneralDataContainer();
    

    private void createSpecialDataContainer() {
        specialDataContainer = new FormContainer("Información Especial");
        specialDataContainer.setPrefHeight(300);
        specialDataContainer.getContentContainer().setSpacing(10);
        specialDataContainer.getContentContainer().setAlignment(Pos.CENTER);
        mainContainer.getChildren().add(specialDataContainer);
   
    }

    protected abstract void addFieldsToSpecialDataContainer();

    private void addCreateButton(){
        createButton = new Button("Crear");
        createButton.getStyleClass().add("create-button");
        createButton.setOnMouseClicked(event -> {
            
            System.out.println("Objeto creado con éxito.");
        });
        
        mainContainer.getChildren().add(createButton);
    }

    protected abstract void addActionsToCreateButton();
    protected abstract void addActionsToBackButton();

    protected Button getCreateButton() {
        return createButton;
    }

    public Button getBackButton(){
        return backButton;
    }
    
}
