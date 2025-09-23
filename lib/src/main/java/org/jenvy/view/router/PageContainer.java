package org.jenvy.view.router;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class PageContainer {

    public PageContainer(){
    }

    final Map<Class<? extends Page>, Set<Class<? extends  Page>>> slides =  new HashMap<>();
    private final Set<Page> pages = new HashSet<>();
    public void addPage(Page page){
        if(!pages.contains(page)){
            pages.add(page);
            System.out.println("Se agregó correctamente la Page : "+ page.name());
        }
    }
    protected Class<? extends Page> defaultPageClass;

    private final ReadOnlyObjectWrapper<Page> currentPage = new ReadOnlyObjectWrapper<>();

    private final ReadOnlyObjectWrapper<Page> prevPage = new ReadOnlyObjectWrapper<>();

    public ReadOnlyObjectWrapper<Page> currentPage(){
        return currentPage;
    }

    public ReadOnlyObjectWrapper<Page> prevPage(){
        return prevPage;
    }
    public Page getCurrenPage(){
        return currentPage.get();
    }

    public void setCurrentPage(Page page){
        currentPage.set(page);
    }

    public void printAllPages(){
        pages.stream().forEach(p -> System.out.println(p.name()));
    }
    public Page get(Class< ? extends Page> pageClass){
        return pages.stream()
                .filter(p -> p.getClass() == pageClass)
                .findFirst()
                .orElse(null);

    }

    public boolean isSlide(Class<? extends Page> pageClass ,Class<? extends Page> sliderClass){
        return slides.containsKey(pageClass) && slides.get(pageClass).contains(sliderClass);
    }


}
