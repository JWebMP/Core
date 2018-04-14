package com.jwebmp.htmlbuilder.css.colours;

import javax.validation.constraints.Max;
import java.lang.annotation.Annotation;

public class ColourRGBImpl implements ColourRGB
{
	@Max(value = 255, message = "Max 255 for red value in colour")
	private int red;
	@Max(value = 255, message = "Max 255 for green value in colour")
	private int green;
	@Max(value = 255, message = "Max 255 for blue value in colour")
	private int blue;

	@Override
	public int Red()
	{
		return red;
	}

	@Override
	public int Green()
	{
		return green;
	}

	@Override
	public int Blue()
	{
		return blue;
	}

	public ColourRGBImpl setRed(int red)
	{
		this.red = red;
		return this;
	}

	public ColourRGBImpl setGreen(int green)
	{
		this.green = green;
		return this;
	}

	public ColourRGBImpl setBlue(int blue)
	{
		this.blue = blue;
		return this;
	}

	@Override
	public String toString()
	{
		return "rgb(" + red + "," + green + "," + blue + ")";
	}

	@Override
	public Class<? extends Annotation> annotationType()
	{
		return ColourRGB.class;
	}
}
