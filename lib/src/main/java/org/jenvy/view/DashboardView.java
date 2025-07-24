package org.jenvy.view;

import org.jenvy.model.DashboardModel;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public abstract  class DashboardView extends View {

    protected   IndexView indexView;
    protected   CreateView createView;
    protected   EditView editView;
    protected   ShowView showView; 

    private final Pane container;

    public  DashboardView (DashboardModel model,
        IndexView indexView,  
        CreateView createView, 
        EditView editView, 
        ShowView showView
    ) 
    {
        super(model);
        this.indexView  = indexView;
        this.createView = createView;
        this.editView = editView;
        this.showView = showView;

        this.container = new StackPane(
            indexView.build(),
            createView.build(),
            editView.build(),
            showView.build()
        );
    }
    public DashboardView(DashboardModel model,Region ...views){
        super(model);
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
