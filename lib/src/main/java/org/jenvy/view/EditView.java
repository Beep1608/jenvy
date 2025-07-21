package org.jenvy.view;

import org.jenvy.components.FormView;
import org.jenvy.interactor.EditInteractor;
import org.jenvy.model.EditModel;

public abstract class EditView extends FormView{
    


    public EditView(EditModel model, EditInteractor interactor){
        super(model, interactor);
    }


    @Override
    protected EditModel getModel(){
        return (EditModel)model;
    }
    
    @Override
    protected  EditInteractor getInteractor(){
      return (EditInteractor) interactor;
    }


    
}
