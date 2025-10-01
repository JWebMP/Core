package com.jwebmp.test;

import com.jwebmp.core.Page;
import com.jwebmp.testing.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pure unit test that constructs a Page and verifies it renders
 * "Hello World" in the body. This runs with the BaseTest lifecycle only
 * (no BrowserStack / network IO), per RULES.md Unit Tests guidance.
 */
public class HelloWorldPageTest extends BaseTest
{
    @Test
    @DisplayName("HelloWorld page renders expected content (unit)")
    public void helloWorldRenders()
    {
        Page<?> page = new Page<>();
        page.getBody().add("Hello World");

        String html = page.toString(true);
        String css = page.getCss().toString();
        String json = page.toJson();

        System.out.println(html);
        assertTrue(html.contains("Hello World"), "Rendered HTML should contain 'Hello World' text");
        assertTrue(html.toLowerCase().contains("<body") && html.toLowerCase().contains("</body>"),
                "Rendered HTML should include a body element");
    }
}
