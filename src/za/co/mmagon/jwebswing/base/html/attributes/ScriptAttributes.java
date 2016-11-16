package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Valid script attributes
 *
 * @since 2013/11/14
 * @version 1.0
 * @author MMagon
 *
 *
 */
public enum ScriptAttributes implements AttributeDefinitions
{
    Async,
    Charset,
    Defer,
    Src,
    Type;

    private ScriptAttributes()
    {
        
    }
    
    private boolean keyWord;
    
    private ScriptAttributes(boolean isKeyword)
    {
        this.keyWord = isKeyword;
    }
    /**
     * Returns the lowercase name
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

    @Override
    public boolean isKeyword()
    {
        return keyWord;
    }
}
