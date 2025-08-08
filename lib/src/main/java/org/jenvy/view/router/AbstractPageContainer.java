package org.jenvy.view.router;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPageContainer implements IPageContainer {


    protected final  Map<String, Class<? extends IPage>> pagesMap;

    protected AbstractPageContainer( Map<String, Class<? extends IPage>> pagesMap){
        long uniqueValues = pagesMap.values().stream().distinct().count();
        if (uniqueValues != pagesMap.size()) {
            throw new IllegalArgumentException("Los valores del pagesMap deben ser únicos");
        }

        this.pagesMap = new HashMap<>(pagesMap); //Copia de pagesMap
    }


}
