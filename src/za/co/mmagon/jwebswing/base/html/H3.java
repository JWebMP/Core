/*
 * Copyright (C) 2017 Marc Magon
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

import za.co.mmagon.jwebswing.base.html.attributes.HeaderTypes;

/**
 * HTML Headings<p>
 * <p>
 * Headings are defined with the h1 to h6 tags.<p>
 * <p>
 * h1 defines the most important heading. h6 defines the least important heading.<p>
 * <p>
 * Note: Browsers automatically add some empty space (a margin) before and after each heading. Headings Are Important<p>
 * <p>
 * Use HTML headings for headings only. Don't use headings to make text BIG or bold.<p>
 * <p>
 * Search engines use your headings to index the structure and content of your web pages.<p>
 * <p>
 * Since users may skim your pages by its headings, it is important to use headings to show the document structure.<p>
 * <p>
 * H1 headings should be used as main headings, followed by H2 headings, then the less important H3 headings, and so on.<p>
 * <p>
 * Browser Support
 * <p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The &lt;h1&gt; to &lt;h6&gt; tags are supported in all major browsers. Definition and Usage<p>
 * <p>
 * The &lt;h1&gt; to &lt;h6&gt; tags are used to define HTML headings.<p>
 * <p>
 * &lt;h1&gt; defines the most important heading. &lt;h6&gt; defines the least important heading. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The "align" attribute is deprecated in HTML 4.01, and is not supported in HTML5. Use CSS to align elements.<p>
 * <p>
 *
 * @author GedMarc
 * @param <J>
 *
 * @since 24 Apr 2016
 */
public class H3<J extends H3> extends HeaderText<J>
{

    private static final long serialVersionUID = 1L;

    /**
     *
     * HTML Headings<p>
     * <p>
     * Headings are defined with the h1 to h6 tags.<p>
     * <p>
     * h1 defines the most important heading. h6 defines the least important heading.<p>
     * <p>
     * Note: Browsers automatically add some empty space (a margin) before and after each heading. Headings Are Important<p>
     * <p>
     * Use HTML headings for headings only. Don't use headings to make text BIG or bold.<p>
     * <p>
     * Search engines use your headings to index the structure and content of your web pages.<p>
     * <p>
     * Since users may skim your pages by its headings, it is important to use headings to show the document structure.<p>
     * <p>
     * H1 headings should be used as main headings, followed by H2 headings, then the less important H3 headings, and so on.<p>
     * <p>
     * Browser Support
     * <p>
     * <p>
     * Internet Explorer Firefox Opera Google Chrome Safari<p>
     * <p>
     * The &lt;h1&gt; to &lt;h6&gt; tags are supported in all major browsers. Definition and Usage<p>
     * <p>
     * The &lt;h1&gt; to &lt;h6&gt; tags are used to define HTML headings.<p>
     * <p>
     * &lt;h1&gt; defines the most important heading. &lt;h6&gt; defines the least important heading. Differences Between HTML 4.01 and HTML5<p>
     * <p>
     * The "align" attribute is deprecated in HTML 4.01, and is not supported in HTML5. Use CSS to align elements.<p>
     * <p>
     * @author Marc Magon
     *
     * @since forever
     */
    public H3()
    {
    }

    /**
     *
     * HTML Headings<p>
     * <p>
     * Headings are defined with the h1 to h6 tags.<p>
     * <p>
     * h1 defines the most important heading. h6 defines the least important heading.<p>
     * <p>
     * Note: Browsers automatically add some empty space (a margin) before and after each heading. Headings Are Important<p>
     * <p>
     * Use HTML headings for headings only. Don't use headings to make text BIG or bold.<p>
     * <p>
     * Search engines use your headings to index the structure and content of your web pages.<p>
     * <p>
     * Since users may skim your pages by its headings, it is important to use headings to show the document structure.<p>
     * <p>
     * H1 headings should be used as main headings, followed by H2 headings, then the less important H3 headings, and so on.<p>
     * <p>
     * Browser Support
     * <p>
     * <p>
     * Internet Explorer Firefox Opera Google Chrome Safari<p>
     * <p>
     * The &lt;h1&gt; to &lt;h6&gt; tags are supported in all major browsers. Definition and Usage<p>
     * <p>
     * The &lt;h1&gt; to &lt;h6&gt; tags are used to define HTML headings.<p>
     * <p>
     * &lt;h1&gt; defines the most important heading. &lt;h6&gt; defines the least important heading. Differences Between HTML 4.01 and HTML5<p>
     * <p>
     * The "align" attribute is deprecated in HTML 4.01, and is not supported in HTML5. Use CSS to align elements.<p>
     * <p>
     * @author Marc Magon
     * @param text
     *
     * @since forever
     */
    public H3(String text)
    {
        super(HeaderTypes.H3, text);
    }
}
