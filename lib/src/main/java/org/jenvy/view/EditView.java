package org.jenvy.view;

import org.jenvy.interactor.EditInteractor;
import org.jenvy.model.EditModel;

import javafx.scene.layout.Region;

public abstract class EditView extends View{
    
    public EditView(EditModel model, EditInteractor interactor){
        super(model, interactor);

    }
    @Override
    public Region build() {
        throw new UnsupportedOperationException("Unimplemented method in EditView");
    }
    
}
