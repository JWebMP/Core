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

import java.util.logging.Level;
import java.util.logging.*;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.MetaAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * The Meta Component.
 * <p>
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The base tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The base tag specifies the base URL/target for all relative URLs in a<p>
 * document.<p>
 * <p>
 * There can be at maximum one base element in a document, and it must be<p>
 * inside the head element. Tips and Notes<p>
 * <p>
 * Tip: Put the base tag as the first element inside the head element, so<p>
 * that other elements in the head section uses the information from the base<p>
 * element.<p>
 * <p>
 * Note: If the base tag is present, it must have either an href attribute or<p>
 * a target attribute, or both.<p>
 *
 * @since 2013/11/12
 * @version 1.0
 * @author MMagon
 *
 *
 *
 */
public class Meta extends ComponentHierarchyBase<NoChildren, MetaAttributes, NoFeatures, NoEvents, Component>
        implements NoIDTag, NoClosingTag, HeadChildren, NoClassAttribute, NoNewLineBeforeClosingTag
{

    private static Logger logger = LogFactory.getInstance().getLogger("<META>");

    /**
     * Constructs an empty Meta tag
     */
    public Meta()
    {
        super(ComponentTypes.Metadata);
    }

    /**
     * Creates a Meta tag of HTTP Equiv with the custom name
     *
     * @param httpEquivName
     */
    public Meta(String httpEquivName)
    {
        super(ComponentTypes.Metadata);
        addAttribute(MetaAttributes.Http_Equiv, httpEquivName);
    }

    /**
     * Constructs a Meta tag
     *
     * @param field The MetaData tag to generate
     * @param value doh
     */
    public Meta(MetadataFields field, String value)
    {
        super(ComponentTypes.Metadata);
        switch (field)
        {
            case http_equiv:
            {
                addAttribute(MetaAttributes.Http_Equiv, MetadataFields.http_equiv.getDataNameField());
                addAttribute(MetaAttributes.Http_Equiv, value);
                break;
            }
            case Author:
            {

                addAttribute(MetaAttributes.Content, value);
                addAttribute(MetaAttributes.Name, MetadataFields.Author.getDataNameField());
                break;
            }
            case Description:
            {

                addAttribute(MetaAttributes.Content, value);
                addAttribute(MetaAttributes.Name, MetadataFields.Description.getDataNameField());
                break;
            }
            case Keywords:
            {

                addAttribute(MetaAttributes.Content, value);
                addAttribute(MetaAttributes.Name, MetadataFields.Keywords.getDataNameField());
                break;
            }
        }
        if (field == MetadataFields.http_equiv)
        {
            addAttribute(MetaAttributes.Http_Equiv, field.getDataNameField());
        }
        else
        {
            addAttribute(MetaAttributes.Name, field.getDataNameField());
        }
        addAttribute(MetaAttributes.Content, value);
        setTiny(true);
    }

    /**
     * Differences Between HTML and XHTML
     * <p>
     * In HTML the base tag has no end tag.
     * <p>
     * In XHTML the base tag must be properly closed.
     */
    @Override
    public void preConfigure()
    {
        try
        {
            if (getPage().getHtmlVersion().name().startsWith("X"))
            {
                setInlineClosingTag(true);
            }
        }
        catch (Exception e)
        {
            logger.log(Level.FINE, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
        }
    }

    /**
     * A set list of fields available to the Meta tag
     */
    public enum MetadataFields
    {

        Application_Name("application-name"),
        Generator("generator"),
        Author("author"),
        Keywords("keywords"),
        Description("description"),
        http_equiv("X-UA-Compatible");

        /**
         * Doh
         *
         * @param dataNameField
         */
        private MetadataFields(String dataNameField)
        {
            this.dataNameField = dataNameField;
        }

        private String dataNameField;

        /**
         * Returns this tags data name field
         *
         * @return
         */
        public String getDataNameField()
        {
            return dataNameField;
        }

        /**
         * Sets this fields dataset name Useful.
         *
         * @param dataNameField The name to set the field
         */
        public void setDataNameField(String dataNameField)
        {
            this.dataNameField = dataNameField;
        }
    }

}
