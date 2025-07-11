package org.jenvy.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class ShowModel extends Model{

    private final  SimpleIntegerProperty id = new SimpleIntegerProperty(0);
   

    public IntegerProperty id(){
        return id;
    }
}
