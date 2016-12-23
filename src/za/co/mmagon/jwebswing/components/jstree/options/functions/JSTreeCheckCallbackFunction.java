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
package za.co.mmagon.jwebswing.components.jstree.options.functions;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptLiteralFunction;

/**
 *
 * @author GedMarc
 * @since 22 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeCheckCallbackFunction extends JavascriptLiteralFunction
{

    private static final long serialVersionUID = 1L;

    public static final String CreateNode = "create_node";
    public static final String RenameNode = "rename_node";
    public static final String DeleteNode = "delete_node";
    public static final String MoveNode = "move_node";
    public static final String CopyNode = "copy_node";

    private Boolean create;
    private Boolean rename;
    private Boolean delete;
    private Boolean move;
    private Boolean copy;

    public JSTreeCheckCallbackFunction()
    {
        getFunctionArugments().add("operation");
        getFunctionArugments().add("node");
        getFunctionArugments().add("node_parent");
        getFunctionArugments().add("node_position");
        getFunctionArugments().add("more");
    }

    @Override
    public StringBuilder getLiteralFunction()
    {
        StringBuilder function = new StringBuilder();
        if (create != null && create)
        {
            function.append("if(operation === '" + CreateNode + "') return true;");
        }
        if (rename != null && rename)
        {
            function.append("if(operation === '" + RenameNode + "') return true;");
        }
        if (delete != null && delete)
        {
            function.append("if(operation === '" + DeleteNode + "') return true;");
        }
        if (move != null && move)
        {
            function.append("if(operation === '" + MoveNode + "') return true;");
        }
        if (copy != null && copy)
        {
            function.append("if(operation === '" + CopyNode + "') return true;");
        }

        function.append("return false;");

        return function;
    }

    /**
     * Whether or not create is allowed
     *
     * @return
     */
    public Boolean getCreate()
    {
        return create;
    }

    /**
     * Whether or not create is allowed
     *
     * @param create
     */
    public void setCreate(Boolean create)
    {
        this.create = create;
    }
    /**
     * If rename is allowed
     * @return 
     */
    public Boolean getRename()
    {
        return rename;
    }

    /**
     * If rename is allowed
     * @param rename 
     */
    public void setRename(Boolean rename)
    {
        this.rename = rename;
    }

    /**
     * If delete is allowed
     * @return 
     */
    public Boolean getDelete()
    {
        return delete;
    }

    /**
     * if delete is allowed
     * @param delete 
     */
    public void setDelete(Boolean delete)
    {
        this.delete = delete;
    }

    /**
     * if move is allowed
     * @return 
     */
    public Boolean getMove()
    {
        return move;
    }

    /**
     * if move is allowed
     * @param move 
     */
    public void setMove(Boolean move)
    {
        this.move = move;
    }

    /**
     * if copy is allowed
     * @return 
     */
    public Boolean getCopy()
    {
        return copy;
    }

    /**
     * If copy is allowed
     * @param copy 
     */
    public void setCopy(Boolean copy)
    {
        this.copy = copy;
    }

}
