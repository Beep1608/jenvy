package org.jenvy.view.router;

import java.util.HashMap;
import java.util.Map;

public final class DefaultPageContainer extends AbstractPageContainer {

    private Class<? extends IPage> defaultPageClass;
    private IPage defaultIPageInstance;

    private final Map<Class<? extends IPage>, IPage> pageInstances = new HashMap<>();

    public DefaultPageContainer(Map<String, Class<? extends IPage>> pagesMap , Class<? extends IPage> defaultPage){
        super(pagesMap);
        defaultPageClass = defaultPage;
    }



    @Override
    public Class<? extends IPage> getPageClass(String pageName) {
        if(!isRegistered(pageName)){
            return defaultPageClass;
        }

        return  pagesMap.get(pageName);
    }

    @Override
    public boolean isRegistered(String pageName) {
        System.out.println("Esta registrada ? : "+pagesMap.containsKey(pageName) );
        return pagesMap.containsKey(pageName);
    }

    @Override
    public boolean isInstantiated(Class<? extends IPage> pageClass) {
        return pageInstances.containsKey(pageClass);
    }

    @Override
    public IPage page(String pageName) {

        try{
            System.out.println("Intentando obtener Class");
            Class<? extends IPage> pageClass = getPageClass(pageName);
            System.out.println("Class obtenida : "+ pageClass.getName());
            if(pageClass.equals(defaultPageClass)){
                System.out.println("Primer If");
                this.defaultIPageInstance =  DefaultPageFactory.create(defaultPageClass);
                System.out.println("Clase default hecha");
                return defaultIPageInstance;
            }

            if(isInstantiated(pageClass)){
                System.out.println("Segundo If");
                return pageInstances.get(pageClass);
            }
            System.out.println("Iniciando creacion");
            IPage newIPage = DefaultPageFactory.create(pageClass);
            System.out.println("Creado");
            pageInstances.put(pageClass, newIPage);
            return newIPage;

        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo obtener la Page: " + pageName);
        }
    }
}
