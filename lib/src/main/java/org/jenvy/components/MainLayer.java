package org.jenvy.components;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.jenvy.model.Model;
import org.jenvy.utils.NodeUtils;
import org.jenvy.view.router.Page;
import org.jenvy.view.router.PageProvider;

import java.util.Objects;

public class MainLayer extends VBox implements Page {
    private static final int OUTLINE_WIDTH = 200;



    public MainLayer(){
        super();
        this.getChildren().add(new DefaultPage());
        createLayout();
    }

    private void createLayout(){
       //StackPane.setMargin(userContent, new Insets(0,OUTLINE_WIDTH,0,0));
       //userContent.setMinWidth(Page.MAX_WIDTH - OUTLINE_WIDTH);
       //userContent.setMaxWidth(Page.MAX_WIDTH - OUTLINE_WIDTH);

       //scrollPane.setContent(userContentArea);
       //NodeUtils.setScrollConstraints(scrollPane, ScrollPane.ScrollBarPolicy.AS_NEEDED, true, ScrollPane.ScrollBarPolicy.NEVER, true);
       //scrollPane.setMaxHeight(20_000);

        var pageBody = new StackPane();
        pageBody.setMinWidth(Page.MAX_WIDTH);
        pageBody.setStyle("-fx-background-color: red;");
        System.out.println("Se creo pageBody");
        getChildren().add(pageBody);
    }
    public void loadPage(Page page){

        Page prevPage =(Page) this.getChildren().stream().filter(c -> c instanceof Page)
                .findFirst().orElse(null);

        if(getScene() == null){
            this.getChildren().add(page.getView());
            return;
        }

        Objects.requireNonNull(prevPage);

        prevPage.reset();
        System.out.println("Nuava page : "+ page.getName());

        this.getChildren().add(page.getView());
        this.getChildren().remove(prevPage.getView());
    }

    @Override
    public String getName() {
        return "MainLayer";
    }

    @Override
    public Parent getView() {
        return this;
    }

    @Override
    public void reset() {
        System.out.println("Reset Main layer");
    }
}
