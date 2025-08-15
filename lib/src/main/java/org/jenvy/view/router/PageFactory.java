package org.jenvy.view.router;

import java.util.function.Consumer;

public abstract  class PageFactory implements IPageFactory {



    public PageFactory(){

    }

    @Override
    public Page page(Class<? extends Page> pageClass, Consumer<Class<? extends Page>> nav) throws Exception {
        System.out.println("AbstractPageFctory -> " + pageClass.getName() );
        Page page =  (Page)  pageClass.getDeclaredConstructor().newInstance();
        System.out.println("Nombre Page: "+ page.toString());
        page.setNav(nav);

      return page;
    }

    @Override
    public Page reset(Page page) {
        page.reset();
        return page;
    }


}
