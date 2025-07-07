package org.jenvy.model;



import org.jenvy.dto.Dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;

public abstract class IndexModel<D extends Dto> extends Model {
    private final SimpleListProperty<D> items  = new SimpleListProperty<>();
    private final SimpleListProperty<D> tempItems = new SimpleListProperty<>();
    private final SimpleIntegerProperty pagination = new SimpleIntegerProperty(10);
    private final SimpleIntegerProperty index  = new SimpleIntegerProperty(0);

    public IndexModel() { }

    public SimpleListProperty<D> items() {
        return items;
    }

    public SimpleListProperty<D> tempItems() {
        return tempItems;
    }

    public IntegerProperty pagination() {
        return pagination;
    }

    public IntegerProperty index(){
        return index;
    }
}