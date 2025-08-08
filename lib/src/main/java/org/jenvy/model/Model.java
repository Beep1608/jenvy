package org.jenvy.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.jenvy.view.View;

public abstract class Model {


    public abstract Class<? extends View> getViewClass();
}
