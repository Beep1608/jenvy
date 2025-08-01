package org.jenvy.model;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import org.jenvy.components.NavTree;
import org.jenvy.components.Page;
import org.jenvy.events.DefaultEventBus;
import org.jenvy.events.NavEvent;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class DashboardModel {
    public  Class<? extends Page> DEFAULT_PAGE;
    public  Map<Class<? extends Page>, NavTree.Item> NAV_TREE = createNavItems();


    NavTree.Item getTreeItemForPage(Class<? extends Page> pageClass){
        return NAV_TREE.getOrDefault(pageClass,NAV_TREE.get(DEFAULT_PAGE));
    }

    List<NavTree.Item> findPages(String filter){
        return NAV_TREE.values().stream().filter(item -> item.getValue() != null && item.getValue().matches(filter)).toList();
    }

    public DashboardModel(){
        DefaultEventBus.getInstance().subscribe(NavEvent.class, e->navigate(e.getPage()));
    }
    private final ReadOnlyObjectWrapper<Class<? extends  Page>> selectedPage = new ReadOnlyObjectWrapper<>();
    public ReadOnlyObjectProperty<Class<? extends Page>> selectedPageProperty() {
        return selectedPage.getReadOnlyProperty();
    }


    protected  abstract  Map<Class<? extends Page>, NavTree.Item> createNavItems();

    public void  navigate(Class<? extends Page> page ){
        selectedPage.set(Objects.requireNonNull(page));

    }
}
