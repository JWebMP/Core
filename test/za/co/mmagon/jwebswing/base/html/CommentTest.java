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
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author MMagon
 */
public class CommentTest
{

    Comment comment = new Comment("This is the comment");

    public CommentTest()
    {
    }

    @Before
    public void setUp()
    {
    }

    @Test
    public void testtoString()
    {
        String expected = "<!-- This is the comment -->";
        String result = comment.toString(true).toString();
        assertEquals(expected, result);
        System.out.println(comment.toString(true));
    }

    @Test
    public void testTinytoString()
    {
        comment = new Comment("This is not supposed to render");
        String expected = "";
        comment.setTiny(true);
        String result = comment.toString(true).toString();
        assertEquals(expected, result);
        System.out.println(comment.toString(true));
    }
}
