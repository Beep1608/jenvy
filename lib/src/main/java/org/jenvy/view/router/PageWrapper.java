package org.jenvy.view.router;

public class PageWrapper {

    private final Page page;

    private Object[] objects;

    public PageWrapper(Page page, Object... objects){
        this.page = page;
        this.objects = objects;
    }

    public Page page(){
        return this.page;
    }

    public Object[] objects(){
        return this.objects;
    }
}
