package tools.utils;

import net.serenitybdd.core.Serenity;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class SerenitySessionUtils {
    public static void saveObjectInSerenitySessionList(String key,Object object){
        if(!Serenity.getCurrentSession().containsKey(key)){
            Serenity.getCurrentSession().put(key,new ArrayList<>());
        }
        ((List<Object>)Serenity.getCurrentSession().get(key)).add(object);
    }

    public static void removeObjectFromSerenitySessionList(String key,Object object){
        ((List<Object>)Serenity.getCurrentSession().get(key)).remove(object);
    }

    public static <T> T getFromSession(String key){
        return (T)Serenity.getCurrentSession().get(key);
    }


    public static void replaceObjectInSerenitySessionList(String key, Object updatedObject, String matchElement, String matchValue)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        @SuppressWarnings("unchecked")
        List<Object> listOfObjects = (List<Object>)Serenity.getCurrentSession().get(key);
        Object oldObject = getObjectByMatchingElement(listOfObjects, matchElement, matchValue);
        listOfObjects.set(listOfObjects.indexOf(oldObject), updatedObject);
    }

    public static Object getObjectByMatchingElement(List<Object> list, String matchElement, String matchValue)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        for (Object obj : list) {
            Object value = PropertyUtils.getProperty(obj, matchElement);
            if (((String)value).contentEquals(matchValue)) {
                return obj;
            }
        }
        return null;
    }
}
