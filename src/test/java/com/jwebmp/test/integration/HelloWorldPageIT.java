package com.jwebmp.test.integration;

import com.jwebmp.core.Page;
import com.jwebmp.testing.BaseIntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Integration test that renders HTML, serves it via a JDK HttpServer, and validates the served output.
 * Extends BaseIntegrationTest so the BrowserStack Local tunnel is managed via JUnit extension.
 */
public class HelloWorldPageIT extends BaseIntegrationTest
{
    @Test
    @DisplayName("HelloWorld page renders expected content (served via JDK HttpServer)")
    public void helloWorldServedAndContainsText() throws Exception
    {
        // Delegate to BaseIntegrationTest core helper
        runHttpServerSmoke("Hello World");
    }

    @Override
    protected String htmlSupplier()
    {
        Page<?> page = new Page<>();
        page.getBody().add("Hello World");
        return page.toString(true);
    }

}
