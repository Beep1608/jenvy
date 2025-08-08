package org.jenvy.interactor;

import org.jenvy.model.Model;
 public abstract class  Interactor {
    protected final  Class<? extends Model> modelClass;

    public Interactor (Class<? extends Model> modelClass){
        this.modelClass = modelClass;
    }

    protected  abstract  Model model();


}
