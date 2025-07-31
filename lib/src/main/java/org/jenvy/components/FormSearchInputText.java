package org.jenvy.components;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jenvy.dto.Dto;

import javafx.beans.property.StringProperty;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class FormSearchInputText<D extends Dto> extends VBox {

    private final TextField textField;
    private final ContextMenu suggestionsMenu;
    private List<D> suggestionList;

    public FormSearchInputText(List<D> suggestions) {
        this.suggestionList = suggestions;
        this.textField = new TextField();
        this.textField.setPromptText("Buscar...");
        this.suggestionsMenu = new ContextMenu();

        this.setSpacing(5);
        this.getChildren().add(textField);

        setupAutoComplete();
    }

    private void setupAutoComplete() {
        textField.textProperty().addListener((obs, oldText, newText) -> {
            if (newText == null || newText.isEmpty()) {
                suggestionsMenu.hide();
            } else {
                List<D> filtered = suggestionList.stream()
                        .filter(item -> item.searcheable().toLowerCase().contains(newText.toLowerCase()))
                        .collect(Collectors.toList());

                if (!filtered.isEmpty()) {
                    List<CustomMenuItem> menuItems = new ArrayList<>();
                    for (D item : filtered) {
                        Label label = new Label(item.searcheable());
                        label.setMaxWidth(Double.MAX_VALUE); // importante para que pueda expandirse
                    
                        CustomMenuItem menuItem = new CustomMenuItem(label, true);
                        
                        menuItem.setOnAction(e -> {
                            textField.setText(item.searcheable());
                            suggestionsMenu.hide();
                        });
                        menuItems.add(menuItem);
                    }
                    suggestionsMenu.getItems().setAll(menuItems);
                    if (!suggestionsMenu.isShowing()) {
                        
                        suggestionsMenu.show(textField, Side.BOTTOM, 0, 0);
                        suggestionsMenu.setMinWidth(textField.getWidth());
                    }
                } else {
                    suggestionsMenu.hide();
                }
            }
        });
       
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String value) {
        textField.setText(value);
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }

    public void setPromptText(String prompt) {
        textField.setPromptText(prompt);
    }

    public void setSuggestions(List<D> suggestions) {
        this.suggestionList = suggestions;
    }
}