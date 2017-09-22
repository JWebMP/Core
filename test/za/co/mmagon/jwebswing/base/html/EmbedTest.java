/*
 * Copyright (C) 2014 GedMarc
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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author GedMarc
 */
public class EmbedTest
{
	
	public EmbedTest()
	{
	}
	
	@Test
	public void testEmbed()
	{
		Embed e = new Embed("Source", "Media Type");
		e.setID("id");
		System.out.println(e.toString(true));
		Assert.assertEquals("<embed src=\"Source\" type=\"Media Type\" id=\"id\">", e.toString(true));
	}
	
}
