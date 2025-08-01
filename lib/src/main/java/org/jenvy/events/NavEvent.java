package org.jenvy.events;

import javafx.event.EventTarget;
import javafx.event.EventType;
import org.jenvy.components.Page;

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
