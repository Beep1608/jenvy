package org.jenvy.view.router;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public final class DefaultIPageProvider implements IPageProvider {

    private final IPageContainer container;
    private final SimpleObjectProperty<IPage> currentPage = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<IPage> prevPage = new SimpleObjectProperty<>();


    public DefaultIPageProvider(IPageContainer container){
        this.container = container;
    }
    @Override
    public ObjectProperty<IPage> currentPage() {
        return currentPage;
    }

    @Override
    public ObjectProperty<IPage> prevPage() {
        return prevPage;
    }

    @Override
    public void nav(String page) {

      var pageInstance =  container.page(page);

      if(currentPage().isNotNull().get()){
            prevPage().set(currentPage().get());
      }


      currentPage().set(pageInstance);


      System.out.println("Setteando page : "+ pageInstance.name() +" Busqueda : "+ page);
        System.out.println("Current page : "+ currentPage().get().name() +" Busqueda : "+ page);
    }
}
