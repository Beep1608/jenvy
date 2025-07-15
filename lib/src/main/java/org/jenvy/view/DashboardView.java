package org.jenvy.view;

import org.jenvy.interactor.DashboardInteractor;
import org.jenvy.model.DashboardModel;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public abstract  class DashboardView extends View {

    protected   Region indexView;
    protected   Region createView;
    protected   Region editView;
    protected   Region showView; 

    private final Pane container;

    public  DashboardView (DashboardModel model,
        DashboardInteractor interactor,
        Region indexView,  
        Region createView, 
        Region editView, 
        Region showView
    ) 
    {
        super(model, interactor);
        this.indexView  = indexView;
        this.createView = createView;
        this.editView = editView;
        this.showView = showView;

        System.out.println("Index :" + indexView );
        System.out.println("Create :" + createView );
        System.out.println("Edit :" + editView );
        System.out.println("Show :" + showView );
        this.container = new StackPane(
            indexView,
            createView,
            editView,
            showView
        );
    }
    public DashboardView(DashboardModel model,
        DashboardInteractor interactor,Region ...views){
        super(model, interactor);
        this.container = container();
        container.getChildren().addAll(views);
    
    }

    protected abstract  Pane container();

    @Override
    public Region build() {
       
        return container;
    }
    
    @Override
    protected DashboardModel getModel(){
        return (DashboardModel)model;
    }
}
