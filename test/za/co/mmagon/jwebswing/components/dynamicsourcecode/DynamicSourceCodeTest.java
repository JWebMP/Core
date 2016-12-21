/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mmagon.jwebswing.components.dynamicsourcecode;

import org.junit.*;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.components.google.sourceprettify.*;

/**
 *
 * @author GedMarc
 */
public class DynamicSourceCodeTest
{

    public DynamicSourceCodeTest()
    {
    }

    @Test
    public void testDefaultOutput()
    {
        Page p = new Page();
        p.getOptions().setDynamicRender(false);
        DynamicSourceCode dsc = new DynamicSourceCode();
        p.getBody().add(dsc);

        Div themeChange = new Div();
        dsc.addThemeChanger(themeChange, SourceCodePrettifyThemes.Desert);
        p.getBody().add(themeChange);

        Div srcChange = new Div();
        dsc.addSourceChanger(srcChange, DynamicSourceCode.class);
        p.getBody().add(srcChange);

        System.out.println(p.toString(true));
    }
}
