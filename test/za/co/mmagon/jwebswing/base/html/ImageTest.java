/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mmagon.jwebswing.base.html;

import org.junit.Assert;
import org.junit.Test;

/**
 *
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
        Assert.assertEquals("<img id=\"id\" src=\"image\"/>", image.toString(true));
    }
}
