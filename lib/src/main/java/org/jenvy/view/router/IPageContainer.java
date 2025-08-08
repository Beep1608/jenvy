package org.jenvy.view.router;

public interface IPageContainer {

    boolean isInstantiated(Class<? extends Page> pageClass);

    Page page(Class<? extends Page> pageClass);
}
