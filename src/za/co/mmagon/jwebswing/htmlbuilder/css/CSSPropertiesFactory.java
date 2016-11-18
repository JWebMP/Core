/*
 * Copyright (C) 2016 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.htmlbuilder.css;

import za.co.mmagon.jwebswing.htmlbuilder.css.image.ImageCSS;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.CSSBlock;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.CSSBlockIdentifier;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.CSSLine;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.CSSTypes;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementTypes;

/**
 * Generates the necessary artifacts for CSS Production
 *
 * @author GedMarc
 * @param <A> 
 * @since 17 Jan 2016
 */
public class CSSPropertiesFactory<A extends Annotation> implements Serializable
{
    @JsonIgnore
    private static final long serialVersionUID = 1l;
    
    private static final org.apache.log4j.Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("CSS Factory");

    /**
     * List of methods to always ignore
     */
    private static final ArrayList<String> IgnoreMethods = new ArrayList(Arrays.asList(new String[]
    {
        "equals", "toString", "hashCode", "annotationType"
    }));
    public static final int DefaultIntValue = -999999;

    

    /**
     * Return an Annotation/Implementation Pair of all CSS Properties defined in the class.
     * Populates the All CSS Class Properties with these
     *
     * @param classAnnotations
     * @return
     */
    protected Map<String, Object> getCSSPropertiesClass(List<Annotation> classAnnotations)
    {
        Map<String, Object> implementedProperties = new HashMap<>();

        classAnnotations.stream().map((classAnnotation) ->
        {
            HashMap<String, Object> cssProperties = new HashMap<>();
            cssProperties.putAll(processAnnotation(classAnnotation));
            return cssProperties;
        }).map((cssProperties) ->
        {
            ArrayList<String> removables = new ArrayList<>();
            cssProperties.entrySet().forEach((entry) ->
            {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value.getClass().getSimpleName().contains("$Proxy"))
                {
                    //System.out.println("proxy");
                    Annotation anotObject = (Annotation) value;
                    HashMap<String, Object> innerProperties = new HashMap<>();
                    innerProperties.putAll(processAnnotation(anotObject));
                    Object anotImplObject = getImplementationObject((Annotation) value, innerProperties);
                    //Pull out empties
                    if (anotImplObject.toString().isEmpty())
                    {
                        removables.add(key);
                    }
                    else
                    {
                        cssProperties.put(key, anotImplObject);
                    }
                }
            });
            removables.forEach(cssProperties::remove);
            
            return cssProperties;
        }).forEachOrdered((cssProperties) ->
        {
            implementedProperties.putAll(cssProperties);
        });
        return implementedProperties;
    }

    /**
     * Returns the CSS Property Map for a given class
     *
     * @param <T>
     * @param objectIn The Object to read CSS Annotations From
     * @return The HashMap of String Object where Object should be rendered with toString()
     */
    public <T extends Object> Map<String, Object> getCSS(T objectIn)
    {
        if (objectIn == null)
        {
            LOG.error("[Action]-[Null Object Retrieved];");
            return null;
        }
        List<Annotation> classAnnotations = getAllAppliedCSSAnnotations(objectIn);
        Map<String, Object> cssPropertyMap = getCSSPropertiesClass(classAnnotations);
        return cssPropertyMap;
    }

    /**
     * Returns the CSS Property Map for a given class
     *
     * @param <T>
     * @param objectIn The Object to read CSS Annotations From
     * @param classAnnotations
     * @return The HashMap of String Object where Object should be rendered with toString()
     */
    public <T extends Object> Map<String, Object> getCSS(T objectIn, Annotation[] classAnnotations)
    {
        if (objectIn == null)
        {
            LOG.error("[Action]-[Null Object Retrieved];");
            return null;
        }
        List<Annotation> anos = new ArrayList<>();
        anos.addAll(Arrays.asList(classAnnotations));
        Map<String, Object> cssPropertyMap = getCSSPropertiesClass(anos);
        return cssPropertyMap;
    }

    /**
     * Returns the CSS Property Map for a given class
     *
     * @param objectIn A direct implementation of the annotation classes
     * @return The HashMap of String Object where Object should be rendered with toString()
     */
    public Map<String, Object> getCSS(CSSImpl objectIn)
    {
        if (objectIn == null)
        {
            LOG.error("[Action]-[Null Object Retrieved];");
            return null;
        }
        ArrayList<Annotation> inner = new ArrayList<>();
        inner.add(objectIn);
        Map<String, Object> cssPropertyMap = getCSSPropertiesClass(inner);
        return cssPropertyMap;
    }

    /**
     * Returns the CSS Property Map for a given field, in a particular object
     *
     * @param fieldIn  The Field To Render CSS FOR
     * @param objectIn The Object which the Field is found
     * @return HashMap of String, Object where Object should be rendered with toString()
     */
    public Map<String, Object> getCSS(Field fieldIn, Object objectIn)
    {
        if (fieldIn == null)
        {
            LOG.error("[Action]-[Null Field Retrieved];");
            return new HashMap<>();
        }
        fieldIn.setAccessible(true);
        try
        {
            if (fieldIn.get(objectIn) == null)
            {
                LOG.error("[Action]-[Null Field Retrieved];");
                return new HashMap<>();
            }
        }
        catch (IllegalArgumentException | IllegalAccessException ex)
        {
            LOG.error("[Action]-[Cant Get Field " + ex.getMessage() + "];");
            return new HashMap<>();
        }

        List<Annotation> classAnnotations = getAllAppliedCSSAnnotations(fieldIn);
        Map<String, Object> cssPropertyMap = getCSSPropertiesClass(classAnnotations);

        return cssPropertyMap;
    }

    /**
     * Produce a CSS Block from the given properties map
     *
     * @param identifier    The Identifier of the CSS Block
     * @param blockType     The Block Type for the Identifier of the Block
     * @param propertiesMap The HashMap of String Object to iterate through
     * @param blockIdentifier
     * @return
     */
    public CSSBlock getCSSBlock(String identifier, CSSTypes blockType, Map<String, Object> propertiesMap, CSSBlockIdentifier blockIdentifier)
    {
        CSSBlock newCSSBlock = new CSSBlock();
        newCSSBlock.setBlockType(blockType);
        newCSSBlock.setIdOfBlock(identifier);
        newCSSBlock.setBlockIdentifer(blockIdentifier);
        newCSSBlock.getCssLines().setRenderBraces(true);
        propertiesMap.entrySet().forEach((entry) ->
        {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value.getClass().isArray())
            {
                Object[] valueArr = (Object[]) value;
                String valueString = "";
                for (Object object : valueArr)
                {
                    Annotation annotatedObject = (Annotation) object;
                    Map<String, Object> innerPropertiesMap = processAnnotation(annotatedObject);
                    Object implementedObject = getImplementationObject(annotatedObject, innerPropertiesMap);
                    if (object instanceof ImageCSS) //special treatment for image arrays for some reason
                    {
                        valueString += implementedObject.toString() + ",";
                    }
                    else
                    {
                        valueString += implementedObject.toString() + " ";
                    }
                }
                valueString = valueString.substring(0, valueString.lastIndexOf(",")).trim();
                newCSSBlock.add(new CSSLine(key, valueString));
            }
            else
            {
                newCSSBlock.add(new CSSLine(key, value.toString()));
            }
        });
        return newCSSBlock;
    }

    /**
     * Produce the original annotation mapping from an annotation
     *
     * @param annotation The annotation to pivot into a HashMap
     * @return
     */
    private Map<String, Object> processAnnotation(Annotation annotation)
    {
        Map<String, Object> output = new HashMap<>();

        if (annotation == null)
        {
            return output;
        }
        Method[] methods = annotation.getClass().getDeclaredMethods();
        for (Method method : methods)
        {
            if (IgnoreMethods.contains(method.getName()))
            {
                continue;
            }
            try
            {
                output.putAll(getPairFromMethod(method, annotation));
            }
            catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
            {
                LOG.error("[Value Generation]-[" + ex.getMessage() + "];[Method]-[" + method.getName() + "];",ex);
            }
        }

        return output;
    }

    /**
     * Return a Key,Value Pair of all CSS Properties defined in the class
     *
     * @return
     */
    private Map<String, Object> getPairFromMethod(Method method, Annotation annotationObject) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Map<String, Object> rawValues = new HashMap<>();
        if (method == null || annotationObject == null)
        {
            return rawValues;
        }
        try
        {
            if (method.getAnnotation(JsonIgnore.class) != null)
            {
                return rawValues;
            }
        }
        catch (NullPointerException npe)
        {
            //correct
        }
        if (method.getName().startsWith("set"))
        {
            return rawValues;
        }

        try
        {
            Object returnedObject = method.invoke(annotationObject, (Object[]) null);
            if (returnedObject == null)
            {
                return rawValues;
            }
            if (returnedObject instanceof CSSEnumeration)
            {
                CSSEnumeration enu = (CSSEnumeration) returnedObject;
                if (enu.equals(enu.getDefault()))
                {
                    return rawValues;
                }
            }
            if (returnedObject.getClass().isArray())
            {
                Object[] objArr = (Object[]) returnedObject;
                if (objArr.length == 0)
                {
                    return rawValues;
                }
            }
            if (returnedObject instanceof MeasurementCSS)
            {
                MeasurementCSS m = (MeasurementCSS) returnedObject;
                if (m.MeasurementType().equals(MeasurementTypes.Pixels) && m.value() == -999999)
                {
                    return rawValues;
                }
            }
            if (returnedObject instanceof Integer)
            {
                if (returnedObject.equals(CSSPropertiesFactory.DefaultIntValue))
                {
                    return rawValues;
                }
            }
            rawValues.put(method.getName(), returnedObject);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            String s = e.getLocalizedMessage();
            if (s == null)
            {
                //expected to not run
            }
            else
            {
                LOG.trace("Field Skipped [" + method.getName() + "] - [" + e.getLocalizedMessage() + "]",e);
            }
        }
        return rawValues;
    }

    /**
     * Returns the implementation object populated for the annotation provided
     *
     * @param cssAnnotation The annotation to process
     * @param fieldMapping  The field mappings for the annotation @see get
     * @return
     */
    private Object getImplementationObject(Annotation cssAnnotation, Map<String, Object> fieldMapping)
    {
        Object newInstance = null;
        String implementationClass = cssAnnotation.annotationType().toString().replaceAll("interface ", "") + "Impl";
        //System.out.println(implementationClass);
        try
        {
            newInstance = Class.forName(implementationClass).newInstance();
            for (Map.Entry<String, Object> entry : fieldMapping.entrySet())
            {
                String field = entry.getKey();
                Object fieldObject = entry.getValue();
                //LOG.trace("Trying Field [" + field + "]");
                Field f = newInstance.getClass().getDeclaredField(field);
                f.setAccessible(true);
                if (fieldObject instanceof CSSEnumeration)
                {
                    f.set(newInstance, fieldObject);
                }
                else if (fieldObject instanceof Annotation)
                {
                    String fieldTypes = f.getType().getName();
                    Annotation innerAnnotation = (Annotation) fieldObject;
                    Map<String, Object> innerFieldMapping = processAnnotation(innerAnnotation);
                    Object innerImplementationObject = getImplementationObject(innerAnnotation, innerFieldMapping);
                    f.set(newInstance, innerImplementationObject);
                }
                else if (fieldObject instanceof Integer)
                {
                    if (Integer.class.cast(fieldObject) == DefaultIntValue) //don't run for default value integers
                    {
                        continue;
                    }
                    f.set(newInstance, fieldObject);
                }
                else if (fieldObject.getClass().isPrimitive())
                {
                    f.set(newInstance, fieldObject);
                }
                else if (fieldObject instanceof String || fieldObject instanceof Long || fieldObject instanceof Double || fieldObject instanceof Boolean || fieldObject instanceof BigDecimal)
                {
                    f.set(newInstance, fieldObject);
                }
                else if (fieldObject.getClass().isArray())
                {
                    Object[] arrayObject = (Object[]) fieldObject;
                    for (int i = 0; i < arrayObject.length; i++)
                    {
                        Object object = arrayObject[i];
                        Annotation innerAnnotation = (Annotation) object;
                        Map<String, Object> innerFieldMapping = processAnnotation(innerAnnotation);
                        Object innerImplementationObject = getImplementationObject(innerAnnotation, innerFieldMapping);
                        ((Object[]) (fieldObject))[i] = innerImplementationObject;
                    }
                    f.set(newInstance, fieldObject);
                }
                else
                {
                    LOG.error("[Instantiation]-[No Implementation Change Occured " + field + "]");
                    f.set(newInstance, fieldObject);
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            LOG.error("[Instantiation]-[Failed " + implementationClass + "]", ex);
        }
        catch (NoSuchFieldException | SecurityException ex)
        {
            LOG.error("[Field Populator]-[Failed]", ex);
        }

        return newInstance;
    }

    /**
     * Return a Key,Value Pair of all CSS Properties defined in the fields
     *
     * @param cssObjectIn
     * @return
     */
    protected Map<String, String> getCSSPropertiesFields(Object cssObjectIn)
    {
        if (cssObjectIn == null)
        {
            LOG.error("[Action]-[Null Object Retrieved];");
            return null;
        }
        Map<String, String> cssProperties = new HashMap<>();

        return cssProperties;
    }

    /**
     * Returns all annotations for a field that end with 'CSS'
     *
     * @param <A>         CSS Annotations
     * @param <T>
     * @param cssObjectIn The class to get the annotations from
     * @return ArrayList of all applicable CSS annotations
     */
    protected <A extends Annotation, T extends Object> ArrayList<A> getAllAppliedCSSAnnotations(T cssObjectIn)
    {
        Class clazz = cssObjectIn.getClass();
        ArrayList<A> annotations = new ArrayList();
        Annotation[] annos = clazz.getAnnotations();
        for (Annotation annotation : annos)
        {
            if (annotation.annotationType().isAnnotationPresent(CSSAnnotationType.class))
            {
                annotations.add((A) annotation);
            }
        }
        return annotations;
    }

    /**
     * Returns all annotations for a field that end with 'CSS'
     *
     * @param <A>   CSS Annotations
     * @param field Field to return for
     * @return ArrayList of all applicable CSS annotations
     */
    protected <A extends Annotation> List<A> getAllAppliedCSSAnnotations(Field field)
    {
        List<A> annotations = new ArrayList();
        Annotation[] annos = field.getAnnotations();
        for (Annotation annotation : annos)
        {
            if (annotation.annotationType().isAnnotationPresent(CSSAnnotationType.class))
            {
                annotations.add((A) annotation);
            }
        }
        return annotations;
    }
}
