/*
 * Copyright (C) 2015 MXM3727
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
package za.co.mmagon.jwebswing.components.references.jqxWidgets;

import org.junit.Test;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.client.InternetExplorerCompatibilityMode;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.components.jqueryUI.button.JQUIButton;
import za.co.mmagon.jwebswing.generics.WebReference;

/**
 *
 * @author MXM3727
 */
public class JQueryUIWidgetJavaScriptReferenceTest
{

    public JQueryUIWidgetJavaScriptReferenceTest()
    {
    }

    @Test
    public void testWidgetReferences()
    {
        WebReference.setIsLocal(false);
        Page p = new Page();
        p.setAuthor("Marc Magon");
        p.setCompatibilityMode(InternetExplorerCompatibilityMode.IE5);
        // p.setTiny(Boolean.TRUE);
        Body b = new Body(p);
        b.add(new JQUIButton("This is a JQuery UI Button"));
        System.out.println(p.toString(true));
    }

}
