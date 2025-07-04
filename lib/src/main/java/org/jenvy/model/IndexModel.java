package org.jenvy.model;



import org.jenvy.dto.Dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;

public abstract  class IndexModel<D extends Dto>{
    private final  SimpleBooleanProperty table = new SimpleBooleanProperty(true);
    private final SimpleListProperty<D> items  = new SimpleListProperty<>();
    private final SimpleListProperty<D> tempItems = new SimpleListProperty<>();
    private final SimpleIntegerProperty pagination = new SimpleIntegerProperty();

    public IndexModel(){

    }

    public SimpleListProperty<D> items(){
        return items;
    }
    public IntegerProperty pagination(){
        return pagination;
    }
    public SimpleListProperty<D> tempItems(){
        return tempItems;
    }

    
}
