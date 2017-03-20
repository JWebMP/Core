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
import za.co.mmagon.jwebswing.generics.WebReference;
import za.co.mmagon.jwebswing.plugins.ajaxenabler.AjaxEnablerReferencePool;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryReferencePool;

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
        // w.add(AtmosphereReferencePool.JQueryAtmospherePush.getJavaScriptReference());
        w.add(JQueryReferencePool.JQueryV2.getJavaScriptReference());// new JQueryReferenceV2());

        //w.add(AtmosphereReferencePool.JQueryAtmospherePush.getJavaScriptReference());
        w.add(AjaxEnablerReferencePool.AjaxEnabler.getJavaScriptReference());

        WebReference.sort(w);
        System.out.println(w);

        String expected = "[bower_components/jquery/dist/jquery.js, javascript/jwebswing/ajax-enabler.js]";
        String result = w.toString();

        Assert.assertEquals(expected, result);

    }
}
