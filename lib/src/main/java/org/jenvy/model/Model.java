package org.jenvy.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public abstract  class Model {
    
    private final SimpleBooleanProperty visible = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty index = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty create = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty edit = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty show = new SimpleBooleanProperty(false);

    public BooleanProperty visible(){
        return  visible;
    }
    
    public BooleanProperty index(){
        return  index;
    }

    public BooleanProperty create(){
        return create;
    }

    public BooleanProperty edit(){
        return  edit;
    }

    public BooleanProperty show(){
        return  show;
    }

}
