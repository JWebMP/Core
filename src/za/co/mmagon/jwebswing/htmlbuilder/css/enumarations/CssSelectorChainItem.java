package za.co.mmagon.jwebswing.htmlbuilder.css.enumarations;

/**
 * Defines a specific CSS Type
 *
 * @author Marc Magon
 */
public enum CssSelectorChainItem
{
    /**
     * element element div p Selects all p elements where the parent is a div element
     */
    Parent(2.0, ">", CSSTypePosition.Middle),
    /**
     * [attribute] [target] Selects all elements with a target attribute
     */
    Attribute(2.0, "[]", CSSTypePosition.Wrap),
    /**
     * [attribute=value] [target=_blank] Selects all elements with target="_blank"
     */
    AttributeEquals(2.0, "=", CSSTypePosition.Middle),
    /**
     * [attribute~=value] [title~=flower] Selects all elements with a title attribute containing the word "flower"
     */
    AttributeContaining(2.0, "~=", CSSTypePosition.Middle),
    /**
     * [attribute|=value] [lang|=en] Selects all elements with a lang attribute value starting with "en"
     */
    AttributeStartsWith(2.0, "|=", CSSTypePosition.Middle),;

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

    private CssSelectorChainItem(double cssVersion, String cssName, CSSTypePosition cssPosition)
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
