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
 * A list of all possible HTML Version DTD files. Some not used at all, but good to keep. The Ordinal Value denotes priority
 *
 * @author MMagon
 * @since 22 Jun 2013
 * @version 1.0
 */
public enum HTMLVersions
{
    /*
     * Blank HTML 5
     */
    All("<!DOCTYPE html>"),
    /**
     * This DTD is equal to XHTML 1.0 Strict, but allows you to add modules (for example to provide ruby support for East-Asian languages). This one first so it never gets considered
     */
    XHTML11("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">"),
    /**
     * This DTD contains all HTML elements and attributes, but does NOT INCLUDE presentational or deprecated elements (like font). Framesets are not allowed.
     */
    HTML401Strict("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\"http://www.w3.org/TR/html4/strict.dtd\">"),
    /**
     * This DTD contains all HTML elements and attributes, INCLUDING presentational and deprecated elements (like font). Framesets are not allowed.
     */
    HTML401Loose("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">"),
    /**
     * This DTD is equal to HTML 4.01 Transitional, but allows the use of frameset content.
     */
    HTML401Frameset("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">"),
    /**
     * This DTD contains all HTML elements and attributes, INCLUDING presentational and deprecated elements (like font). Framesets are not allowed. The markup must also be written as well-formed XML.
     */
    HTML401Transitional("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"),
    /**
     * This DTD contains all HTML elements and attributes, but does NOT INCLUDE presentational or deprecated elements (like font). Framesets are not allowed.
     */
    XHTML401Strict("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"),
    /**
     * This DTD contains all HTML elements and attributes, INCLUDING presentational and deprecated elements (like font). Framesets are not allowed.
     */
    XHTML401Loose("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"),
    /**
     * This DTD is equal to HTML 4.01 Transitional, but allows the use of frameset content.
     */
    XHTML401Frameset("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Frameset//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd\">"),
    /**
     * Contains all tags valid for HTML 5
     */
    HTML5("<!DOCTYPE html>"),
    /**
     * Default to HTML 4.0 Transitional
     */
    Custom("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
    private String dtd;

    private HTMLVersions(String dtd)
    {
        this.dtd = dtd;
    }

    public String getDtd()
    {
        return dtd.trim();
    }

    public void setDtd(String dtd)
    {
        this.dtd = dtd;
    }
}
