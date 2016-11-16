/*
 * Copyright (C) 2014 MMagon
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
package za.co.mmagon.jwebswing.base.html;

import static org.junit.Assert.*;
import org.junit.Test;
import za.co.mmagon.jwebswing.base.client.HTMLVersions;

/**
 *
 * @author MMagon
 */
public class DocumentTypeTest
{

    public DocumentTypeTest()
    {
    }

    @Test
    public void testtoString()
    {
        DocumentType dt = new DocumentType(HTMLVersions.HTML401Frameset);
        System.out.println(dt.toString(true));
        String s = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">";
        assertEquals(dt.toString(true).toString(), "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">");
    }

}
