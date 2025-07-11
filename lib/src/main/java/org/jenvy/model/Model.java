package org.jenvy.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public abstract class Model {
    private final SimpleBooleanProperty dbAble = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty visible = new SimpleBooleanProperty(false);

    public BooleanProperty dbAble(){
        return dbAble;
    }

    public BooleanProperty visible(){
        return visible;
    }
}
