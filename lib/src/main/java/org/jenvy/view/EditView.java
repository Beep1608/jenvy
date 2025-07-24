package org.jenvy.view;

import org.jenvy.components.FormView;
import org.jenvy.model.EditModel;

public abstract class EditView extends FormView{
    


    public EditView(EditModel model){
        super(model);
    }


    @Override
    protected EditModel getModel(){
        return (EditModel)model;
    }



    
}
