/*
 * Copyright (C) 2015 GedMarc
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
 * along with this program.  If not, see &lt;http://www.gnu.org/licenses/&gt;.
 */
package za.co.mmagon.jwebswing.base.html;

import org.junit.Assert;
import org.junit.Test;

/**
 * Object
 * <p>
 * The Object object represents an HTML &lt;object&gt; element. Access an Object Object
 * <p>
 * You can access an &lt;object&gt; element by using getElementById(): var x = document.getElementById("myObject"); Try it Create an Object Object
 * <p>
 * You can create an &lt;object&gt; element by using the document.createElement() method:
 *
 * @author GedMarc
 * @since 2014/12/29
 * @version 1.0
 */
public class ObjectTagTest
{

    public ObjectTagTest()
    {
    }

    @Test
    public void testSomeMethod()
    {
        ObjectTag ot = new ObjectTag();
        ot.setID("id");
        System.out.println(ot.toString(true));
        Assert.assertEquals(""
                + "<object id=\"id\"></object>", ot.toString(true).toString());
    }

}
