package com.miqt.wand;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    static Map<Class, String> holder = new HashMap<>();

    public static <T> T make(String classname, Object... pram) {
        try {
            Class<T> ap = (Class<T>) Wand.get().getClassLoader()
                    .loadClass(classname);
            T o = null;
            if (pram.length == 0) {
                o = ap.newInstance();
            } else {
                Class[] aClass = new Class[pram.length];
                for (int i = 0; i < aClass.length; i++) {
                    aClass[i] = pram[i].getClass();
                }
                o = ap.getConstructor(aClass).newInstance(pram);
            }
            return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T make(String classname) {
        return make(classname, null, null);
    }
}