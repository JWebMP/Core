/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.base.html;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author MMagon
 */
public class ImageTest
{

	public ImageTest()
	{
	}

	@Test
	public void testImage()
	{
		Image image = new Image("image");
		image.setID("id");
		System.out.println(image.toString(true));
		Assertions.assertEquals("<img id=\"id\" src=\"image\"/>", image.toString(true));
	}
}
