package org.jenvy.utils;

import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;

import java.lang.reflect.Constructor;

public class ReflectionUtils {

    public static Constructor<?> getFirstConstructorWithModelAndInteractor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> c : constructors) {
            Class<?>[] paramTypes = c.getParameterTypes();

            if (paramTypes.length >= 2 &&
                    Model.class.isAssignableFrom(paramTypes[0]) &&
                    Interactor.class.isAssignableFrom(paramTypes[1])) {
                return c; // Encontramos el constructor que empieza con (Model, Interactor, ...)
            }
        }

        // Si no se encontró coincidencia, usar el primer constructor
        if (constructors.length > 0) {
            return constructors[0];
        }

        throw new RuntimeException("No se encontró constructor en " + clazz.getName());
    }

}
