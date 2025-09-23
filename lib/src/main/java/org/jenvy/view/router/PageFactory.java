package org.jenvy.view.router;

import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.utils.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.function.Consumer;

public abstract  class PageFactory implements IPageFactory {


    public PageFactory() {

    }

    @Override
    public Page page(Class<? extends Page> pageClass, Consumer<Class<? extends Page>> nav) throws Exception {

        Constructor<?> constructor = ReflectionUtils.getFirstConstructorWithModelAndInteractor(pageClass);

        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] parameters = instantiateParameters(parameterTypes, nav);
        Page page = (Page) constructor.newInstance(parameters);
        System.out.println("Nombre Page: " + page.toString());
        page.setNav(nav);

        return page;
    }

    @Override
    public Page reset(Page page) {
        page.reset();
        return page;
    }


    public Object[] instantiateParameters(Class<?>[] parameterTypes, Consumer<Class<? extends Page>> nav) throws Exception {
        Object[] args = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> type = parameterTypes[i];

            if (type == String.class) {
                args[i] = "";
            } else if (type == int.class || type == Integer.class) {
                args[i] = 0;
            } else if (type == boolean.class || type == Boolean.class) {
                args[i] = false;
            } else if (type == double.class || type == Double.class) {
                args[i] = 0.0;
            } else if (type == float.class || type == Float.class) {
                args[i] = 0f;
            } else if (type == long.class || type == Long.class) {
                args[i] = 0L;
            } else if (type.isEnum()) {
                args[i] = type.getEnumConstants()[0];
            }
            // Caso: subclase de Model
            else if (Model.class.isAssignableFrom(type)) {
                args[i] = instantiateWithDefaultConstructor(type);
            }
            // Caso: subclase de Interactor
            else if (Interactor.class.isAssignableFrom(type)) {
                args[i] = instantiateWithDefaultConstructor(type);
            }
            // Caso: subclase de Page
            else if (Page.class.isAssignableFrom(type)) {
                // Aquí puedes incluso reutilizar tu lógica de getFirstConstructor + instantiateParameters
                args[i] = page((Class<? extends Page>) type, nav);


            }
            // Otros objetos genéricos
            else {
                args[i] = instantiateWithDefaultConstructor(type);
            }
        }

        return args;
    }

    /**
     * Intenta instanciar un objeto con constructor vacío
     */
    private Object instantiateWithDefaultConstructor(Class<?> type) {
        try {
            Constructor<?> ctor = type.getDeclaredConstructor();
            ctor.setAccessible(true);
            return ctor.newInstance();
        } catch (Exception e) {
            return null; // no se puede instanciar
        }

    }
}
