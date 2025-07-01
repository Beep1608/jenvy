package org.jenvy.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class ShowModel {
    private final SimpleBooleanProperty visible = new SimpleBooleanProperty(false);
    private final  SimpleIntegerProperty id = new SimpleIntegerProperty(0);
   
    public BooleanProperty visible(){
        return  visible;
    }
    public IntegerProperty id(){
        return id;
    }
}
