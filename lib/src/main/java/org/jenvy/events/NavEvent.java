package org.jenvy.events;

import org.jenvy.view.router.IPage;

public class NavEvent extends Event {
    private final Class<? extends IPage> page;

    public NavEvent(Class<? extends IPage> page) {
        this.page =page;
    }

    public Class<? extends IPage> getPage(){
        return page;
    }

    @Override
    public String toString() {
        return "NavEvent{"
                + "page=" + page
                + "} " + super.toString();
    }
}
