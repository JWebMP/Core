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
package za.co.mmagon.jwebswing.base.client;

/**
 * CSS Versions
 * CSS 1
 * <p>
 * The first CSS specification to become an official W3C Recommendation is CSS level 1, published in December 1996.[19] Among its capabilities are support for
 * <p>
 * Font properties such as typeface and emphasis Color of text, backgrounds, and other elements Text attributes such as spacing between words, letters, and lines of text Alignment of text, images,
 * tables and other elements Margin, border, padding, and positioning for most elements Unique identification and generic classification of groups of attributes
 * <p>
 * The W3C no longer maintains the CSS 1 Recommendation.[20] CSS 2
 * <p>
 * CSS level 2 specification was developed by the W3C and published as a recommendation in May 1998. A superset of CSS 1, CSS 2 includes a number of new capabilities like absolute, relative, and fixed
 * positioning of elements and z-index, the concept of media types, support for aural style sheets and bidirectional text, and new font properties such as shadows.
 * <p>
 * The W3C no longer maintains the CSS 2 recommendation.[21] CSS 2.1
 * <p>
 * CSS level 2 revision 1, often referred to as "CSS 2.1", fixes errors in CSS 2, removes poorly supported or not fully interoperable features and adds already-implemented browser extensions to the
 * specification. In order to comply with the W3C Process for standardizing technical specifications, CSS 2.1 went back and forth between Working Draft status and Candidate Recommendation status for
 * many years. CSS 2.1 first became a Candidate Recommendation on February 25, 2004, but it was reverted to a Working Draft on June 13, 2005 for further review. It returned to Candidate Recommendation
 * on 19 July 2007 and then updated twice in 2009. However, since changes and clarifications were made, it again went back to Last Call Working Draft on 7 December 2010.
 * <p>
 * CSS 2.1 went to Proposed Recommendation on 12 April 2011.[22] After being reviewed by the W3C Advisory Committee, it was finally published as a W3C Recommendation on 7 June 2011.[23] CSS 3 "CSS3"
 * redirects here. For airport code CSS3, see Montréal/Les Cèdres Airport. File:CSS3 logo and wordmark.svg Logo of CSS3
 * <p>
 * Unlike CSS 2, which is a large single specification defining various features, CSS 3 is divided into several separate documents called "modules". Each module adds new capabilities or extends
 * features defined in CSS 2, over preserving backward compatibility. Work on CSS level 3 started around the time of publication of the original CSS 2 recommendation. The earliest CSS 3 drafts were
 * published in June 1999.[24]
 * <p>
 * Due to the modularization, different modules have different stability and statuses.[25] As of June 2012, there are over fifty CSS modules published from the CSS Working Group.,[24] and four of
 * these have been published as formal recommendations:
 * <p>
 * 2012-06-19 : Media Queries 2011-09-29 : Namespaces 2011-09-29 : Selectors Level 3 2011-06-07 : Color
 * <p>
 * Some modules (including Backgrounds and Borders and Multi-column Layout among others) have Candidate Recommendation (CR) status and are considered moderately stable. At CR stage, implementations
 * are advised to drop vendor prefixes.[26]
 *
 * @author MMagon
 * @since 22 Jun 2013
 * @version 1.0
 *
 *
 */
public enum CSSVersions
{
    /**
     * CSS Version 1.0
     */
    CSS1,
    /**
     * CSS Version 2.0
     */
    CSS2,
    /**
     * CSS Version 2.1
     */
    CSS21,
    /**
     * CSS Version 3
     */
    CSS3,
    /**
     * CSS Version 4
     */
    CSS4;
}
