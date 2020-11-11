package com.jwebmp.core.htmlbuilder.css.colours;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import java.lang.annotation.Annotation;

public class ColourRGBAImpl
		implements ColourRGBA
{
	@Max(value = 255,
			message = "Max 255 for red value in colour")
	private int red;
	@Max(value = 255,
			message = "Max 255 for green value in colour")
	private int green;
	@Max(value = 255,
			message = "Max 255 for blue value in colour")
	private int blue;
	@DecimalMax(value = "1.0",
			message = "Max 1.0 for alpha value in colour")
	private double alpha;

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

	@Override
	public double Alpha()
	{
		return 0.0;
	}

	public ColourRGBAImpl setRed(int red)
	{
		this.red = red;
		return this;
	}

	public ColourRGBAImpl setGreen(int green)
	{
		this.green = green;
		return this;
	}

	public ColourRGBAImpl setBlue(int blue)
	{
		this.blue = blue;
		return this;
	}

	public ColourRGBAImpl setAlpha(double alpha)
	{
		this.alpha = alpha;
		return this;
	}

	@Override
	public String toString()
	{
		return "rgba(" + red + "," + green + "," + blue + "," + alpha + ")";
	}

	@Override
	public Class<? extends Annotation> annotationType()
	{
		return ColourRGB.class;
	}
}
