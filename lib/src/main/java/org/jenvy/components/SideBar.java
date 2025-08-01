package org.jenvy.components;

import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.jenvy.model.DashboardModel;
import org.kordamp.ikonli.boxicons.BoxiconsLogos;
import org.kordamp.ikonli.boxicons.BoxiconsRegular;
import org.kordamp.ikonli.boxicons.BoxiconsSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class SideBar extends VBox{

    private final NavTree navTree;

    public SideBar(){
        super();
        this.navTree = new NavTree();
        var item =  NavTree.Item.group("Miau",new FontIcon(BoxiconsSolid.ADD_TO_QUEUE));
        item.setExpanded(true);
        var item2 =  NavTree.Item.group("Miau",new FontIcon(BoxiconsSolid.ADJUST));
        var root = NavTree.Item.root();
        root.getChildren().addAll( item,item2);
        navTree.setRoot(root);
        createView();

    }

    private void createView(){
        VBox.setVgrow(navTree, Priority.ALWAYS);
        setId("sideber");
        getChildren().addAll(navTree);
    }
}
