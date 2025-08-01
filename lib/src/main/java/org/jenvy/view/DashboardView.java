package org.jenvy.view;

import atlantafx.base.controls.ModalPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;
import org.jenvy.components.SideBar;
import org.jenvy.model.DashboardModel;

public abstract class DashboardView extends AnchorPane {

    static final int PAGE_TRANSITION_DURATION = 500;


    private final SideBar sideBar;



    public DashboardView(){
        this.sideBar = new SideBar();
        getChildren().add(sideBar);
    }


    
}
