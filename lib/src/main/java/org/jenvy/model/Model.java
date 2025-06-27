package org.jenvy.model;

import javafx.beans.property.SimpleBooleanProperty;

public abstract  class Model {
    
    private final SimpleBooleanProperty index = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty create = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty edit= new SimpleBooleanProperty(false);

}
