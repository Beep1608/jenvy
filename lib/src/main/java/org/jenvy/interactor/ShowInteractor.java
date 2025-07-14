package org.jenvy.interactor;

import org.jenvy.model.ShowModel;

public class ShowInteractor extends Interactor {

    public ShowInteractor(ShowModel model){
        super(model);
    }

    @Override
    public ShowModel getModel() {
       return (ShowModel)model;
    }
    
}
