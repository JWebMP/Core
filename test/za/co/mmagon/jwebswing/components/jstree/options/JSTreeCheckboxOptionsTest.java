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
package za.co.mmagon.jwebswing.components.jstree.options;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class JSTreeCheckboxOptionsTest
{

    public JSTreeCheckboxOptionsTest()
    {
    }

    @Test
    public void testGetVisible()
    {
        JSTreeCheckboxOptions options = new JSTreeCheckboxOptions();
        options.setVisible(true);
        System.out.println(options);
        Assert.assertEquals("{\n"
                + "  \"visible\" : true\n"
                + "}"
                + "", options.toString());
    }

    @Test
    public void testGetThreeState()
    {
        JSTreeCheckboxOptions options = new JSTreeCheckboxOptions();
        options.setThreeState(true);
        System.out.println(options);
        Assert.assertEquals("{\n"
                + "  \"three_state\" : true\n"
                + "}", options.toString());
    }

    @Test
    public void testGetWholeNode()
    {
        JSTreeCheckboxOptions options = new JSTreeCheckboxOptions();
        options.setWholeNode(true);
        System.out.println(options);
        Assert.assertEquals("{\n"
                + "  \"whole_node\" : true\n"
                + "}", options.toString());
    }

    @Test
    public void testGetKeepSelectedStyle()
    {
        JSTreeCheckboxOptions options = new JSTreeCheckboxOptions();
        options.setKeepSelectedStyle(true);
        System.out.println(options);
        Assert.assertEquals("{\n"
                + "  \"keep_selected_style\" : true\n"
                + "}", options.toString());
    }

    @Test
    public void testGetCascade()
    {
        JSTreeCheckboxOptions options = new JSTreeCheckboxOptions();
        options.setCascade(true);
        System.out.println(options);
        Assert.assertEquals("{\n"
                + "  \"cascade\" : true\n"
                + "}", options.toString());
    }

    @Test
    public void testGetTieSelection()
    {
        JSTreeCheckboxOptions options = new JSTreeCheckboxOptions();
        options.setTieSelection(true);
        System.out.println(options);
        Assert.assertEquals("{\n"
                + "  \"tie_selection\" : true\n"
                + "}", options.toString());
    }

}
