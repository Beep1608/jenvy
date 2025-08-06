package org.jenvy.view.router;

public interface PageBus {

     <P extends Page> Page navigate(Class<? extends  P> page);


}
