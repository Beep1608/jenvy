package org.jenvy.view.router;

import java.util.function.Consumer;

public interface IPageFactory {

    Page page(Class<? extends Page> pageClass, Consumer<Class<? extends Page>> nav) throws Exception;

    Page reset(Page page);
}
