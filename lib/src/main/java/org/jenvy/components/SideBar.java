package org.jenvy.components;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.jenvy.model.DashboardModel;
import org.kordamp.ikonli.boxicons.BoxiconsLogos;
import org.kordamp.ikonli.boxicons.BoxiconsRegular;
import org.kordamp.ikonli.boxicons.BoxiconsSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class SideBar extends VBox{

    private final NavTree navTree;
    private final NavTree.Item root;
    public SideBar(){
        super();
        this.navTree = new NavTree();
        this.root = NavTree.Item.root();
        navTree.setRoot(root);
        createView();

    }
    public void addChildrenToSideBar(NavTree.Item ...items){
        root.getChildren().addAll(items);
    }

    public ReadOnlyObjectProperty<TreeItem<Nav>> selectionProperty(){
        return navTree.getSelectionModel().selectedItemProperty();
    }
    private void createView(){
        VBox.setVgrow(navTree, Priority.ALWAYS);
        setId("sideber");
        getChildren().addAll(navTree);
    }
}
