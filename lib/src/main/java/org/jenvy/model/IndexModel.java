package org.jenvy.model;



import org.jenvy.dto.Dto;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract  class IndexModel<D extends Dto>{
    private final  SimpleBooleanProperty table = new SimpleBooleanProperty(true);
    private final SimpleListProperty<D> elements  = new SimpleListProperty<>();
    private final ObservableList<D> items =  FXCollections.observableArrayList(elements);

    public IndexModel(){

    }

    protected abstract SimpleListProperty<D> initColumns();

    public SimpleListProperty<D> elements(){
        return elements;
    }
    public ObservableList<D> items(){
        return items;
    }
    
}
