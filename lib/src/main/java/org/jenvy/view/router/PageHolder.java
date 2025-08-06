package org.jenvy.view.router;

import javafx.beans.property.ReadOnlyObjectProperty;

public interface PageHolder {

    public ReadOnlyObjectProperty<Class<? extends Page>> selectedPageProperty();
    public void loadPage(Class<? extends Page> pageClass);

    public Page page(Class<? extends Page> pageClass);
    public void reset(Class<? extends Page> pageClass);

}
