package org.jenvy.view;

import atlantafx.base.controls.ModalPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;
import org.jenvy.components.MainLayer;
import org.jenvy.components.NavTree;
import org.jenvy.components.SideBar;
import org.jenvy.model.DashboardModel;
import org.jenvy.view.router.DefaultPageProvider;
import org.jenvy.view.router.Page;
import org.jenvy.view.router.PageProvider;
import org.kordamp.ikonli.boxicons.BoxiconsSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public abstract class DashboardView extends HBox {

    static final int PAGE_TRANSITION_DURATION = 500;


    protected final SideBar sideBar;

    protected final MainLayer mainLayer;

    private PageProvider pageProvider;

    protected NavTree.Item prueba = NavTree.Item.group("Prueba", new FontIcon(BoxiconsSolid.ALARM));
    public DashboardView(PageProvider pageProvider){

        this.pageProvider = pageProvider;
        this.sideBar = new SideBar();
        this.mainLayer = new MainLayer();
        sideBar.selectionProperty().addListener((observable, oldValue, newValue) -> {
            if (!(newValue instanceof NavTree.Item item)){
                System.out.println("Miau");
                return;
            }
            if(!item.isGroup()){
                System.out.println("Loading Page");
               Page newPage = pageProvider.nav(item.pageClass());
               mainLayer.loadPage(newPage);

            }
        });
        getChildren().addAll(sideBar, mainLayer);
    }


    
}
