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
package za.co.mmagon;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.jwebswing.components.pools.jquery.JQueryReferencePool;
import za.co.mmagon.jwebswing.components.pools.jqueryUI.JQUIReferencePool;
import za.co.mmagon.jwebswing.components.pools.jquerylayout.JQLayoutReferencePool;
import za.co.mmagon.jwebswing.components.references.jqxWidgets.JQXCoreJavaScriptReference;
import za.co.mmagon.jwebswing.generics.WebReference;

/**
 *
 * @author GedMarc
 */
public class WebReferenceTest
{

    public WebReferenceTest()
    {
    }

    /**
     * Test of setLeft method, of class WebReference.
     */
    @Test
    public void testSetLeft()
    {
    }

    @Test
    public void testSort()
    {
        ArrayList<WebReference> w = new ArrayList<>();
        w.add(JQueryReferencePool.JQueryAtmospherePush.getJavaScriptReference());
        w.add(new JQXCoreJavaScriptReference());
        w.add(JQueryReferencePool.JQueryV2.getJavaScriptReference());// new JQueryReferenceV2());
        w.add(JQUIReferencePool.Widget.getJavaScriptReference());
        w.add(JQUIReferencePool.Core.getJavaScriptReference());
        w.add(JQUIReferencePool.Dialog.getJavaScriptReference());
        w.add(JQUIReferencePool.Tabs.getJavaScriptReference());
        w.add(JQUIReferencePool.Mouse.getJavaScriptReference());
        w.add(JQUIReferencePool.Button.getJavaScriptReference());

        w.add(JQLayoutReferencePool.JQueryLayout.getJavaScriptReference());

        w.add(JQueryReferencePool.JQueryAtmospherePush.getJavaScriptReference());
        w.add(JQueryReferencePool.AjaxEnabler.getJavaScriptReference());

        WebReference.sort(w);
        System.out.println(w);

        String expected = "[bower_components/jquery/dist/jquery.js, javascript/jwebswing/ajax-enabler.js, bower_components/jquery-ui/jquery-ui.js, bower_components/jquery-ui/jquery-ui.js, bower_components/jquery-ui/jquery-ui.js, bower_components/jqwidgets/jqwidgets/jqxcore.js, bower_components/jquery-ui/jquery-ui.js, bower_components/jquery-ui/jquery-ui.js, bower_components/jquery-ui/jquery-ui.js, bower_components/jquery-ui-latest-jwebswing/jquery.layout_and_plugins.js, bower_components/atmosphere.js/atmosphere.js, bower_components/atmosphere.js/atmosphere.js]";
        String result = w.toString();

        Assert.assertEquals(expected, result);

    }
}
