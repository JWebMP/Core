package com.jwebmp.test.core.events.select;

import com.jwebmp.core.events.select.SelectAdapter;
import com.jwebmp.test.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.DivSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelectAdapterTest
        extends BaseTestClass
{
    @Test
    public void test()
    {
        Div test = new DivSimple<>();
        test.setID("test");
        SelectAdapter aa = new SelectAdapter(test)
        {
            @Override
            public void onSelect(AjaxCall call, AjaxResponse response)
            {

            }
        };
        test.addEvent(aa.setID("test"));
        assertTrue(!test.getEvents()
                .isEmpty());
    }

}
