package org.jenvy.interactor;

import org.jenvy.model.CreateModel;

public class CreateInteractor extends Interactor {

    public CreateInteractor(CreateModel model){
        super(model);
    }

    @Override
    protected CreateModel getModel() {
        return (CreateModel)model;
    }
    
}
