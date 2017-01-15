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
package za.co.mmagon.jwebswing.components.jqueryUI.autocomplete;

import junit.framework.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.components.jqueryui.autocomplete.JQUIAutoComplete;

/**
 *
 * @author GedMarc
 */
public class JQUIAutoCompleteTest extends BaseTestClass
{

    public JQUIAutoCompleteTest()
    {
    }

    @Test
    public void testStrucure()
    {
        JQUIAutoComplete ac = new JQUIAutoComplete("autocomplete");
        ac.setID("id");
        ac.getLabel().setID("label");
        ac.getInput().setID("input");
        ac.getOptions().addOption("option 1");
        System.out.println(ac.toString(true));
        Assert.assertEquals(""
                + "<div class=\"ui-widget\" id=\"id\">\n"
                + "	<label for=\"autocomplete\" id=\"label\">autocomplete</label>\n"
                + "	<input id=\"input\" type=\"text\">\n"
                + "</div>", ac.toString(true).toString());
    }

    @Test
    public void testSourceBasic()
    {
        JQUIAutoComplete ac = new JQUIAutoComplete("autocomplete");
        ac.setID("id");
        ac.getLabel().setID("label");
        ac.getInput().setID("input");
        ac.getOptions().addOption("option 1");
        ac.toString(true);
        System.out.println(ac.renderJavascript().toString());
        String expected = "$('#input').autocomplete({\n"
                + "  \"source\" : [ {\n"
                + "    \"label\" : \"option 1\"\n"
                + "  } ]\n"
                + "});\n"
                + "";
        String rendered = ac.renderJavascript().toString();
        Assert.assertEquals(expected, rendered);
    }

    @Test
    public void testSourceCategories()
    {
        JQUIAutoComplete ac = new JQUIAutoComplete("autocomplete");
        ac.setID("id");
        ac.getLabel().setID("label");
        ac.getInput().setID("input");
        ac.getOptions().addOption("option 1", "value1", "category1");
        System.out.println(ac.renderJavascript().toString());

        String expected = "$('#input').autocomplete({\n"
                + "  \"source\" : [ {\n"
                + "    \"label\" : \"option 1\",\n"
                + "    \"value\" : \"value1\",\n"
                + "    \"category\" : \"category1\"\n"
                + "  } ]\n"
                + "});\n"
                + "";
        String rendered = ac.renderJavascript().toString();

        //super.writeValuesToFile(expected, rendered);
        Assert.assertEquals(expected, rendered);
    }

}
