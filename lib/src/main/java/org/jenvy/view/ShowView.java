package org.jenvy.view;

import org.jenvy.components.FormView;
import org.jenvy.model.ShowModel;

public abstract class ShowView extends FormView{
        

    public ShowView(ShowModel model){
        super(model);
    }

  

    @Override
    protected ShowModel getModel(){
        return (ShowModel)model;
    }


}
