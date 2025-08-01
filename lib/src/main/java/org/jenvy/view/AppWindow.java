package org.jenvy.view;

import atlantafx.base.controls.ModalPane;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.jenvy.utils.NodeUtils;

public class AppWindow extends AnchorPane {
    public static final int MIN_WIDTH = 1200;
    public static final int SIDEBAR_WIDTH = 270;
    public static final String MAIN_MODAL_ID = "modal-pane";

    public AppWindow(){
        var body =new StackPane();
        body.getStyleClass().add("body");

        var modalPane = new ModalPane();
        modalPane.setId(MAIN_MODAL_ID);

        body.getChildren().setAll(modalPane);
        NodeUtils.setAnchors(body, Insets.EMPTY);

        getChildren().add(body);
    }
}
