package za.co.mmagon.jwebswing.htmlbuilder.css;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import za.co.mmagon.*;

/**
 * Converts an annotation to it's Impl class (In the same folder?)
 * @author Marc Magon
 * @param <A> The annotation
 * @param <O> The destination Impl class
 */
public class CSSAnnotationToClass<A extends Annotation,O extends Object>
{

    private static final org.apache.log4j.Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("CSSAnnotationHandler");

    private static final ArrayList<String> ignoredAnnotationClassMethods = new ArrayList(Arrays.asList(new String[]
    {
        "equals", "toString", "hashCode", "annotationType"
    }));

    public static synchronized <A, C> C copyFieldsFrom(Object annotation, C classToCopyTo)
    {
        C returnable;

        Method[] methods = ((Annotation) annotation).annotationType().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            Method getMethod = methods[i];
            if (ignoredAnnotationClassMethods.contains(getMethod.getName()))
            {
                continue;
            }

            try
            {
                Object getValue;
                getValue = getMethod.invoke(annotation, (Object[]) null);

                String setName = "set" + getMethod.getName();
                if (!getMethod.getReturnType().getSimpleName().endsWith("CSS"))
                {
                    Method setMethod = classToCopyTo.getClass().getDeclaredMethod(setName, getMethod.getReturnType());
                    setMethod.invoke(classToCopyTo, getValue);
                }
                else
                {
                    Annotation anno = (Annotation) getValue;
                    String returnType = anno.annotationType().getSimpleName();
                    String returnTypeImpl = "za.co.mmagon.jwebswing.htmlbuilder.css.accessors." + returnType + "Impl";
                    Class clazz;
                    clazz = Class.forName(returnTypeImpl);
                    Method setMethod = classToCopyTo.getClass().getDeclaredMethod(setName, clazz);
                    //System.out.println("Method is : " + setMethod + " - With Object - " + getValue.getClass().getSimpleName());
                    if (clazz.getSimpleName().endsWith("Impl"))
                    {
                        Object o = clazz.newInstance();
                        copyFieldsFrom(getValue, o);
                        setMethod.invoke(classToCopyTo, o);
                    }
                }
            }
            catch (InstantiationException ex)
            {
                log.trace("Unable to retrieve CSS from the field - Instantiation Exception.\n", ex);
            }
            catch (ClassNotFoundException ex)
            {
                log.trace("Unable to retrieve CSS from the field - Class not found.\n", ex);
            }
            catch (NoSuchMethodException ex)
            {
                log.trace("Unable to retrieve CSS from the field - No Such Method. Missing get/set methods?.\n", ex);
            }
            catch (SecurityException ex)
            {
                log.trace("Unable to retrieve CSS from the field - Security Exception. Hmmmm.....\n", ex);
            }
            catch (IllegalAccessException ex)
            {
                log.trace("Unable to retrieve CSS from the field - Security Exception&IllegalAccessException. Hmmmm.....\n", ex);
            }
            catch (IllegalArgumentException ex)
            {
                log.trace("Unable to retrieve CSS from the field - Illegal Argument Exception... get method has no paramters \n", ex);
            }
            catch (InvocationTargetException ex)
            {
                log.trace("Couldn't invoke on the object. Null?", ex);
            }
        }
        return classToCopyTo;
    }
}
