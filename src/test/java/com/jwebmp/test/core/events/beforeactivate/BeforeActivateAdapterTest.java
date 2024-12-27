package com.jwebmp.test.core.events.beforeactivate;

import com.jwebmp.core.events.beforeactivate.BeforeActivateAdapter;
import com.jwebmp.test.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BeforeActivateAdapterTest
        extends BaseTestClass
{
    @Test
    public void test()
    {
        Div test = new DivSimple<>();
        test.setID("test");
        BeforeActivateAdapter aa = new BeforeActivateAdapter(test)
        {
            @Override
            public void onBeforeActivate(AjaxCall call, AjaxResponse response)
            {

            }
        };
        test.addEvent(aa.setID("test"));
        assertTrue(!test.getEvents()
                .isEmpty());
    }

}
