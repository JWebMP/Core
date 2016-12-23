/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.htmlbuilder.javascript;

import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.Component;

/**
 * This Class renders a base function with sections denoted for dynamic building
 *
 * @author GedMarc
 * @since 30 Dec 2015
 */
public abstract class JavascriptLiteralFunction extends JavascriptFunction
{

    private static final long serialVersionUID = 1L;

    /**
     * The first rendered starting string
     */
    private StringBuilder literalFunctionStartingString;
    /**
     * the middle rendered string
     */
    //private StringBuilder literalFunction;
    /**
     * The closing string '}'
     */
    private final StringBuilder literalFunctionEndingString = new StringBuilder("}");
    /**
     * Any arguments to be passed into the function
     */
    private List<String> functionArugments;

    /**
     * An actual function
     */
    public JavascriptLiteralFunction()
    {

    }

    /**
     * Adds the component, and all of its children's JavaScript into this function
     *
     * @param c               The root component to start at
     * @param includeChildren Whether or not to include children
     */
    public void addComponentsJavascript(Component c, boolean includeChildren)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(c.renderJavascriptAll());
        getLiteralFunction().append(sb);
    }

    /**
     * Adds the component, and all of its children's JavaScript into this function
     *
     * @param c The root component to start at
     */
    public void addComponentsJavascript(Component c)
    {
        addComponentsJavascript(c, true);
    }

    /**
     * The actual string to include in the function
     *
     * @return
     */
    public abstract StringBuilder getLiteralFunction();

    /**
     * Returns this functions output string
     *
     * @return
     */
    @Override
    public String toString()
    {
        return renderFunction();
    }

    /**
     * Sets the function's ending string
     *
     * @return
     */
    public StringBuilder getLiteralFunctionStartingString()
    {
        return literalFunctionStartingString;
    }

    /**
     * Sets the function starting string
     *
     * @param literalFunctionStartingString
     */
    public void setLiteralFunctionStartingString(StringBuilder literalFunctionStartingString)
    {
        this.literalFunctionStartingString = literalFunctionStartingString;
    }

    /**
     * Gets any functional argument that may be required
     *
     * @return
     */
    public final List<String> getFunctionArugments()
    {
        if (functionArugments == null)
        {
            functionArugments = new ArrayList<>();
        }
        return functionArugments;
    }

    /**
     * Sets any functional arguments required
     *
     * @param functionArugments
     */
    public final void setFunctionArugments(List<String> functionArugments)
    {
        this.functionArugments = functionArugments;
    }

    /**
     * Renders this function (calls to string)
     *
     * @return
     */
    @Override
    public String renderFunction()
    {
        StringBuilder returnable = new StringBuilder();
        literalFunctionStartingString = new StringBuilder("function (" + functionArugments.toString().replace("[", "").replace("]", "") + ") {");
        returnable.append(literalFunctionStartingString);
        returnable.append(getLiteralFunction());
        returnable.append(literalFunctionEndingString);
        return returnable.toString();
    }

}
