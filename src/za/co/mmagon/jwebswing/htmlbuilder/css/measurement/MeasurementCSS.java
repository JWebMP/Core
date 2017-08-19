package za.co.mmagon.jwebswing.htmlbuilder.css.measurement;

import za.co.mmagon.jwebswing.htmlbuilder.css.CSSPropertiesFactory;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

import java.lang.annotation.*;

/**
 * @author Marc Magon
 */
@Target(
		{
				ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface MeasurementCSS
{

	public double value() default CSSPropertiesFactory.DefaultIntValue;

	public MeasurementTypes MeasurementType() default MeasurementTypes.Pixels;
}
