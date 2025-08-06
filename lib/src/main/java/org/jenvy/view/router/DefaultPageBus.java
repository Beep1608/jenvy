package org.jenvy.view.router;

import org.jenvy.events.DefaultEventBus;

import java.util.Objects;

public final class DefaultPageBus implements PageBus{
    private PageHolder holder;
    public DefaultPageBus(PageHolder holder){
        this.holder = holder;
    }

    @Override
    public <P extends Page> Page navigate(Class<? extends P> page) {
        Objects.requireNonNull(page);
       return holder.page(page);
    }

}
