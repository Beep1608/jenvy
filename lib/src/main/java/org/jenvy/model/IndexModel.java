package org.jenvy.model;



import java.util.List;

import org.jenvy.dto.Dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public abstract class IndexModel<D extends Dto> extends Model {
    private final SimpleListProperty<D> items  = new SimpleListProperty<>();
    private final SimpleListProperty<D> tempItems =new SimpleListProperty<>(FXCollections.observableArrayList());
    private final SimpleStringProperty search = new SimpleStringProperty("");
    private final FilteredList<D> searchedItems = new FilteredList<>(items);
    private final SimpleIntegerProperty pagination = new SimpleIntegerProperty(10);
    private final SimpleIntegerProperty pageCount = new SimpleIntegerProperty(1);
    private final SimpleIntegerProperty index  = new SimpleIntegerProperty(0);
    private final SimpleObjectProperty<D> selectedItem = new SimpleObjectProperty<>();
    private final SimpleBooleanProperty update = new SimpleBooleanProperty(false);
    public IndexModel() { }

    public SimpleListProperty<D> items() {
        return items;
    }

    public ObservableList<D> tempItems() {
        return tempItems.get();
    }

    public IntegerProperty pagination() {
        return pagination;
    }

    public IntegerProperty index(){
        return index;
    }
    
    public IntegerProperty pageCount(){
        return pageCount;
    }

    public FilteredList<D> searchedItems(){
        return searchedItems;
    }

    public StringProperty search(){
        return search;
    }
    public ObjectProperty<D> selectedItem(){
        return selectedItem;
    }

    public void updateTempItems(List<D> newData) {

        tempItems.setAll(newData); 
    }
}