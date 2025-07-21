package org.jenvy.view;

import org.jenvy.components.FormView;
import org.jenvy.interactor.ShowInteractor;
import org.jenvy.model.ShowModel;

public abstract class ShowView extends FormView{
        

    public ShowView(ShowModel model, ShowInteractor interactor){
        super(model, interactor);
    }

  

    @Override
    protected ShowModel getModel(){
        return (ShowModel)model;
    }

        
    @Override
    protected  ShowInteractor getInteractor(){
      return (ShowInteractor) interactor;
    }
}
