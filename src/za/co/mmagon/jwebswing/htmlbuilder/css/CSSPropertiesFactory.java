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

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.CSSTypes;
import za.co.mmagon.jwebswing.htmlbuilder.css.image.ImageCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;
import za.co.mmagon.logger.LogFactory;

/**
 * Generates the necessary artifacts for CSS Production
 *
 * @author GedMarc
 * @param <A>
 *
 * @since 17 Jan 2016
 */
public class CSSPropertiesFactory<A extends Annotation> implements Serializable
{

    @JsonIgnore
    private static final long serialVersionUID = 1l;
    /**
     * The default logger
     */
    private static final java.util.logging.Logger log = LogFactory.getInstance().getLogger("CSS Factory");

    /**
     * List of methods to always ignore
     */
    private static final ArrayList<String> IgnoreMethods = new ArrayList(Arrays.asList(new String[]
    {
        "equals", "toString", "hashCode", "annotationType"
    }));

    public static final int DefaultIntValue = Integer.MIN_VALUE;

    /**
     * Return an Annotation/Implementation Pair of all CSS Properties defined in the class. Populates the All CSS Class Properties with these
     *
     * @param classAnnotations
     *
     * @return
     */
    public Map<StringBuilder, Object> getCSSProperties(List<Annotation> classAnnotations)
    {
        Map<StringBuilder, Object> implementedProperties = new HashMap<>();
        final Map<StringBuilder, Object> implementedProperties2 = new HashMap<>();
        classAnnotations.stream().filter(a -> a != null).forEach(classAnnotation ->
        {
            HashMap<StringBuilder, Object> cssProperties = new HashMap<>();
            cssProperties.putAll(processAnnotation(classAnnotation));
            Object anotImplObject = getImplementationObject((Annotation) classAnnotation, cssProperties);
            Map mmm = processImplementationObjectFields((CSSImplementationClass) anotImplObject, implementedProperties);
            implementedProperties2.putAll(mmm);
        });
        return implementedProperties2;
    }

    /**
     * Return an Annotation/Implementation Pair of all CSS Properties defined in the class. Populates the All CSS Class Properties with these
     *
     * @param classAnnotations
     *
     * @return
     */
    public Map<StringBuilder, Object> getCSSProperties(CSSImplementationClass classAnnotations)
    {
        Map impObject = processImplementationObjectFields(classAnnotations, new HashMap<>());
        return impObject;
    }

    /**
     * Return an Annotation/Implementation Pair of all CSS Properties defined in the class. Populates the All CSS Class Properties with these
     *
     * @param classImpl
     *
     * @return
     */
    public Map<StringBuilder, Object> getCSSProperties(CSSImpl classImpl)
    {
        Map<StringBuilder, Object> m = new HashMap<>();
        Field[] fields = classImpl.getClass().getDeclaredFields();
        for (Field field : fields)
        {
            if (field.getModifiers() == 26)
            {
                continue;
            }
            field.setAccessible(true);
            try
            {
                Object obj = field.get(classImpl);
                if (obj == null)
                {
                    continue;
                }
                if (CSSImplementationClass.class.isAssignableFrom(obj.getClass()))
                {
                    m.putAll(getCSSProperties(CSSImplementationClass.class.cast(obj)));
                }
            }
            catch (IllegalArgumentException | IllegalAccessException ex)
            {
                Logger.getLogger(CSSPropertiesFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return m;
    }

    /**
     * Returns the CSS Property Map for a given class
     *
     * @param <T>
     * @param objectIn The Object to read CSS Annotations From
     *
     * @return The HashMap of String Object where Object should be rendered with toString()
     */
    public <T extends Object> Map<StringBuilder, Object> getCSS(T objectIn)
    {
        if (objectIn == null)
        {
            log.log(Level.SEVERE, "[Action]-[Null Object Retrieved];");
            return null;
        }
        if (objectIn instanceof CSSImpl)
        {
            Map<StringBuilder, Object> map = getCSSProperties((CSSImpl) objectIn);
            return map;
        }

        List<Annotation> classAnnotations = getAllAppliedCSSAnnotations(objectIn);
        Map<StringBuilder, Object> cssPropertyMap = getCSSProperties(classAnnotations);
        return cssPropertyMap;
    }

    /**
     * Returns the CSS Property Map for a given class
     *
     * @param <T>
     * @param objectIn         The Object to read CSS Annotations From
     * @param classAnnotations
     *
     * @return The HashMap of String Object where Object should be rendered with toString()
     */
    public <T extends Object> Map<StringBuilder, Object> getCSS(T objectIn, Annotation[] classAnnotations)
    {
        if (objectIn == null)
        {
            log.log(Level.SEVERE, "[Action]-[Null Object Retrieved];");
            return null;
        }
        List<Annotation> anos = new ArrayList<>();
        anos.addAll(Arrays.asList(classAnnotations));
        Map<StringBuilder, Object> cssPropertyMap = getCSSProperties(anos);
        return cssPropertyMap;
    }

    /**
     * Returns the CSS Property Map for a given field, in a particular object
     *
     * @param fieldIn  The Field To Render CSS FOR
     * @param objectIn The Object which the Field is found
     *
     * @return HashMap of String, Object where Object should be rendered with toString()
     */
    public Map<StringBuilder, Object> getCSS(Field fieldIn, Object objectIn)
    {
        if (fieldIn == null)
        {
            log.log(Level.SEVERE, "[Action]-[Null Field Retrieved];");
            return new HashMap<>();
        }
        fieldIn.setAccessible(true);
        try
        {
            if (fieldIn.get(objectIn) == null)
            {
                log.log(Level.SEVERE, "[Action]-[Null Field Retrieved];");
                return new HashMap<>();
            }
        }
        catch (IllegalArgumentException | IllegalAccessException ex)
        {
            log.log(Level.SEVERE, "[Action]-[Cant Get Field {0}];", ex.getMessage());
            return new HashMap<>();
        }

        List<Annotation> classAnnotations = getAllAppliedCSSAnnotations(fieldIn);
        Map<StringBuilder, Object> cssPropertyMap = getCSSProperties(classAnnotations);

        return cssPropertyMap;
    }

    /**
     * Produce a CSS Block from the given properties map
     *
     * @param identifier      The Identifier of the CSS Block
     * @param blockType       The Block Type for the Identifier of the Block
     * @param propertiesMap   The HashMap of String Object to iterate through
     * @param blockIdentifier
     *
     * @return
     */
    public CSSBlock getCSSBlock(String identifier, CSSTypes blockType, Map<StringBuilder, Object> propertiesMap, CSSBlockIdentifier blockIdentifier)
    {
        CSSBlock newCSSBlock = new CSSBlock();
        newCSSBlock.setBlockType(blockType);
        newCSSBlock.setIdOfBlock(identifier);
        newCSSBlock.setBlockIdentifer(blockIdentifier);
        newCSSBlock.getCssLines().setRenderBraces(true);
        propertiesMap.entrySet().forEach(entry ->
        {
            StringBuilder key = entry.getKey();
            Object value = entry.getValue();

            StringBuilder cssKey = new StringBuilder();
            if (value.getClass().isArray())
            {
                Object[] valueArr = (Object[]) value;
                String valueString = "";
                for (int i = 0; i < valueArr.length; i++)
                {
                    Object object = valueArr[i];
                    Object implementedObject;
                    if (object != null)
                    {
                        if (object.getClass().isAnnotation())
                        {
                            Annotation annotatedObject = (Annotation) object;
                            //Field names
                            Map<StringBuilder, Object> innerPropertiesMap = processAnnotation(annotatedObject);
                            implementedObject = getImplementationObject(annotatedObject, innerPropertiesMap);
                        }
                        else
                        {
                            implementedObject = object;
                        }

                        valueArr[i] = implementedObject;
                        if (object instanceof ImageCSS) //special treatment for image arrays for some reason
                        {
                            valueString += implementedObject.toString() + ",";
                        }
                        else
                        {
                            valueString += implementedObject.toString() + " ";
                        }
                    }
                }

                if (!valueString.isEmpty() && valueString.contains(","))
                {
                    valueString = valueString.substring(0, valueString.lastIndexOf(",")).trim();
                }
                newCSSBlock.add(new CSSLine(key.toString(), valueString));
            }
            else
            {

                newCSSBlock.add(new CSSLine(key.toString(), value.toString()));
            }
        });
        return newCSSBlock;
    }

    /**
     * Returns a map for the process implementation
     *
     * @param impClass
     * @param currentReturnList
     *
     * @return
     */
    public Map<StringBuilder, Object> processImplementationObjectFields(CSSImplementationClass impClass, Map<StringBuilder, Object> currentReturnList)
    {
        if (impClass == null)
        {
            return currentReturnList;
        }

        Field[] allFields = impClass.getClass().getDeclaredFields();
        List<Field> fields = Arrays.asList(allFields);
        fields.forEach(field ->
        {
            try
            {
                Map<StringBuilder, Object> map = getPairFromField(field, impClass);
                map.entrySet().forEach((entry) ->
                {
                    StringBuilder key = entry.getKey();
                    Object value = entry.getValue();
                    currentReturnList.put(key, value);
                });
            }
            catch (IllegalArgumentException | IllegalAccessException ex)
            {
                log.log(Level.FINE, "Unable to read pair from field due to permission", ex);
            }
        });

        return currentReturnList;
    }

    /**
     * Produce the original annotation mapping from an annotation
     *
     * @param annotation The annotation to pivot into a HashMap
     *
     * @return
     */
    public Map<StringBuilder, Object> processAnnotation(Annotation annotation)
    {
        Map<StringBuilder, Object> output = new HashMap<>();

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
                output.putAll(getPairFromAnnotationMethod(method, annotation));
            }
            catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
            {
                log.log(Level.SEVERE, "[Value Generation]-[" + ex.getMessage() + "];[Method]-[" + method.getName() + "];", ex);
            }
        }

        return output;
    }

    /**
     * Return a Key,Value Pair of all CSS Properties defined in the class
     *
     * @return
     */
    private Map<StringBuilder, Object> getPairFromAnnotationMethod(Method method, Annotation annotationObject)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Map<StringBuilder, Object> rawValues = new HashMap<>();
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
        if (method.getName().startsWith("set") || method.getName().startsWith("get"))
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
                if (m.MeasurementType().equals(MeasurementTypes.Pixels) && m.value() == CSSPropertiesFactory.DefaultIntValue)
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
            rawValues.put(new StringBuilder(method.getName()), returnedObject);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            log.log(Level.FINE, "Field Skipped [" + method.getName() + "] - [" + e.getLocalizedMessage() + "]", e);
        }
        return rawValues;
    }

    /**
     * Return a Key,Value Pair of all CSS Properties defined in the class
     *
     * @return
     */
    private Map<StringBuilder, Object> getPairFromField(Field field, CSSImplementationClass cssImplementationClass)
            throws IllegalArgumentException, IllegalAccessException
    {
        Map<StringBuilder, Object> rawValues = new HashMap<>();
        if (field.getModifiers() == 26) //static
        {
            return rawValues;
        }

        if (field.getAnnotation(JsonIgnore.class) != null)
        {
            return rawValues;
        }

        field.setAccessible(true);
        Object returnedObject = field.get(cssImplementationClass);
        if (returnedObject == null)
        {
            return rawValues;
        }

        String cssKey;

        CSSDetail cssDetails = field.getAnnotation(CSSDetail.class);
        cssKey = cssDetails == null ? field.getName() : cssDetails.cssName();

        if (returnedObject instanceof ColourCSSImpl)
        {
            if (!returnedObject.toString().isEmpty())
            {
                rawValues.put(new StringBuilder(cssKey), returnedObject);
            }
            return rawValues;
        }

        if (cssDetails == null)
        {
            return rawValues;
        }
        else if (returnedObject instanceof CSSEnumeration)
        {
            CSSEnumeration enu = (CSSEnumeration) returnedObject;
            if (enu.equals(enu.getDefault()))
            {
                return rawValues;
            }
        }
        else if (returnedObject.getClass().isArray())
        {
            Object[] objArr = (Object[]) returnedObject;
            if (objArr.length == 0)
            {
                return rawValues;
            }
        }

        else if (returnedObject instanceof MeasurementCSSImpl)
        {
            MeasurementCSSImpl m = (MeasurementCSSImpl) returnedObject;
            if (m.MeasurementType() == null || m.MeasurementType().equals(MeasurementTypes.Pixels) && m.value() == CSSPropertiesFactory.DefaultIntValue)
            {
                return rawValues;
            }
        }
        else if (returnedObject instanceof Integer)
        {
            if (returnedObject.equals(CSSPropertiesFactory.DefaultIntValue))
            {
                return rawValues;
            }
        }

        if (returnedObject instanceof CSSImplementationClass && !(returnedObject instanceof CSSImplementationValue))
        {
            Map m = getCSS(returnedObject);
            rawValues.putAll(m);
            return rawValues;
        }

        if (!returnedObject.toString().isEmpty())
        {
            rawValues.put(new StringBuilder(cssKey), returnedObject);
        }
        return rawValues;
    }

    /**
     * Returns the implementation object populated for the annotation provided
     *
     * @param <T>
     * @param cssAnnotation The annotation to process
     * @param fieldMapping  The field mappings for the annotation @see get
     *
     * @return
     */
    public <T extends Object> Object getImplementationObject(Annotation cssAnnotation, Map<StringBuilder, Object> fieldMapping)
    {
        Object newInstance = null;
        String implementationClass = cssAnnotation.annotationType().toString().replaceAll("interface ", "") + "Impl";
        try
        {
            newInstance = Class.forName(implementationClass).newInstance();
            for (Map.Entry<StringBuilder, Object> entry : fieldMapping.entrySet())
            {
                StringBuilder field = entry.getKey();
                Object fieldObject = entry.getValue();
                Character ch = field.charAt(0);
                field = field.replace(0, 1, ch.toString().toLowerCase());
                Field f = newInstance.getClass().getDeclaredField(field.toString());
                f.setAccessible(true);
                if (fieldObject == null)
                {
                    continue;
                }

                if (fieldObject instanceof CSSEnumeration)
                {
                    CSSEnumeration enume = (CSSEnumeration) fieldObject;
                    if (enume.getDefault() != fieldObject)
                    {
                        f.set(newInstance, fieldObject);
                    }
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
                else if (fieldObject instanceof String || fieldObject instanceof Long
                        || fieldObject instanceof Double || fieldObject instanceof Boolean
                        || fieldObject instanceof BigDecimal || fieldObject instanceof ColourCSSImpl)
                {
                    if (!fieldObject.toString().isEmpty())
                    {
                        f.set(newInstance, fieldObject);
                    }
                }
                else if (fieldObject.getClass().isArray())
                {
                    Object[] arrayObject = (Object[]) fieldObject;
                    if (arrayObject.length > 0)
                    {
                        Object o = arrayObject[0];
                        Annotation ao = (Annotation) o;
                        Class aoType = ao.annotationType();
                        String aoTypeImpl = aoType.getCanonicalName() + "Impl";
                        Class aoTypeImplClass = Class.forName(aoTypeImpl);
                        Object newOut = Array.newInstance(aoTypeImplClass, arrayObject.length + 1);
                        for (int i = 0; i < arrayObject.length; i++)
                        {
                            Object object = arrayObject[i];
                            Annotation innerAnnotation = (Annotation) object;
                            Map<StringBuilder, Object> innerFieldMapping = processAnnotation(innerAnnotation);
                            CSSImplementationClass innerImplementationObject = (CSSImplementationClass) getImplementationObject(innerAnnotation, innerFieldMapping);
                            if (!innerImplementationObject.toString().isEmpty())
                            {
                                Array.set(newOut, i, innerImplementationObject);
                            }
                        }
                        f.set(newInstance, newOut);
                    }
                }
                else if (fieldObject instanceof Annotation)
                {
                    Annotation innerAnnotation = (Annotation) fieldObject;
                    Map<StringBuilder, Object> innerFieldMapping = processAnnotation(innerAnnotation);
                    Object innerImplementationObject = getImplementationObject(innerAnnotation, innerFieldMapping);
                    try
                    {
                        if (innerImplementationObject != null)
                        {
                            if (!innerImplementationObject.toString().isEmpty())
                            {
                                f.set(newInstance, innerImplementationObject);
                            }
                        }
                    }
                    catch (IllegalAccessException | IllegalArgumentException ae)
                    {
                        log.log(Level.SEVERE, "[Instantiation]-[Failed " + implementationClass + "]-on-[" + newInstance.getClass() + "]", ae);
                    }
                }
                else
                {
                    f.set(newInstance, fieldObject);
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException ex)
        {
            log.log(Level.SEVERE, "[Instantiation]-[Failed " + implementationClass + "]", ex);
        }
        catch (NoSuchFieldException | SecurityException ex)
        {
            if (newInstance != null)
            {
                log.log(Level.SEVERE, "[Field Populator]-[Failed];[Object]-[" + newInstance.getClass().getCanonicalName() + "]", ex);
            }
            else
            {
                log.log(Level.SEVERE, "[Field Populator]-[Failed];[Object]-[" + newInstance + "]", ex);
            }
        }

        return newInstance;
    }

    /**
     * Returns all annotations for a field that end with 'CSS'
     *
     * @param <A>         CSS Annotations
     * @param <T>
     * @param cssObjectIn The class to get the annotations from
     *
     * @return ArrayList of all applicable CSS annotations
     */
    protected <A extends Annotation, T extends Object> ArrayList<A> getAllAppliedCSSAnnotations(T cssObjectIn)
    {
        Class clazz = cssObjectIn.getClass();
        ArrayList<A> annotations = new ArrayList();
        ArrayList<A> arrayList = new ArrayList<>((Collection<? extends A>) Arrays.asList(clazz.getAnnotations()));
        arrayList.stream()
                .filter(annotation -> (annotation.annotationType().isAnnotationPresent(CSSAnnotationType.class)))
                .forEachOrdered(annotation ->
                {
                    annotations.add((A) annotation);
                });
        return annotations;
    }

    /**
     * Returns all annotations for a field that end with 'CSS'
     *
     * @param <A>   CSS Annotations
     * @param field Field to return for
     *
     * @return ArrayList of all applicable CSS annotations
     */
    protected <A extends Annotation> List<A> getAllAppliedCSSAnnotations(Field field)
    {
        List<A> annotations = new ArrayList();
        ArrayList<A> arrayList = new ArrayList<>((Collection<? extends A>) Arrays.asList(field.getAnnotations()));
        arrayList.stream().filter(annotation -> (annotation.annotationType().isAnnotationPresent(CSSAnnotationType.class)))
                .forEachOrdered((annotation) ->
                {
                    annotations.add((A) annotation);
                });
        return annotations;
    }
}
