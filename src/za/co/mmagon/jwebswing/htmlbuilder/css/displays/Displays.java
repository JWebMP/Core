package za.co.mmagon.jwebswing.htmlbuilder.css.displays;

import za.co.mmagon.jwebswing.base.client.CSSVersions;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSSEnumeration;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;

/**
 * Definition and Usage
 * <p>
 * The display property defines how a certain HTML element should be displayed.
 * Default value: inline Inherited: no Version:
 * CSS1 JavaScript syntax: object.style.display="inline"
 *
 * @author Marc Magon
 * @version 1.0
 * @since 2013/01/22
 */
@CSSAnnotationType
public enum Displays implements CSSEnumeration<Displays>
{
    /**
     * Default value. Displays an element as an inline element (like &lt;span&gt;)
     */
    Inline,
    /**
     * Displays an element as a block element (like
     * &lt;p&gt;
     * )
     */
    Block,/**
     * Displays an element as an block_level flex container. New in CSS3
     */
    Flex,
    /**
     * Displays an element as an inline_level flex container. New in CSS3
     */
    Inline_flex,
    /**
     * The element is displayed as an inline_level table
     */
    Inline_table,
    /**
     * Let the element behave like a &lt;li&gt; element
     */
    List_item,
    /**
     * Displays an element as either block or inline, depending on context
     */
    Run_in,
    /**
     * Let the element behave like a &lt;table&gt; element
     */
    Table,
    /**
     * Let the element behave like a &lt;caption&gt; element
     */
    Table_caption,
    /**
     * Let the element behave like a &lt;colgroup&gt; element
     */
    Table_column_group,
    /**
     * Let the element behave like a &lt;thead&gt; element
     */
    Table_header_group,
    /**
     * Let the element behave like a &lt;tfoot&gt; element
     */
    Table_footer_group,
    /**
     * Let the element behave like a &lt;tbody&gt; element
     */
    Table_row_group,
    /**
     * Let the element behave like a &lt;td&gt; element
     */
    Table_cell,
    /**
     * Let the element behave like a &lt;col&gt; element
     */
    Table_column,
    /**
     * Let the element behave like a &lt;tr&gt; element
     */
    Table_row,
    /**
     * The element will not be displayed at all (has no effect on layout)
     */
    None,
    /**
     * Sets this property to its default value. Read about initial
     */
    Initial,
    /**
     * Inherits this property from its parent element. Read about inherit;
     */
    Inherit,
    /**
     * Sets this field as not set
     */
    Unset;

    @Override
    public String getValue()
    {
        return name();
    }

    @Override
    public Displays getDefault()
    {
        return Unset;
    }

    @Override
    public String getJavascriptSyntax()
    {
        return "style.display";
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        return CSSVersions.CSS1;
    }

    @Override
    public String toString()
    {
        return super.toString().toLowerCase().replaceAll("_", "-");
    }

}
