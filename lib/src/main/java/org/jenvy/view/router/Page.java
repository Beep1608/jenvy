package org.jenvy.view.router;

import java.util.function.Consumer;

public abstract class Page {

    private  Consumer<Class<? extends Page>> nav;

    public void setNav(Consumer<Class<? extends Page>> nav){
        this.nav = nav;
    }
    protected void nav(Class<? extends Page> page){
        nav.accept(page);
    }
}
