package com.jwebmp.core.annotations;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.guicedinjection.abstractions.GuiceInjectorModule;
import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;
import com.jwebmp.logger.LogFactory;

@SuppressWarnings("WeakerAccess")
public class ObjectMapperBinder
		implements IGuiceDefaultBinder<ObjectMapperBinder, GuiceInjectorModule>
{
	/**
	 * The default object mapping
	 */
	public static final Key<ObjectMapper> DefaultObjectMapper = Key.get(ObjectMapper.class);
	/**
	 * The default object writer
	 */
	public static final Key<ObjectWriter> JSONObjectWriter = Key.get(ObjectWriter.class, Names.named("JSON"));
	/**
	 * The default object writer for tiny
	 */
	public static final Key<ObjectWriter> JSONObjectWriterTiny = Key.get(ObjectWriter.class, Names.named("JSONTiny"));
	/**
	 * The object reader for tiny
	 */
	public static final Key<ObjectReader> JSONObjectReader = Key.get(ObjectReader.class, Names.named("JSON"));
	/**
	 * Field log
	 */
	private static final java.util.logging.Logger log = LogFactory.getLog("ObjectMapperBinding");

	/**
	 * Method onBind ...
	 *
	 * @param module
	 * 		of type GuiceInjectorModule
	 */
	@Override
	public void onBind(GuiceInjectorModule module)
	{
		module.bind(DefaultObjectMapper)
		      .toInstance(new ObjectMapper().registerModule(new ParameterNamesModule())
		                                    .registerModule(new Jdk8Module())
		                                    .registerModule(new JavaTimeModule())
		                                    .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
		                                    .setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
		                                    .setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE)
		                                    .setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
		                 );

		log.fine("Bound ObjectWriter.class @Named(JSON)");

		module.bind(JSONObjectWriter)
		      .toProvider(() ->
				                  GuiceContext.get(DefaultObjectMapper)
				                              .writerWithDefaultPrettyPrinter()
				                              .with(SerializationFeature.INDENT_OUTPUT)
				                              .with(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
				                              .with(JsonGenerator.Feature.QUOTE_FIELD_NAMES)
				                              .without(SerializationFeature.FAIL_ON_EMPTY_BEANS)
				                              .withoutFeatures(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS));

		module.bind(JSONObjectWriterTiny)
		      .toProvider(() ->
				                  GuiceContext.get(DefaultObjectMapper)
				                              .writer()
				                              .without(SerializationFeature.INDENT_OUTPUT)
				                              .with(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
				                              .with(JsonGenerator.Feature.QUOTE_FIELD_NAMES)
				                              .without(SerializationFeature.FAIL_ON_EMPTY_BEANS)
				                              .withoutFeatures(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS));


		module.bind(JSONObjectReader)
		      .toProvider(() ->
				                  GuiceContext.get(DefaultObjectMapper)
				                              .reader()
				                              .with(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
				                              .with(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)
				                              .without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
		                 );


	}
}
