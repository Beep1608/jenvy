package org.jenvy.view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public abstract  class View implements Builder<Region> {

    private  IndexView indexView;
    private  CreateView createView;
    private EditView editView;
    private ShowView showView; 

    private final Pane container;

    public  View (
        IndexView indexView,  
        CreateView createView, 
        EditView editView, 
        ShowView showView
    ) 
    {
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
    public View(Region ...views){

        this.container = container();
        container.getChildren().addAll(views);
    
    }

    protected abstract  Pane container();

    @Override
    public Region build() {
       
        return container;
    }
    
}
