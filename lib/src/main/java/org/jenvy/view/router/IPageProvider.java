package org.jenvy.view.router;

import javafx.beans.property.ObjectProperty;

public interface IPageProvider {

    ObjectProperty<Page> currentPage();

    ObjectProperty<Page> prevPage();
    public  void nav(Class<? extends Page> page);

    boolean isRegistered(Class<? extends Page> page);
}
