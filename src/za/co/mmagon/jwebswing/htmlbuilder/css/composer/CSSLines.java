package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import za.co.mmagon.jwebswing.utilities.TextUtilities;

/**
 * Denotes many lines of CSS. This belongs to a Block This can be not defined, or hover, a, visited, link... etc
 *
 * @author MMagon
 * @since 07 Apr 2013
 * @version 1.0
 */
public class CSSLines implements Serializable
{

    private ArrayList<CSSLine> cssLines;
    private static boolean tinyHTML;
    private boolean renderInQuotations;
    private boolean renderBraces;
    private boolean prettyPrint;
    private boolean renderInLine;
    private boolean renderSemiColons;

    /**
     * A New CSS Lines Holder, setting Braces on, Quotations off, pretty print as true
     */
    public CSSLines()
    {
        this(new ArrayList<CSSLine>());
    }

    /**
     * A New CSS Lines Holder, setting Braces on, Quotations off, pretty print as true
     *
     * @param cssLines The lines that should be rendered for CSS Lines
     */
    public CSSLines(ArrayList<CSSLine> cssLines)
    {
        this(cssLines, false);
    }

    /**
     * A New CSS Lines Holder, setting Braces on, Quotations Set, pretty print as true
     *
     * @param cssLines           The lines that should be rendered for CSS Lines
     * @param renderInQuotations Sets to render the CSS for JQuery
     */
    public CSSLines(ArrayList<CSSLine> cssLines, boolean renderInQuotations)
    {
        this(cssLines, renderInQuotations, false);
    }

    /**
     * A New CSS Lines Holder, setting Braces Set, Quotations Set, pretty print as true
     *
     * @param cssLines           The lines that should be rendered for CSS Lines
     * @param renderInQuotations Sets to render the CSS for JQuery
     * @param renderBraces       Sets to render braces for the CSS
     */
    public CSSLines(ArrayList<CSSLine> cssLines, boolean renderInQuotations, boolean renderBraces)
    {
        this(cssLines, renderInQuotations, renderBraces, true, false);
    }

    /**
     * A New CSS Lines Holder, setting Braces Set, Quotations Set, and pretty print Set
     *
     * @param cssLines           The lines that should be rendered for CSS Lines
     * @param renderInQuotations Sets to render the CSS for JQuery
     * @param renderBraces       Sets to render braces for the CSS
     * @param prettyPrint        Sets to put on the pretty print
     * @param tinyHtml           Old field for tiny HTML - replaced with getNewLine();
     */
    public CSSLines(ArrayList<CSSLine> cssLines, boolean renderInQuotations, boolean renderBraces, boolean prettyPrint, boolean tinyHtml)
    {
        this.cssLines = cssLines;
        this.renderInQuotations = renderInQuotations;
        this.renderBraces = renderBraces;
        this.prettyPrint = prettyPrint;
        this.tinyHTML = tinyHtml;
    }

    /**
     * A New CSS Lines Holder, setting Braces Set, Quotations Set, and pretty print Set
     *
     * @param renderInQuotations Sets to render the CSS for JQuery
     * @param renderBraces       Sets to render braces for the CSS
     * @param prettyPrint        Sets to put on the pretty print
     */
    public CSSLines(boolean renderInQuotations, boolean renderBraces, boolean prettyPrint)
    {
        this(new ArrayList<CSSLine>(), renderInQuotations, renderBraces, prettyPrint, false);
    }

    /**
     * Get all CSSLines
     *
     * @return a list of CSS Line
     */
    public ArrayList<CSSLine> getCssLines()
    {
        if (cssLines == null)
        {
            cssLines = new ArrayList();
        }
        return cssLines;
    }

    /**
     * Reset this lines object with a new CSSLine
     *
     * @param cssLines The lines list to set
     */
    public void setCssLines(ArrayList<CSSLine> cssLines)
    {
        this.cssLines = cssLines;
    }

    /**
     *
     * @return Whether or not to enclose property and value in quotations '
     */
    public boolean isRenderInQuotations()
    {
        return renderInQuotations;
    }

    /**
     * Sets Whether or not to enclose property and value in quotations '
     *
     * @param renderInQuotations Sets Whether or not to enclose property and value in quotations '
     */
    public void setRenderInQuotations(boolean renderInQuotations)
    {
        this.renderInQuotations = renderInQuotations;
    }

    /**
     * Whether or not it must render opening and or closing braces {}
     *
     * @return Whether or not it must render opening and or closing braces {}
     */
    public boolean isRenderBraces()
    {
        return renderBraces;
    }

    /**
     * Sets Whether or not it must render opening and or closing braces {}
     *
     * @param renderBraces Whether or not it must render opening and or closing braces {}
     */
    public void setRenderBraces(boolean renderBraces)
    {
        this.renderBraces = renderBraces;
    }

    /**
     * Whether or not it must render new lines
     *
     * @return Whether or not it must render new lines
     */
    public boolean isPrettyPrint()
    {
        return prettyPrint;
    }

    /**
     * Sets Whether or not it must render new lines
     *
     * @param prettyPrint Whether or not it must render new lines
     */
    public void setPrettyPrint(boolean prettyPrint)
    {
        this.prettyPrint = prettyPrint;
    }

    /**
     * Returns whether or not should render in semi colons
     *
     * @return True or False
     */
    public boolean isRenderSemiColons()
    {
        return renderSemiColons;
    }

    /**
     * Sets whether or not to render in semi colons
     *
     * @param renderSemiColons True or False
     */
    public void setRenderSemiColons(boolean renderSemiColons)
    {
        this.renderSemiColons = renderSemiColons;
    }

    /**
     * Returns this lines CSS object with 0 tabs
     *
     * @return
     */
    @Override
    public String toString()
    {
        return toString(0, false);
    }

    /**
     * Returns this lines object at the tab count indentation
     *
     * @param tabCount     Number of tab indents to apply
     * @param renderInLine Set to make the render in line
     * @return The CSS line block
     */
    public String toString(int tabCount, boolean renderInLine)
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder tabs = TextUtilities.getTabString(tabCount);
        //String cssTabs = Component.tinyHtml ? "" : TextUtilities.getTabString(tinyHTML,tabCount + 1);
        StringBuilder cssTabsLess = TextUtilities.getTabString(tabCount - 1);

        if (isRenderBraces())
        {
            if (isPrettyPrint())
            {
                sb.append("\n");
            }
            sb.append("{");
            if (isPrettyPrint())
            {
                sb.append("\n");
            }
        }

        for (Iterator<CSSLine> it = getCssLines().iterator(); it.hasNext();)
        {
            CSSLine cSSLine = it.next();
            if (!isPrettyPrint())
            {
                sb.append(cSSLine.toString(renderInQuotations));
                sb.append(";");
                //sb.append(renderInLine ? ";" : ",");
            }
            else
            {
                sb.append(!isPrettyPrint() ? "" : tabs).append(cSSLine.toString(renderInQuotations)).append(";");
            }
            if (isPrettyPrint())
            {
                sb.append("\n");
            }
        }
        if (isRenderBraces())
        {
            sb.append(tinyHTML ? "" : cssTabsLess).append("}");
        }
        return sb.toString();
    }

    /**
     * Checks if this lines object is equal to another
     *
     * @param o Any object
     */
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof CSSLines)
        {
            CSSLines lines = (CSSLines) o;
            if (!lines.toString().equals(toString()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * A custom hash code
     *
     * @return
     */
    @Override
    public int hashCode()
    {
        return 2;
    }
}
