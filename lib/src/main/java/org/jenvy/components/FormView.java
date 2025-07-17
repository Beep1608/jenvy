package org.jenvy.components;

import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.utils.Responsive;
import org.jenvy.view.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
public abstract class FormView extends View {

    private final VBox mainContainer  =new VBox();
    private final ScrollPane scrollPane = new ScrollPane(); 
    protected FormContainer generalDataCotainer;
    protected FormContainer specialDataContainer;

    public FormView(Model model ,Interactor interactor){
        super(model, interactor);
        init();
        makeView();
    }
   
    //Create 
    private Button createButton;
    @Override
    public Region build() {
        return scrollPane;
    }

    private void init(){

        scrollPane.setContent(mainContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.getStyleClass().add("buy-scroll");
       Responsive.bindingToParentHeight(mainContainer, 1);
    }


    protected  void makeView() {
        mainContainer.getStyleClass().add("buy");
        mainContainer.setPadding(new Insets(20, 150, 10, 200));
        mainContainer.setSpacing(20);
        createGeneralDataContainer();
        addFieldsToGeneralDataContainer();

        createSpecialDataContainer();
        addFieldsToSpecialDataContainer();
        
        addCreateButton();
        addActionsToCreateButton();
    }

    protected  void createGeneralDataContainer() {
        generalDataCotainer = new FormContainer("Información General");
        

        generalDataCotainer.setPrefHeight(300);
        generalDataCotainer.getContentContainer().setAlignment(Pos.CENTER);

        mainContainer.getChildren().add(generalDataCotainer);
    }

    protected abstract void addFieldsToGeneralDataContainer();
    

    protected  void createSpecialDataContainer() {
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

    public Button getCreateButton() {
        return createButton;
    }
    
}
