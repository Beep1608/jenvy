package org.jenvy.interactor;

import org.jenvy.model.Model;
 public abstract class   Interactor {
    protected final  Model model;

    public Interactor (Model model){
        this.model = model;
    }

    protected  abstract  Model getModel();


}
