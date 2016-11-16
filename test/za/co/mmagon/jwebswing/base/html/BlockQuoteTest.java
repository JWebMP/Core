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
import za.co.mmagon.jwebswing.base.html.attributes.BlockQuoteAttributes;

/**
 *
 * @author GedMarc
 */
public class BlockQuoteTest
{

    public BlockQuoteTest()
    {
    }
    BlockQuote bq = new BlockQuote();
    Paragraph p = new Paragraph("test");

    private void reset()
    {
        bq = new BlockQuote();
        bq.addAttribute(BlockQuoteAttributes.Cite, "cite");
        bq.setID("id");
        p.setID("id");
        bq.add(p);
    }

    @Test
    public void testBlockQuotes()
    {
        reset();
        System.out.println(bq.toString(true));
        Assert.assertEquals("<blockquote cite=\"cite\" id=\"id\">\n"
                + "	<p id=\"id\">test</p>\n"
                + "</blockquote>", bq.toString(true));
    }

    @Test
    public void testBlockQuotesTiny()
    {
        reset();
        bq.setTiny(true);
        System.out.println(bq.toString(true));
        Assert.assertEquals("<blockquote cite=\"cite\" id=\"id\"><p id=\"id\">test</p></blockquote>", bq.toString(true));
    }

}
