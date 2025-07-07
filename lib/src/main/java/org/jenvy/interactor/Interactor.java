package org.jenvy.interactor;

import org.jenvy.model.Model;
 public abstract class   Interactor<M extends Model> {
    protected final  M model;

    public Interactor (M model){
        this.model = model;
    }


}
