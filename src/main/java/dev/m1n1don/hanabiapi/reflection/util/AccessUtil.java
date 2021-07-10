package dev.m1n1don.hanabiapi.reflection.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings({"rawtypes"})
public abstract class AccessUtil
{
    /**
     * Sets the field accessible and removes final modifiers
     *
     * @param field Field to set accessible
     * @return the Field
     * @throws ReflectiveOperationException (usually never)
     */
    public static Field setAccessible(Field field) throws ReflectiveOperationException
    {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & 0xFFFFFFEF);
        return field;
    }

    /**
     * Sets the method accessible
     *
     * @param method Method to set accessible
     * @return the Method
     */
    public static Method setAccessible(Method method)
    {
        method.setAccessible(true);
        return method;
    }

    /**
     * Sets the constructor accessible
     *
     * @param constructor Constructor to set accessible
     * @return the Constructor
     */
    public static Constructor setAccessible(Constructor constructor)
    {
        constructor.setAccessible(true);
        return constructor;
    }

}