package org.jenvy.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class CreateModel {
    
    private final SimpleBooleanProperty visible = new SimpleBooleanProperty(false);

    public BooleanProperty visible(){
        return  visible;
    }
}
