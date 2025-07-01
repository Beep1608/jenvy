package org.jenvy.view;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public abstract class EditView implements Builder<Region>{
    
    @Override
    public Region build() {
        throw new UnsupportedOperationException("Unimplemented method in EditView");
    }
    
}
