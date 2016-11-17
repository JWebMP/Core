/*
 * Copyright (C) 2015 Marc Magon
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

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import za.co.mmagon.jwebswing.components.jquerylayout.layout.JQLayoutDefaultOptions;

/**
 *
 * @author Marc Magon
 */
public class JavaScriptPartTest
{

    public JavaScriptPartTest()
    {
    }

    @Test
    public void testDisplay()
            throws JsonProcessingException
    {
        JavaScriptPartImpl bean = new JavaScriptPartImpl();
        System.out.println(bean.toString());

        //assertEuq
    }

    public class JavaScriptPartImpl extends JavaScriptPart
    {

        private String name = "name";
        private JQLayoutDefaultOptions js;

        public JavaScriptPartImpl()
        {
            this.js = new JQLayoutDefaultOptions();
            js.setClosable(false);
            //js.setContainesTabs(true);
        }

        @Override
        public JavascriptPartType getJavascriptType()
        {
            return JavascriptPartType.Javascript;
        }

    }

}
