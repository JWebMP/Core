package za.co.mmagon.jwebswing.htmlbuilder.css.enumarations;

/**
 * Defines a specific CSS Type
 *
 * @author Marc Magon
 */
public enum CSSTypes
{
    /**
     * Specifies don't render any additional details
     */
    None(1.0, "", CSSTypePosition.After),
    /**
     * Formats the CSS for a link object.
     */
    Link(1.0, ":link", CSSTypePosition.After),
    /**
     * Formats the CSS for a link object.
     */
    Visited(1.0, ":visited", CSSTypePosition.After),
    /**
     * Formats the CSS for a link object.
     */
    Active(1.0, ":active", CSSTypePosition.After),
    /**
     * Formats the CSS for a link object.
     */
    Hover(1.0, ":hover", CSSTypePosition.After),
    /**
     * The first letter of anything
     */
    First_Letter(1.0, "::first-letter", CSSTypePosition.After),
    /**
     * The first line of anything
     */
    First_Line(1.0, "::first-line", CSSTypePosition.After),
    /**
     * Everything
     */
    Asterix(2.0, "*", CSSTypePosition.Before),
    /**
     * ::after p::after Insert something after the content of each p element
     */
    After(2.0, "::after", CSSTypePosition.After),
    /**
     * ::before p::before Insert something before the content of each p element
     */
    Before(2.0, "::before", CSSTypePosition.After),
    /**
     * :first-child p:first-child Selects every p element that is the first child of its parent
     */
    First_Child(2.0, ":first-child", CSSTypePosition.After),
    /**
     * :focus input:focus Selects the input element which has focus
     */
    Focus(2.0, "*", CSSTypePosition.After);
    ;
    /**
     * The physical version of this CSS
     */
    private double cssVersion;
    /**
     * The name to represent
     */
    private String cssName;
    /**
     * Where to place the position
     */
    private final CSSTypePosition cssPosition;

    /**
     * Constructs a new CSS Render Type
     *
     * @param cssVersion  The version the CSS Render type works on
     * @param cssName     The physical display name of the selector
     * @param cssPosition Where to place the type
     */
    private CSSTypes(double cssVersion, String cssName, CSSTypePosition cssPosition)
    {
        this.cssVersion = cssVersion;
        this.cssName = cssName;
        this.cssPosition = cssPosition;
    }

    /**
     * Returns the capable CSS Version
     *
     * @return
     */
    public double getCssVersion()
    {
        return cssVersion;
    }

    /**
     * Sets the capable CSS Version
     *
     * @param cssVersion
     */
    public void setCssVersion(double cssVersion)
    {
        this.cssVersion = cssVersion;
    }

    /**
     * Returns the CSS Name of this type
     *
     * @return
     */
    public String getCssName()
    {
        return cssName;
    }

    /**
     * Returns the CSS Name of this type
     *
     * @param cssName
     */
    public void setCssName(String cssName)
    {
        this.cssName = cssName;
    }

    /**
     * Returns where this CSS name type is placed
     *
     * @return
     */
    public CSSTypePosition getCssPosition()
    {
        return cssPosition;
    }
}
