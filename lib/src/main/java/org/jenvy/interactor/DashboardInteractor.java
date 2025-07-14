package org.jenvy.interactor;

import org.jenvy.model.DashboardModel;

public class DashboardInteractor extends Interactor {

    public DashboardInteractor(DashboardModel model){
        super(model);
    }

    @Override
    protected  DashboardModel getModel() {
        return (DashboardModel)model;
    }
    
}
