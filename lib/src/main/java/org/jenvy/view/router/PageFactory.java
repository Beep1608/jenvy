package org.jenvy.view.router;

public interface PageFactory {

    IPage page(Class<? extends IPage> pageClass, IPageProvider provider) throws Exception;

    IPage reset(IPage IPage);
}
