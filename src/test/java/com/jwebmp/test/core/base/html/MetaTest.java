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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.test.core.base.html;

import com.jwebmp.core.base.client.HTMLVersions;
import com.jwebmp.core.base.html.Meta;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */

public class MetaTest
{

    public MetaTest()
    {
    }

    /**
     * Test of getMinimumSupportVersion method, of class Meta.
     */
    @Test
    public void testGetMinimumSupportVersion()
    {
        System.out.println("getMinimumSupportVersion");
        Meta instance = null;
        HTMLVersions expResult = null;
        instance = new Meta(Meta.MetadataFields.Author, "Author");
        System.out.println("This is tested in the page test");
        System.out.println(instance.toString(true));
    }

}
