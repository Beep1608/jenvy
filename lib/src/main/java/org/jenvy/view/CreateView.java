package org.jenvy.view;

import org.jenvy.components.FormView;
import org.jenvy.interactor.CreateInteractor;
import org.jenvy.model.CreateModel;

public abstract  class CreateView extends FormView {

   public CreateView (CreateModel model, CreateInteractor interactor){
    super(model, interactor);

   }

   @Override
   protected CreateModel getModel(){
      return (CreateModel)model;
   }
   
   @Override
   protected  CreateInteractor getInteractor(){
      return (CreateInteractor) interactor;
   }

}
