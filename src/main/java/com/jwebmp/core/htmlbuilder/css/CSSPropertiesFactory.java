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
package com.jwebmp.core.htmlbuilder.css;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSAnnotationType;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.colours.ColourCSSImpl;
import com.jwebmp.core.htmlbuilder.css.composer.CSSBlock;
import com.jwebmp.core.htmlbuilder.css.composer.CSSBlockIdentifier;
import com.jwebmp.core.htmlbuilder.css.composer.CSSLine;
import com.jwebmp.core.htmlbuilder.css.enumarations.CSSTypes;
import com.jwebmp.core.htmlbuilder.css.image.ImageCSS;
import com.jwebmp.core.htmlbuilder.css.interfaces.CSSShortHand;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSS;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementTypes;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generates the necessary artifacts for CSS Production
 *
 * @param <A>
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
public class CSSPropertiesFactory<A extends Annotation>

{
	public static final int DefaultIntValue = Integer.MIN_VALUE;
	public static final double DefaultDoubleValue = Integer.MIN_VALUE;
	@JsonIgnore

	/**
	 * The default logger
	 */
	private static final java.util.logging.Logger log = LogFactory.getInstance()
	                                                              .getLogger("CSS Factory");
	/**
	 * List of methods to always ignore
	 */
	private static final List<String> IgnoreMethods = new ArrayList<>(Arrays.asList("equals", "toString", "hashCode", "annotationType"));

	/**
	 * Return an Annotation/Implementation Pair of all CSS Properties defined in the class. Populates the All CSS Class Properties with these
	 *
	 * @param classAnnotations
	 *
	 * @return
	 */
	@NotNull
	public Map<StringBuilder, Object> getCSSProperties(List<Annotation> classAnnotations)
	{
		Map<StringBuilder, Object> implementedProperties = new HashMap<>();
		Map<StringBuilder, Object> implementedProperties2 = new HashMap<>();
		classAnnotations.forEach(classAnnotation ->
		                         {
			                         Map<StringBuilder, Object> cssProperties = new HashMap<>();
			                         cssProperties.putAll(processAnnotation(classAnnotation));
			                         Object anotImplObject = getImplementationObject(classAnnotation, cssProperties);
			                         Map<StringBuilder, Object> mmm = processImplementationObjectFields((CSSImplementationClass) anotImplObject, implementedProperties);
			                         implementedProperties2.putAll(mmm);
		                         });
		return implementedProperties2;
	}

	/**
	 * Produce the original annotation mapping from an annotation
	 *
	 * @param annotation
	 * 		The annotation to pivot into a HashMap
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("all")
	public Map<StringBuilder, Object> processAnnotation(Annotation annotation)
	{
		Map<StringBuilder, Object> output = new HashMap<>();

		if (annotation == null)
		{
			return output;
		}
		Method[] methods = annotation.getClass()
		                             .getDeclaredMethods();
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
			catch (IllegalArgumentException ex)
			{
				log.log(Level.SEVERE, "[Value Generation]-[" + ex.getMessage() + "];[Method]-[" + method.getName() + "];", ex);
			}
		}

		return output;
	}

	/**
	 * Just a usage
	 *
	 * @return
	 */

	public A getAnnotation()
	{
		//Placeholder
		return null;
	}

	/**
	 * Returns a map for the process implementation
	 *
	 * @param impClass
	 * @param currentReturnList
	 *
	 * @return
	 */
	@NotNull
	public Map<StringBuilder, Object> processImplementationObjectFields(CSSImplementationClass impClass, @NotNull Map<StringBuilder, Object> currentReturnList)
	{
		if (impClass == null)
		{
			return currentReturnList;
		}

		Field[] allFields = impClass.getClass()
		                            .getDeclaredFields();
		List<Field> fields = Arrays.asList(allFields);
		fields.forEach(field ->
		               {
			               try
			               {
				               Map<StringBuilder, Object> map = getPairFromField(field, impClass);
				               map.forEach(currentReturnList::put);
			               }
			               catch (IllegalArgumentException | IllegalAccessException ex)
			               {
				               log.log(Level.FINE, "Unable to read pair from field due to permission", ex);
			               }
		               });

		return currentReturnList;
	}

	/**
	 * Return a Key,Value Pair of all CSS Properties defined in the class
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("all")
	private Map<StringBuilder, Object> getPairFromField(Field field, CSSImplementationClass cssImplementationClass) throws IllegalAccessException
	{
		Map<StringBuilder, Object> rawValues = new HashMap<>();
		if (field.getModifiers() == 26)
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
			if (!returnedObject.toString()
			                   .isEmpty())
			{
				rawValues.put(new StringBuilder(cssKey), returnedObject);
			}
			return rawValues;
		}
		if (cssDetails == null)
		{
			log.finer("Field missing CSS Details {" + cssKey + "}");
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
		else if (returnedObject.getClass()
		                       .isArray())
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
			if (m.MeasurementType() == null || m.MeasurementType()
			                                    .equals(MeasurementTypes.Pixels) && m.value()
			                                                                         .equals(CSSPropertiesFactory.DefaultDoubleValue))
			{
				return rawValues;
			}
			else
			{
				rawValues.put(new StringBuilder(cssKey), returnedObject.toString());
			}
		}
		else if (returnedObject instanceof Integer && returnedObject.equals(CSSPropertiesFactory.DefaultIntValue))
		{
			return rawValues;
		}

		else if (returnedObject instanceof CSSImplementationClass && !(returnedObject instanceof CSSShortHand))
		{
			Map m = getCSS(returnedObject);
			rawValues.putAll(m);
			return rawValues;
		}

		if (!returnedObject.toString()
		                   .isEmpty())
		{
			if (CSSShortHand.class.isAssignableFrom(returnedObject.getClass()))
			{
				rawValues.put(new StringBuilder(cssKey), returnedObject.toString());
			}
			else
			{
				rawValues.put(new StringBuilder(cssKey), returnedObject);
			}
		}
		return rawValues;
	}

	/**
	 * Returns the CSS Property Map for a given class
	 *
	 * @param <T>
	 * @param objectIn
	 * 		The Object to read CSS Annotations From
	 *
	 * @return The HashMap of String Object where Object should be rendered with toString()
	 */

	public <T> Map<StringBuilder, Object> getCSS(T objectIn)
	{
		if (objectIn == null)
		{
			log.log(Level.SEVERE, "[Action]-[Null Object Retrieved];");
			return null;
		}
		if (objectIn instanceof CSSImpl)
		{
			return getCSSProperties((CSSImpl) objectIn);
		}

		List<Annotation> classAnnotations = getAllAppliedCSSAnnotations(objectIn);
		return getCSSProperties(classAnnotations);
	}

	/**
	 * Returns all annotations for a field that end with 'CSS'
	 *
	 * @param <T>
	 * @param cssObjectIn
	 * 		The class to get the annotations from
	 *
	 * @return ArrayList of all applicable CSS annotations
	 */
	public <T> List<Annotation> getAllAppliedCSSAnnotations(T cssObjectIn)
	{
		Class clazz = cssObjectIn.getClass();
		List<Annotation> arrayList = Lists.newArrayList(clazz.getAnnotations());
		arrayList.removeIf(a -> !a.annotationType()
		                          .isAnnotationPresent(CSSAnnotationType.class));
		return arrayList;
	}

	/**
	 * Returns the CSS Property Map for a given class
	 *
	 * @param <T>
	 * @param objectIn
	 * 		The Object to read CSS Annotations From
	 * @param classAnnotations
	 *
	 * @return The HashMap of String Object where Object should be rendered with toString()
	 */
	public <T> Map<StringBuilder, Object> getCSS(T objectIn, Annotation[] classAnnotations)
	{
		if (objectIn == null)
		{
			log.log(Level.SEVERE, "[Action]-[Null Object Retrieved];");
			return null;
		}
		List<Annotation> anos = Lists.newArrayList(classAnnotations);
		return getCSSProperties(anos);
	}

	/**
	 * Returns the CSS Property Map for a given field, in a particular object
	 *
	 * @param fieldIn
	 * 		The Field To Render CSS FOR
	 * @param objectIn
	 * 		The Object which the Field is found
	 *
	 * @return HashMap of String, Object where Object should be rendered with toString()
	 */
	@NotNull
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
			log.log(Level.SEVERE, "[Action]-[Cant Get Field {" + fieldIn.getName() + "}];", ex);
			return new HashMap<>();
		}

		List<Annotation> classAnnotations = getAllAppliedCSSAnnotations(fieldIn);
		return getCSSProperties(classAnnotations);
	}

	/**
	 * Returns all annotations for a field that end with 'CSS'
	 *
	 * @param <A>
	 * 		CSS Annotations
	 * @param field
	 * 		Field to return for
	 *
	 * @return ArrayList of all applicable CSS annotations
	 */
	public <A extends Annotation> List<A> getAllAppliedCSSAnnotations(Field field)
	{
		List<A> arrayList = new ArrayList<>((Collection<? extends A>) Arrays.asList(field.getAnnotations()));
		arrayList.removeIf(a -> !a.annotationType()
		                          .isAnnotationPresent(CSSAnnotationType.class));
		return arrayList;
	}

	/**
	 * Return an Annotation/Implementation Pair of all CSS Properties defined in the class. Populates the All CSS Class Properties with these
	 *
	 * @param classImpl
	 *
	 * @return
	 */
	@NotNull
	public Map<StringBuilder, Object> getCSSProperties(CSSImpl classImpl)
	{
		Map<StringBuilder, Object> m = new HashMap<>();
		Field[] fields = classImpl.getClass()
		                          .getDeclaredFields();
		for (Field field : fields)
		{
			try
			{
				if (field.getModifiers() == Modifier.STATIC || field.get(classImpl) == null)
				{
					continue;
				}
				field.setAccessible(true);
				Object obj = field.get(classImpl);
				if (CSSImplementationClass.class.isAssignableFrom(obj.getClass()))
				{
					m.putAll(getCSSProperties((CSSImplementationClass) obj));
				}
			}
			catch (IllegalArgumentException | IllegalAccessException ex)
			{
				Logger.getLogger(CSSPropertiesFactory.class.getName())
				      .log(Level.SEVERE, null, ex);
			}
		}
		return m;
	}

	/**
	 * Return an Annotation/Implementation Pair of all CSS Properties defined in the class. Populates the All CSS Class Properties with these
	 *
	 * @param classAnnotations
	 *
	 * @return
	 */
	@NotNull
	public Map<StringBuilder, Object> getCSSProperties(CSSImplementationClass classAnnotations)
	{
		return processImplementationObjectFields(classAnnotations, new HashMap<>());
	}

	/**
	 * Produce a CSS Block from the given properties map
	 *
	 * @param identifier
	 * 		The Identifier of the CSS Block
	 * @param blockType
	 * 		The Block Type for the Identifier of the Block
	 * @param propertiesMap
	 * 		The HashMap of String Object to iterate through
	 * @param blockIdentifier
	 *
	 * @return
	 */
	@NotNull
	public CSSBlock getCSSBlock(String identifier, CSSTypes blockType, Map<StringBuilder, Object> propertiesMap, CSSBlockIdentifier blockIdentifier)
	{
		CSSBlock newCSSBlock = new CSSBlock();
		newCSSBlock.setBlockType(blockType);
		newCSSBlock.setIdOfBlock(identifier);
		newCSSBlock.setBlockIdentifer(blockIdentifier);
		newCSSBlock.getCssLines()
		           .setRenderBraces(true);
		propertiesMap.entrySet()
		             .forEach(entry ->
		                      {
			                      StringBuilder key = entry.getKey();
			                      Object value = entry.getValue();
			                      processBlock(newCSSBlock, key, value);
		                      });
		return newCSSBlock;
	}

	/**
	 * Process a css key set into a block
	 *
	 * @param newCSSBlock
	 * @param key
	 * @param value
	 */
	private void processBlock(CSSBlock newCSSBlock, StringBuilder key, Object value)
	{
		if (value.getClass()
		         .isArray())
		{
			Object[] valueArr = (Object[]) value;
			StringBuilder valueString = new StringBuilder();
			for (int i = 0; i < valueArr.length; i++)
			{
				Object object = valueArr[i];
				Object implementedObject = processBlockObject(valueArr, valueString, object, i);
				log.fine("Processed CSS Block into Implementation [" + (implementedObject == null
				                                                        ? "null"
				                                                        : implementedObject.getClass()
				                                                                           .getCanonicalName()) + "]");
			}

			if (valueString.length() > 0 && valueString.indexOf(StaticStrings.STRING_COMMNA) >= 0)
			{
				valueString = new StringBuilder(valueString.substring(0, valueString.lastIndexOf(StaticStrings.STRING_COMMNA))
				                                           .trim());
			}
			newCSSBlock.add(new CSSLine(key.toString(), valueString.toString()));
		}
		else
		{
			newCSSBlock.add(new CSSLine(key.toString(), value.toString()));
		}
	}

	private Object processBlockObject(Object[] valueArr, StringBuilder valueString, Object object, int arrayPosition)
	{
		Object implementedObject = null;
		if (object != null)
		{
			if (object.getClass()
			          .isAnnotation())
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

			valueArr[arrayPosition] = implementedObject;
			if (object instanceof ImageCSS) //special treatment for image arrays for some reason
			{
				valueString.append(implementedObject.toString())
				           .append(StaticStrings.STRING_COMMNA);
			}
			else
			{
				valueString.append(implementedObject.toString())
				           .append(StaticStrings.STRING_SPACE);
			}
		}
		return implementedObject;
	}

	/**
	 * Return a Key,Value Pair of all CSS Properties defined in the class
	 *
	 * @return
	 */
	@NotNull
	private Map<StringBuilder, Object> getPairFromAnnotationMethod(Method method, Annotation annotationObject)
	{
		Map<StringBuilder, Object> rawValues = new HashMap<>();
		if (method == null || annotationObject == null)
		{
			return rawValues;
		}
		if (method.getAnnotation(JsonIgnore.class) != null)
		{
			return rawValues;
		}
		if (method.getName()
		          .startsWith("set") || method.getName()
		                                      .startsWith("get"))
		{
			return rawValues;
		}

		processPairWithAnnotationMethod(method, rawValues, annotationObject);

		return rawValues;
	}

	/**
	 * Populates raw values with the method and annotation
	 *
	 * @param method
	 * @param rawValues
	 * @param annotationObject
	 */
	private void processPairWithAnnotationMethod(Method method, Map<StringBuilder, Object> rawValues, Annotation annotationObject)
	{
		try
		{
			Object returnedObject = method.invoke(annotationObject, (Object[]) null);
			if (returnedObject == null)
			{
				return;
			}
			if (returnedObject instanceof CSSEnumeration)
			{
				CSSEnumeration enu = (CSSEnumeration) returnedObject;
				if (enu.equals(enu.getDefault()))
				{
					return;
				}
			}
			if (returnedObject.getClass()
			                  .isArray())
			{
				Object[] objArr = (Object[]) returnedObject;
				if (objArr.length == 0)
				{
					return;
				}
			}
			if (returnedObject instanceof MeasurementCSS)
			{
				MeasurementCSS m = (MeasurementCSS) returnedObject;
				Double d = m.value();
				if (m.MeasurementType()
				     .equals(MeasurementTypes.Pixels) && d.equals(CSSPropertiesFactory.DefaultDoubleValue))
				{
					return;
				}
			}

			if (returnedObject instanceof Integer && returnedObject.equals(CSSPropertiesFactory.DefaultIntValue))
			{
				return;
			}

			rawValues.put(new StringBuilder(method.getName()), returnedObject);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			log.log(Level.FINE, "Field Skipped [" + method.getName() + "] - [" + e.getLocalizedMessage() + "]", e);
		}
	}

	private Object processFieldAnnotationIntoObject(Object newInstance, Object fieldObject, Field f)
	{
		Annotation innerAnnotation = (Annotation) fieldObject;
		Map<StringBuilder, Object> innerFieldMapping = processAnnotation(innerAnnotation);
		Object innerImplementationObject = getImplementationObject(innerAnnotation, innerFieldMapping);
		try
		{
			if (!(innerImplementationObject != null && innerImplementationObject.toString()
			                                                                    .isEmpty()))
			{
				f.set(newInstance, innerImplementationObject);
			}
		}
		catch (IllegalAccessException | IllegalArgumentException ae)
		{
			log.log(Level.SEVERE, "[Instantiation]-[Failed " + newInstance.getClass()
			                                                              .getCanonicalName() + "]-on-[" + newInstance.getClass() + "]", ae);
		}
		return fieldObject;
	}

	private Object processFieldAnnotationIntoObjectArray(Object newInstance, Object fieldObject, Field f) throws ClassNotFoundException, IllegalAccessException
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
				if (!innerImplementationObject.toString()
				                              .isEmpty())
				{
					Array.set(newOut, i, innerImplementationObject);
				}
			}
			f.set(newInstance, newOut);
		}
		return fieldObject;
	}

	private Object processFieldMapEntry(Object newInstance, StringBuilder field, Object fieldObject) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException
	{
		Character ch = field.charAt(0);
		field = field.replace(0, 1, ch.toString()
		                              .toLowerCase());
		Field f = newInstance.getClass()
		                     .getDeclaredField(field.toString());
		f.setAccessible(true);
		if (fieldObject == null)
		{
			return null;
		}

		processFieldEntry(newInstance, fieldObject, f);

		return fieldObject;
	}

	/**
	 * Processes the field entry
	 *
	 * @param newInstance
	 * @param fieldObject
	 * @param f
	 *
	 * @return
	 *
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("all")
	private Object processFieldEntry(Object newInstance, Object fieldObject, Field f) throws IllegalAccessException, ClassNotFoundException
	{
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
				return null;
			}
			f.set(newInstance, fieldObject);
		}
		else if (fieldObject.getClass()
		                    .isPrimitive())
		{
			f.set(newInstance, fieldObject);
		}
		else if (fieldObject instanceof String ||
		         fieldObject instanceof Long ||
		         fieldObject instanceof Double ||
		         fieldObject instanceof Boolean ||
		         fieldObject instanceof BigDecimal ||
		         fieldObject instanceof ColourCSSImpl)
		{
			if (!fieldObject.toString()
			                .isEmpty())
			{
				f.set(newInstance, fieldObject);
			}
		}
		else if (fieldObject.getClass()
		                    .isArray())
		{
			processFieldAnnotationIntoObjectArray(newInstance, fieldObject, f);
		}
		else if (fieldObject instanceof Annotation)
		{
			fieldObject = processFieldAnnotationIntoObject(newInstance, fieldObject, f);
		}
		else
		{
			f.set(newInstance, fieldObject);
		}
		return fieldObject;
	}

	/**
	 * Returns the implementation object populated for the annotation provided
	 *
	 * @param cssAnnotation
	 * 		The annotation to process
	 * @param fieldMapping
	 * 		The field mappings for the annotation @see get
	 *
	 * @return
	 */

	public Object getImplementationObject(Annotation cssAnnotation, Map<StringBuilder, Object> fieldMapping)
	{
		Object newInstance = null;
		String implementationClass = cssAnnotation.annotationType()
		                                          .toString()
		                                          .replaceAll("interface ", "") + "Impl";
		try
		{
			newInstance = Class.forName(implementationClass)
			                   .getDeclaredConstructor()
			                   .newInstance();

			for (Map.Entry<StringBuilder, Object> entry : fieldMapping.entrySet())
			{
				StringBuilder field = entry.getKey();
				Object fieldObject = entry.getValue();

				processFieldMapEntry(newInstance, field, fieldObject);
			}
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException ex)
		{
			log.log(Level.SEVERE, "[Instantiation]-[Failed " + implementationClass + "]", ex);
		}
		catch (NoSuchFieldException | SecurityException ex)
		{
			if (newInstance != null)
			{
				log.log(Level.SEVERE, "[Field Populator]-[Failed];[Object]-[" + newInstance.getClass()
				                                                                           .getCanonicalName() + "]", ex);
			}
			else
			{
				log.log(Level.SEVERE, "[Field Populator]-[Failed];[Object]-[NULL]", ex);
			}
		}

		return newInstance;
	}

}
