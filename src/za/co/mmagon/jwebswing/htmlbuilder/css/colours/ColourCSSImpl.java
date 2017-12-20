package za.co.mmagon.jwebswing.htmlbuilder.css.colours;

import com.fasterxml.jackson.annotation.JsonValue;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSImplementationAdapter;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSImplementationClass;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSImplementationValue;

import java.io.Serializable;

/**
 * Defines a Colour by anything
 *
 * @author Marc Magon
 */
public class ColourCSSImpl extends CSSImplementationAdapter<ColourCSS, ColourCSSImpl>
		implements Serializable, CSSImplementationValue, CSSImplementationClass<ColourCSS, ColourCSSImpl>
{

	/**
	 * Version 1
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The actual value
	 */
	private String value;

	/**
	 * Constructs a new Colour CSS
	 */
	public ColourCSSImpl()
	{
		//No need for anything here
	}

	/**
	 * Constructs a new colour with a value
	 *
	 * @param value
	 */
	public ColourCSSImpl(String value)
	{
		this.value = value;
	}

	@JsonValue
	/**
	 * Returns the actual value
	 *
	 * @return
	 */
	public String value()
	{
		return value;
	}

	/**
	 * Sets the actual value
	 *
	 * @param value
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	public ColourCSSImpl setValue(ColourRGBAImpl value)
	{
		this.value = new ColourRGBAImpl().setBlue(value.Blue()).setGreen(value.Green()).setRed(value.Red()).setAlpha(value.Alpha()).toString();
		return this;
	}

	/**
	 * Sets the colour value associated
	 *
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ColourCSSImpl setValue(ColourCSSImpl value)
	{
		this.value = value.value();
		return this;
	}

	/**
	 * Sets the colour
	 *
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ColourCSSImpl setValue(ColourNames value)
	{
		this.value = value.toString();
		return this;
	}

	/**
	 * Sets the colour
	 *
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ColourCSSImpl setValue(ColourHexImpl value)
	{
		this.value = value.toString();
		return this;
	}

	/**
	 * Sets the colour
	 *
	 * @param value
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ColourCSSImpl setValue(ColourRGBImpl value)
	{
		this.value = new ColourRGBImpl().setBlue(value.Blue()).setGreen(value.Green()).setRed(value.Red()).toString();
		return this;
	}

	/**
	 * Returns the value of this colour
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return value == null ? "" : value;
	}

}
