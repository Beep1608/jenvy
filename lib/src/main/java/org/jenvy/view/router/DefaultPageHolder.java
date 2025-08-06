package org.jenvy.view.router;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

import java.util.Objects;

public final class DefaultPageHolder implements PageHolder {

    private final ReadOnlyObjectWrapper<Class<? extends Page >> selectedPage = new ReadOnlyObjectWrapper<>();
    public ReadOnlyObjectProperty<Class<? extends Page>> selectedPageProperty() {
        return selectedPage.getReadOnlyProperty();
    }


    @Override
    public void loadPage(Class<? extends Page> pageClass) {
        Objects.requireNonNull(pageClass);
        if(  selectedPageProperty().isNotNull().get()){
            reset(pageClass);
        }

        selectedPage.set(pageClass);

    }

    @Override
    public Page page(Class<? extends Page> pageClass) {
        try{
            loadPage(pageClass);
           return selectedPage.get().getDeclaredConstructor().newInstance();
        }catch (Exception e){
            throw new RuntimeException("No se pudo instanciar la página: " + selectedPage.get().getName(), e);
        }
    }

    @Override
    public void reset(Class<? extends Page> pageClass) {
        System.out.println("Reset de : "+ pageClass.getName());

    }
}
