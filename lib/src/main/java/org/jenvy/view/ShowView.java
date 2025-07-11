package org.jenvy.view;

import org.jenvy.interactor.ShowInteractor;
import org.jenvy.model.ShowModel;

import javafx.scene.layout.Region;

public abstract class ShowView extends View{
        

    public ShowView(ShowModel model, ShowInteractor interactor){
        super(model, interactor);
    }

    @Override
    public Region build() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method in ShowView");
    }
}
