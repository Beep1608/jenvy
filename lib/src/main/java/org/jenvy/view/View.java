package org.jenvy.view;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public abstract  class View implements Builder<Region> {

    
    public View (){
    }
    
    @Override
    public Region build() {
        throw new UnsupportedOperationException("View build() not supported yet.");
    }

    
}
