/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.jstree.options;

import com.armineasy.injection.GuiceContext;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.TreeMap;
import za.co.mmagon.jwebswing.components.jstree.options.functions.JSTreeCheckCallbackFunction;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since 22 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeCoreOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * If left as false the HTML inside the jstree container element is used to populate the tree (that should be an unordered list with list items). You can also pass in a HTML string or a JSON array
     * here. It is possible to pass in a standard jQuery-like AJAX config and jstree will automatically determine if the response is JSON or HTML and use that to populate the tree. In addition to the
     * standard jQuery ajax options here you can suppy functions for data and url, the functions will be run in the current instance's scope and a param will be passed indicating which node is being
     * loaded, the return value of those functions will be used. The last option is to specify a function, that function will receive the node being loaded as argument and a second param which is a
     * function which should be called with the result.
     */
    private JSTreeAjaxConfigOptions data;
    /**
     * configure the various strings used throughout the tree You can use an object where the key is the string you need to replace and the value is your replacement. Another option is to specify a
     * function which will be called with an argument of the needed string and should return the replacement. If left as false no replacement is made.
     */
    private Map<String, String> strings;
    /**
     * determines what happens when a user tries to modify the structure of the tree
     * <p>
     * If left as false all operations like create, rename, delete, move or copy are prevented. You can set this to true to allow all interactions or use a function to have better control.
     */
    @JsonProperty("check_callback")
    private JSTreeCheckCallbackFunction checkCallback;
    /**
     * the open / close animation duration in milliseconds - set this to false to disable the animation (default is 200)
     */
    private Integer animation;
    /**
     * a boolean indicating if multiple nodes can be selected
     */
    private Boolean multiple;

    public JSTreeCoreOptions()
    {

    }

    /**
     * If left as false the HTML inside the jstree container element is used to populate the tree (that should be an unordered list with list items). You can also pass in a HTML string or a JSON array
     * here. It is possible to pass in a standard jQuery-like AJAX config and jstree will automatically determine if the response is JSON or HTML and use that to populate the tree. In addition to the
     * standard jQuery ajax options here you can suppy functions for data and url, the functions will be run in the current instance's scope and a param will be passed indicating which node is being
     * loaded, the return value of those functions will be used. The last option is to specify a function, that function will receive the node being loaded as argument and a second param which is a
     * function which should be called with the result.
     *
     * @return
     */
    public JSTreeAjaxConfigOptions getData()
    {
        if (data == null)
        {
            data = GuiceContext.Injector().getInstance(JSTreeAjaxConfigOptions.class);
        }
        return data;
    }

    /**
     * If left as false the HTML inside the jstree container element is used to populate the tree (that should be an unordered list with list items). You can also pass in a HTML string or a JSON array
     * here. It is possible to pass in a standard jQuery-like AJAX config and jstree will automatically determine if the response is JSON or HTML and use that to populate the tree. In addition to the
     * standard jQuery ajax options here you can suppy functions for data and url, the functions will be run in the current instance's scope and a param will be passed indicating which node is being
     * loaded, the return value of those functions will be used. The last option is to specify a function, that function will receive the node being loaded as argument and a second param which is a
     * function which should be called with the result.
     *
     * @param data
     */
    public void setData(JSTreeAjaxConfigOptions data)
    {
        this.data = data;
    }

    /**
     * configure the various strings used throughout the tree You can use an object where the key is the string you need to replace and the value is your replacement. Another option is to specify a
     * function which will be called with an argument of the needed string and should return the replacement. If left as false no replacement is made.
     *
     * @return
     */
    public Map<String, String> getStrings()
    {
        if (strings == null)
        {
            strings = new TreeMap<>();
        }
        return strings;
    }

    /**
     * configure the various strings used throughout the tree You can use an object where the key is the string you need to replace and the value is your replacement. Another option is to specify a
     * function which will be called with an argument of the needed string and should return the replacement. If left as false no replacement is made.
     *
     * @param strings
     */
    public void setStrings(Map<String, String> strings)
    {
        this.strings = strings;
    }

    /**
     * determines what happens when a user tries to modify the structure of the tree
     * <p>
     * If left as false all operations like create, rename, delete, move or copy are prevented. You can set this to true to allow all interactions or use a function to have better control.
     *
     * @return
     */
    public JSTreeCheckCallbackFunction getCheckCallback()
    {
        if (checkCallback == null)
        {
            checkCallback = new JSTreeCheckCallbackFunction();
        }
        return checkCallback;
    }

    /**
     * determines what happens when a user tries to modify the structure of the tree
     * <p>
     * If left as false all operations like create, rename, delete, move or copy are prevented. You can set this to true to allow all interactions or use a function to have better control.
     *
     * @param checkCallback
     */
    public void setCheckCallback(JSTreeCheckCallbackFunction checkCallback)
    {
        this.checkCallback = checkCallback;
    }

    /**
     * the open / close animation duration in milliseconds - set this to false to disable the animation (default is 200)
     *
     * @return
     */
    public Integer getAnimation()
    {
        return animation;
    }

    /**
     * the open / close animation duration in milliseconds - set this to false to disable the animation (default is 200)
     *
     * @param animation
     */
    public void setAnimation(Integer animation)
    {
        this.animation = animation;
    }

    /**
     * a boolean indicating if multiple nodes can be selected
     *
     * @return
     */
    public Boolean getMultiple()
    {
        return multiple;
    }

    /**
     * a boolean indicating if multiple nodes can be selected
     *
     * @param multiple
     */
    public void setMultiple(Boolean multiple)
    {
        this.multiple = multiple;
    }

}
