package org.jenvy.view.router;

import org.jenvy.model.Model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public final class DefaultPageProvider implements PageProvider{

    private Set<Map<Class<? extends Page>, Class<? extends Model>>> pages = new HashSet<>() ;
    private PageBus bus;
    private PageHolder holder;

    public DefaultPageProvider(Map<Class<? extends Page>, Class<? extends Model>> pages){
        this.pages.add(pages);
        this.holder = new DefaultPageHolder();
        this.bus = new DefaultPageBus(holder);
    }

    public Page nav(Class<? extends Page> pageClass){
        return  bus.navigate(pageClass);
    }

}
