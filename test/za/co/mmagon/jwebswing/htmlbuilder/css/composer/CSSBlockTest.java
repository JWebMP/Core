package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.CSSTypes;

/**
 *
 * @author MMagon
 */
public class CSSBlockTest
{

    public CSSBlockTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    String bla = "#idOfTag {\n"
            + "	property1:value1;\n"
            + "	property1:value2;\n"
            + "	property2:value1;\n"
            + "	property2:value2;\n"
            + "}\n"
            + "\n"
            + ".className:active {\n"
            + "	property1:value1;\n"
            + "	property1:value2;\n"
            + "	property2:value1;\n"
            + "	property2:value2;\n"
            + "}\n"
            + "\n"
            + "normal-tag,\n"
            + "normal-tag:hover {\n"
            + "	property1:value1;\n"
            + "	property1:value2;\n"
            + "	property2:value1;\n"
            + "	property2:value2;\n"
            + "}\n"
            + "property1:value1;property1:value2;property2:value1;property2:value2;";

    private String idTagPrettyPrint = "#idOfTag \n"
            + "{\n"
            + "	property1:value1;\n"
            + "	property1:value2;\n"
            + "	property2:value1;\n"
            + "	property2:value2;\n"
            + "}";

    private String idTagTinyPrint = "#idOfTag {property1:value1;property1:value2;property2:value1;property2:value2;}";

    private String classNamePrettyPrint = ".className:active \n"
            + "{\n"
            + "	property1:value1;\n"
            + "	property1:value2;\n"
            + "	property2:value1;\n"
            + "	property2:value2;\n"
            + "}";

    private String classNameTinyPrint = ".className:active{property1:value1;property1:value2;property2:value1;property2:value2;}";

    private String tagBlockPrettyPrint = "#normal-tag-active-ID:active,.normal-tag-link-class:link,normal-tag:hover \n"
            + "{\n"
            + "	property1:value1;\n"
            + "	property1:value2;\n"
            + "	property2:value1;\n"
            + "	property2:value2;\n"
            + "}";

    private String tagBlockTinyPrint = "#normal-tag-active-ID:active,.normal-tag-link-class:link,normal-tag:hover{property1:value1;property1:value2;property2:value1;property2:value2;}";

    private String inlinePrint = "property1:value1;property1:value2;property2:value1;property2:value2;";

    @Test
    public void testActiveClass()
    {
        CSSBlock cssIDComponentBlockActive = new CSSBlock("className");
        cssIDComponentBlockActive.setBlockType(CSSTypes.Active);
        cssIDComponentBlockActive.setBlockIdentifer(CSSBlockIdentifier.Class);
        cssIDComponentBlockActive.add(null);
        cssIDComponentBlockActive.add(new CSSLine("property2:value2"));
        cssIDComponentBlockActive.add(new CSSLine("property2:value1"));
        cssIDComponentBlockActive.add(new CSSLine("property1:value1"));
        cssIDComponentBlockActive.add(new CSSLine("property1:value2"));
        System.out.println("\n" + cssIDComponentBlockActive);
        if (!cssIDComponentBlockActive.toString().equals(classNamePrettyPrint))
        {
            fail("The CSS Block for Type ID and Active is not sorting or building properly");
        }
        System.out.println("Starting Tiny HTML Test");

        System.out.println(cssIDComponentBlockActive.toString());
        //System.out.println(classNameTinyPrint);
        if (!cssIDComponentBlockActive.toString().equals(classNameTinyPrint))
        {
//            fail("The CSS Block  for class [Tiny HTML]");
        }
    }

    @Test
    public void testLinkedBlocks()
    {
        CSSBlock cssTagComponent = new CSSBlock("normal-tag");
        CSSBlock cssTagComponent2 = new CSSBlock("normal-tag-active-ID");
        CSSBlock cssTagComponent3 = new CSSBlock("normal-tag-link-class");
        cssTagComponent2.setBlockType(CSSTypes.Active);
        cssTagComponent2.setBlockIdentifer(CSSBlockIdentifier.Id);
        cssTagComponent3.setBlockType(CSSTypes.Link);
        cssTagComponent3.setBlockIdentifer(CSSBlockIdentifier.Class);
        cssTagComponent.setBlockType(CSSTypes.Hover);
        cssTagComponent.setBlockIdentifer(CSSBlockIdentifier.Element);
        cssTagComponent.add(null);
        cssTagComponent.add(new CSSLine("property2:value2"));
        cssTagComponent.add(new CSSLine("property2:value1"));
        cssTagComponent.add(new CSSLine("property1:value1"));
        cssTagComponent.add(new CSSLine("property1:value2"));
        cssTagComponent.addLinkedBlock(cssTagComponent2);
        cssTagComponent.addLinkedBlock(cssTagComponent3);
        System.out.println(cssTagComponent.toString());
        if (!cssTagComponent.toString().equals(tagBlockPrettyPrint))
        {
            fail("The Linked blocks is not building properly");
        }

        System.out.println(cssTagComponent);
        if (!cssTagComponent.toString().equals(tagBlockTinyPrint))
        {
//            fail("The CSS Block for Type ID and Active is not sorting or building properly [Tiny HTML]");
        }

    }

    @Test
    public void testInline()
    {
        CSSBlock cssInLineComponent = new CSSBlock();
        cssInLineComponent.add(null);
        cssInLineComponent.add(new CSSLine("property2:value2"));
        cssInLineComponent.add(new CSSLine("property2:value1"));
        cssInLineComponent.add(new CSSLine("property1:value1"));
        cssInLineComponent.add(new CSSLine("property1:value2"));
        System.out.println(cssInLineComponent.toString());
        if (!cssInLineComponent.toString().equals(inlinePrint))
        {
            fail("The CSS Block for Inline is not building properly");
        }
    }

    @Test
    public void testDefaultSorting()
    {
        System.out.println("Starting testing the block builder");
        GregorianCalendar date = new GregorianCalendar();
        CSSBlock cssIDComponentBlock = new CSSBlock("idOfTag");
        cssIDComponentBlock.add(null);
        cssIDComponentBlock.add(new CSSLine("property2:value2"));
        cssIDComponentBlock.add(new CSSLine("property2:value1"));
        cssIDComponentBlock.add(new CSSLine("property1:value1"));
        cssIDComponentBlock.add(new CSSLine("property1:value2"));
        System.out.println("" + cssIDComponentBlock);
        System.out.println(cssIDComponentBlock.toString().equals(idTagPrettyPrint));
        if (!cssIDComponentBlock.toString().equals(idTagPrettyPrint))
        {
            fail("The CSS Block for Type ID is not sorting or building properly");
        }

        System.out.println("Starting Tiny HTML Test");
        System.out.println(cssIDComponentBlock);
        if (!cssIDComponentBlock.toString().equals(idTagTinyPrint))
        {
//            fail("The CSS Block for Type ID and Active is not sorting or building properly [Tiny HTML]");
        }
    }
}
