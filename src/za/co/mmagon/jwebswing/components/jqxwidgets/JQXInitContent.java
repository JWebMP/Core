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
package za.co.mmagon.jwebswing.components.jqxwidgets;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.jqxwidgets.navigationbar.JQXNavigationBar;
import za.co.mmagon.jwebswing.components.jqxwidgets.ribbon.JQXRibbon;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptLiteralFunction;

/**
 * This Class
 *
 * @author GedMarc
 * @since 30 Dec 2015
 */
public class JQXInitContent extends JavascriptLiteralFunction
{

    private static final long serialVersionUID = 1L;
    private StringBuilder function;

    public JQXInitContent(JQXRibbon ribbon)
    {
        getFunctionArugments().add("index");
        StringBuilder indexInits = new StringBuilder();
        String ifString = "if (index == ";
        String ifStart2 = ") {";
        String ifEnd = "}";

        ribbon.getRibbonItems().stream().forEach((ribbonScreen) ->
        {
            int indexNumber = ribbon.getRibbonItems().indexOf(ribbonScreen);
            String start = ifString + indexNumber;
            start += ifStart2;
            start += ribbonScreen.getContent().renderJavascriptAll();
            start += ifEnd;

            indexInits.append(start);

            ribbonScreen.getContent().getChildrenHierarchy().stream().filter((child) -> (child instanceof Component)).forEach((child) ->
            {
                Component.class.cast(child).setJavascriptRenderedElsewhere(true);
            });

        });

        //indexInits.append("resizeLayouts();");
        indexInits.append("$(window).resize();");
        function = indexInits;
    }

    /**
     * Configures a function to run the Init content
     *
     * @param navBar
     */
    public JQXInitContent(JQXNavigationBar navBar)
    {
        getFunctionArugments().add("index");
        StringBuilder indexInits = new StringBuilder();
        String ifString = "if (index == ";
        String ifStart2 = ") {";
        String ifEnd = "}";

        navBar.getGroups().stream().forEach((ribbonScreen) ->
        {
            int indexNumber = navBar.getGroups().indexOf(ribbonScreen);
            String start = ifString + indexNumber;
            start += ifStart2;
            start += ribbonScreen.getContent().renderJavascriptAll();
            start += ifEnd;
            indexInits.append(start);

            ribbonScreen.getContent().getChildrenHierarchy().stream().filter((child) -> (child instanceof Component)).forEach((child) ->
            {
                Component.class.cast(child).setJavascriptRenderedElsewhere(true);
            });
        });
        function = indexInits;
    }

    @Override
    public StringBuilder getLiteralFunction()
    {
        return function;
    }

    @Override
    public String toString()
    {
        return function.toString();
    }

}
