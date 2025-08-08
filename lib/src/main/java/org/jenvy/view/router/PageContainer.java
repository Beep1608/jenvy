package org.jenvy.view.router;

import javafx.beans.property.SimpleObjectProperty;

import java.util.HashSet;
import java.util.Set;

public abstract class PageContainer {

    private final Set<Page> pages = new HashSet<>();
    protected Class<? extends Page> defaultPageClass;

    private final SimpleObjectProperty<Page> currentPage = new SimpleObjectProperty<>();

    private final SimpleObjectProperty<Page> prevPage = new SimpleObjectProperty<>();


}
