package org.jenvy.view.router;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

public abstract class PageProvider implements IPageProvider{

    protected final PageContainer container;
    protected final PageFactory factory;

    PageProvider(PageContainer container, PageFactory factory, Page defaultPage){
        this.container = container;
        this.factory = factory;
        container.addPage(defaultPage);
        defaultPage.setNav(this::nav);
        nav(defaultPage.getClass());
    }



    @Override
    public void nav(Class<? extends Page> pageClass){
        System.out.println("Navegando......");

        System.out.println("Intentando acceder....");
        Page page = container.get(pageClass);
        if ( page == null){
            try{
                Page newPage = factory.page(pageClass, this::nav);
                container.addPage(newPage);
                System.out.println("Se creo correctamente la Page: "+newPage.name());
                container.setCurrentPage(newPage);
                return;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        container.setCurrentPage(page);


        System.out.println("Navegación Hecha");

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
