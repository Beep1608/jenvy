package org.jenvy.view.router;

public interface PageProvider {

    public abstract Page nav(Class<? extends Page> pageClass);
}
