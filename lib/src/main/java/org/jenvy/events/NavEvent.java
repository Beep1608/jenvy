package org.jenvy.events;

import org.jenvy.view.router.Page;

public class NavEvent extends Event {
    private final Class<? extends Page> page;

    public NavEvent(Class<? extends Page> page) {
        this.page =page;
    }

    public Class<? extends Page> getPage(){
        return page;
    }

    @Override
    public String toString() {
        return "NavEvent{"
                + "page=" + page
                + "} " + super.toString();
    }
}
