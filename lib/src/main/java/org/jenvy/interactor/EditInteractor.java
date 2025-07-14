package org.jenvy.interactor;

import org.jenvy.model.EditModel;

public class EditInteractor extends Interactor{

    public EditInteractor(EditModel model){
        super(model);
    }

    @Override
    public EditModel getModel() {
        return (EditModel)model;
    }
    
}
