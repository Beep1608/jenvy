package org.jenvy.view.router;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

public abstract class PageProvider implements IPageProvider{

    protected final PageContainer container;
    protected final PageFactory factory;

    PageProvider(PageContainer container, PageFactory factory){
        this.container = container;
        this.factory = factory;
    }



    @Override
    public void nav(Class<? extends Page> pageClass){
        if (isAccesible(pageClass)) {
            System.out.println("Si es accesble");
            Page page = container.get(pageClass);

            if ( page != null){
                container.setCurrentPage(page);
            }
        }
        System.out.println("Navegación Hecha");

    }

    @Override
    public boolean isAccesible(Class<? extends Page> page){
        Module pageModule = page.getModule();
        String pkg = page.getPackageName();

        return ModuleLayer.boot().modules().stream()
                .filter(m -> m.equals(pageModule))
                .anyMatch(m -> m.isExported(pkg));
    }

    @Override
    public ReadOnlyObjectWrapper<Page> currentPage(){
       return container.currentPage();
    }

    @Override
    public ReadOnlyObjectWrapper<Page> prevPage(){
        return  container.prevPage();
    }

}
