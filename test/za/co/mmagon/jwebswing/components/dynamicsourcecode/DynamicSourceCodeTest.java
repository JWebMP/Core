/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mmagon.jwebswing.components.dynamicsourcecode;

import org.junit.Test;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.google.sourceprettify.SourceCodePrettifyThemes;

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
        p.setDynamicRender(false);
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
