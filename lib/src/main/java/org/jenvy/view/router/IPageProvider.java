package org.jenvy.view.router;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

public interface IPageProvider {

    ReadOnlyObjectWrapper<Page> currentPage();

    ReadOnlyObjectWrapper<Page> prevPage();
    public  void nav(Class<? extends Page> page);

    boolean isAccesible(Class<? extends Page> page);
}
