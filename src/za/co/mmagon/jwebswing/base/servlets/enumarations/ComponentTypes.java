/* 
 * Copyright (C) 2017 Marc Magon
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
package za.co.mmagon.jwebswing.base.servlets.enumarations;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This class registers all HTML accepted tags that can be used across all
 * browsers (IE6+)
 * <p>
 * When Enum get's extend capability then can add the HTML 5 components too, but
 * adding them here would break the point of jQuery
 * <p>
 * @author Marc Magon
 */
public enum ComponentTypes
{

    /**
     * Defines a document type
     */
    /**
     * Defines a document type
     */
    /**
     * Defines a document type
     */
    /**
     * Defines a document type
     */
    DocumentType("!"),
    /**
     * The CSS CSSLink Component
     */
    CSSLink("link"),
    Comment(""),
    /**
     * The normal link component
     */
    Link("a"),
    /**
     * The abbreviation component
     */
    Abbreviation("abbr"),
    /**
     * The address component
     */
    Address("addr"),
    /**
     * Defines an acronym. Displays as ABBR when being viewed by HTML 5
     */
    Acronym("acronym"),
    /**
     * Defines a Java Applet
     */
    Applet("applet"),
    /**
     * The A specific article. Only renders properly in HTML 5
     */
    Article("article"),
    /**
     * The area tag defines an area inside an image-map (an image-map is an
     * image with clickable areas).
     */
    Area("area"),
    /**
     * The ASide component only renders in HTML 5
     */
    Aside("aside"),
    /**
     * The Audio Component
     */
    Audio("audio"),
    /**
     * The Bold Component
     */
    Bold("b"),
    /**
     * The Base Component (The tag Base)
     */
    Base("base"),
    /**
     * The base font, deprecated I believe
     * <p>
     * @deprecated
     */
    BaseFont("basefont"),
    /**
     * The Body Div
     */
    Body("body"),
    /**
     * bdo stands for Bi-Directional Override.
     * <p>
     * The tag is used to override the current text direction.
     */
    BiDirectionalOverride("bdo"),
    /**
     * bdi stands for Bi-directional Isolation.
     * <p>
     * The &gt;bdi&lt; tag isolates a part of text that might be formatted in a
     * different direction from other text outside it.
     */
    BiDirectionalIsolation("bdi"),
    /**
     * The &gt;blockquote&lt; tag specifies a section that is quoted from
     * another source.
     */
    BlockQuotes("blockquote"),
    /**
     * Denotes a line break
     */
    LineBreak("br"),
    /**
     * The button tag defines a clickable button.
     */
    Button("button"),
    /**
     * The canvas tag is used to draw graphics, on the fly, via scripting
     * (usually JavaScript).
     */
    Canvas("canvas"),
    /**
     * The caption tag defines a table caption.
     */
    TableCaption("caption"),
    /**
     * The center tag is not supported in HTML5. Use CSS instead.
     * <p>
     * The center tag is used to center-align text.
     */
    Center("center"),
    /**
     * The cite tag defines the title of a work (e.g. a book, a song, a movie, a
     * TV show, a painting, a sculpture, etc.).
     */
    Cite("cite"),
    /**
     * Defines a piece of computer code
     */
    Code("code"),
    /**
     * Defines a table column
     */
    TableColumn("col"),
    /**
     * The colgroup tag specifies a group of one or more columns in a table for
     * formatting.
     */
    TableColumnGroup("colgroup"),
    /**
     * The datalist tag specifies a list of pre-defined options for an input
     * element.
     */
    DataList("datalist"),
    /**
     * The dd tag is used to describe a term/name in a description list.
     */
    DataDescription("dd"),
    /**
     * The del tag defines text that has been deleted from a document.
     */
    Deleted("del"),
    /**
     * The details tag specifies additional details that the user can view or
     * hide on demand.
     */
    Details("details"),
    /**
     * The dfn tag represents the defining instance of a term in HTML.
     */
    Definition("dfn"),
    /**
     * The dir tag is not supported in HTML5. Use CSS instead. The dir tag is
     * used to list directory titles.
     * <p>
     * @deprecated
     */
    DirectoryList("dir"),
    /**
     * The div tag defines a division or a section in an HTML document.
     * <p>
     * The dir tag is used to group block-elements to format them with CSS.
     */
    Div("div"),
    /**
     * The dl tag defines a definition list.
     */
    DescriptionList("dl"),
    /**
     * The dt tag defines a term/name in a description list.
     */
    DescriptionTag("dt"),
    /**
     * The em tag is a phrase tag. It renders as emphasized text.
     */
    Emphasized("em"),
    /**
     * The embed tag defines a container for an external application or
     * interactive content (a plug-in)
     */
    Embed("embed"),
    /**
     * The field-set tag is used to group related elements in a form.
     */
    FieldSet("fieldset"),
    /**
     * Defines a caption for a figure
     */
    FigureCaption("figcaption"),
    /**
     * The figure tag specifies self-contained content, like illustrations,
     * diagrams, photos, code listings, etc.
     */
    Figure("figure"),
    /**
     * Denotes a footer section of an address tag
     */
    Footer("footer"),
    /**
     * Defines a form container that posts back
     */
    Form("form"),
    /**
     * The Head Element for all meta-data about the web page
     */
    Head("head"),
    /**
     * The header element represents a container for introductory content or a
     * set of navigational links.
     */
    Header("header"),
    /**
     * The hgroup tag is used to group heading elements.
     */
    HeaderGroup("hgroup"),
    /**
     * Largest Header Size
     */
    Header1("h1"),
    /**
     * 2nd Largest Header Size
     */
    Header2("h2"),
    /**
     * Header Level 3
     */
    Header3("h3"),
    /**
     * Header Level 4
     */
    Header4("h4"),
    /**
     * Header Level 5
     */
    Header5("h5"),
    /**
     * Header Level 6
     */
    Header6("h6"),
    /**
     * Specifies an option in a data list or normal list
     */
    HorizontalRule("hr"),
    /**
     * The HTML tag tells the browser that this is an HTML document.
     */
    Html("html"),
    /*
     * Displays as Italic
     */
    Italic("i"),
    /**
     * Image Reference
     */
    Image("img"),
    /**
     * Specifies an IFrame
     */
    IFrame("iframe"),
    /**
     * Specifies an Input for a form tag
     */
    Input("input"),
    /**
     * Defines keyboard input
     */
    KeyboardInput("kbd"),
    /**
     * The keygen tag specifies a key-pair generator field used for forms.
     * <p>
     * When the form is submitted, the private key is stored locally, and the
     * public key is sent to the server.
     */
    KeyGen("keygen"),
    /**
     * The label tag defines a label for an input element.
     */
    Label("label"),
    /**
     * The legend tag defines a caption for the fieldset element.
     */
    Legend("legend"),
    /**
     * Defines a list item
     */
    ListItem("li"),
    /**
     * An unordered list
     */
    UnorderedList("ul"),
    /**
     * An ordered list
     */
    OrderedList("ol"),
    /**
     * A Map Component
     */
    Map("map"),
    /**
     * Highlights Text
     */
    Marker("mark"),
    /**
     * Specifies the meta-data for a page
     */
    Metadata("meta"),
    /**
     * Navigation Section
     */
    Navigation("nav"),
    /**
     * Displayed when no JavaScript is available
     */
    NoScript("noscript"),
    /**
     * The object tag defines an embedded object within an HTML document. Use
     * this element to embed multimedia (like audio, video, Java applets,
     * ActiveX, PDF, and Flash) in your web pages.
     */
    Object("object"),
    /**
     * Defines an option group for the select components children
     */
    OptionGroup("optgroup"),
    /**
     * The &lt;option&gt; tag defines an option in a select list.
     * <p>
     * &lt;option&gt; elements go inside a &lt;select&gt; or &lt;datalist&gt;
     * element.
     */
    Option("option"),
    /**
     * The output tag represents the result of a calculation (like one performed
     * by a script).
     *
     * @deprecated No Support in I.E.
     */
    Output("output"),
    /**
     * The param tag is used to define parameters for plugins embedded with an
     * object element.
     */
    Parameter("param"),
    /**
     * Defines a text paragraph
     */
    Paragraph("p"),
    /**
     * The &gt;pre&lt; tag defines preformatted text.
     * <p>
     * Text in a &gt;pre&lt; element is displayed in a fixed-width font (usually
     * Courier), and it preserves both spaces and line breaks.
     */
    PreFormatted("pre"),
    /**
     * Displays a progress bar
     */
    ProgressBar("progress"),
    /**
     * Defines a Quotation
     */
    Quotation("q"),
    /**
     * The rb tags sets what to show when the browser does not support ruby
     * annotations
     */
    RubyNoSupport("rp"),
    /**
     * Ruby Script
     */
    RubyTranslate("rt"),
    /**
     * Ruby
     */
    Ruby("ruby"),
    /**
     * The s tag marks information that is no longer relevant
     */
    S("s"),
    /**
     * defines sample output from a computer program.
     */
    SampleCode("samp"),
    /**
     * Defines a script object
     */
    Script("script"),
    /**
     * Defines sections in a document, such as chapters, headers, footers, or
     * any other sections of the document.
     */
    Section("section"),
    /**
     * The select element is used to create a drop-down list.
     */
    Select("select"),
    /**
     * Specifies Small Text
     */
    SmallText("small"),
    /**
     * Specifies a source for a Video or a Audio Object
     */
    Source("source"),
    /**
     * used to group inline-elements in a document.
     */
    Span("span"),
    /**
     * Defines important text
     */
    Strong("strong"),
    /**
     * Used to define style information for an HTML document.
     */
    Style("style"),
    /**
     * Specifies Sub Script
     */
    Subscript("sub"),
    /**
     * Defines a summary text for a detail object
     */
    Summary("summary"),
    /**
     * Defines superscript text
     */
    SuperScript("sup"),
    /**
     * defines a table
     */
    Table("table"),
    /**
     * A table body group
     */
    TableBodyGroup("tbody"),
    /**
     * Defines a table cell
     */
    TableCell("td"),
    /**
     * Defines a Text Area Input
     */
    TextArea("textarea"),
    /**
     * Defines a table footer group
     */
    TableFooterGroup("tfoot"),
    /**
     * Defines a Table
     */
    TableHeader("th"),
    /**
     * Defines a table header group
     */
    TableHeaderGroup("thead"),
    /**
     * The time object - Only for HTML 5 only
     */
    Time("time"),
    /**
     * Defines the title of a document
     */
    HeadTitle("title"),
    /**
     * Defines a table row
     */
    TableRow("tr"),
    /**
     * Defines a video Track
     */
    Track("track"),
    /**
     * Specifies Underlined Text
     */
    Underline("u"),
    /**
     * Defines a Variable type phrase
     */
    Variable("var"),
    /**
     * Defines a Video. HTML 5 Only
     */
    Video("video"),
    /**
     * Assists resizing by showing the browser where to set word breaks
     */
    WordBreak("wbr"),
    /**
     *
     */
    Feature("feature"),
    Event("event"),
    PageHTML("html"),
    /**
     * Formats a component as a CSS Class Name Reference Only
     */
    CSSClass("meh"),;

    private String componentTag;
    private Class classType;
    private Object instance;

    private ComponentTypes()
    {
    }

    private ComponentTypes(String componentTag)
    {
        this.componentTag = componentTag;
    }

    /**
     * Returns an array of all the values
     *
     * @return
     */
    public static ComponentTypes[] getAll()
    {
        return values();
    }

    /**
     * Returns the component tag
     *
     * @return
     */
    public String getComponentTag()
    {
        return componentTag;
    }

    /**
     * Descriptive string of the reference
     *
     * @return
     */
    @JsonValue
    @Override
    public String toString()
    {
        return this.name().toLowerCase();
    }
}
