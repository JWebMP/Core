package com.jwebmp.test.core.events.keydown;

import com.jwebmp.core.events.keydown.KeyDownAdapter;
import com.jwebmp.test.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KeyDownAdapterTest
        extends BaseTestClass
{
    @Test
    public void test()
    {
        Div test = new DivSimple<>();
        test.setID("test");
        KeyDownAdapter aa = new KeyDownAdapter(test)
        {
            @Override
            public void onKeyDown(AjaxCall call, AjaxResponse response)
            {

            }
        };

        new KeyDownAdapter(test)
        {
            @Override
            public void onKeyDown(AjaxCall call, AjaxResponse response)
            {

            }
        }
        ;
        test.addEvent(aa.setID("test"));
        assertTrue(!test.getEvents()
                .isEmpty());
    }

    @Test
    public void testDirective()
    {
        Div test = new DivSimple<>();
        test.setID("test");

        KeyDownAdapter aa = new KeyDownAdapter(test)
        {
            @Override
            public void onKeyDown(AjaxCall call, AjaxResponse response)
            {

            }
        };
        test.addEvent(aa.setID("test"));
        System.out.println(test.toString(0));

    }

}
