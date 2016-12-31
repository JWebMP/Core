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
 * along with this program.  If not, see &lt;http://www.gnu.org/licenses/&gt;.
 */
package za.co.mmagon.jwebswing.components.bootstrap.componentoptions;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author GedMarc
 * @since 20 Apr 2016
 */
public enum BSComponentDefaultOptions implements IBSComponentOptions
{
    /**
     * Only do it when coming in (or hiding?)
     */
    In,
    /**
     * Only do it when going out (or showing
     */
    Out,
    /**
     * The primary font
     */
    Primary_Font,
    /**
     * Place to the left
     */
    Left,
    /**
     * Place to the right
     */
    Right,
    /**
     * A regular Button Group
     */
    Btn_Group,
    /**
     * Indicates smaller text (set to 85% of the size of the parent): Smaller text
     */
    Small,
    /**
     * Makes a text stand out: Stand out text
     */
    Lead,
    /**
     * Highlights text: Highlighted text
     */
    Mark,
    /**
     * Indicates left_aligned text
     */
    Text_Left,
    /**
     * Indicates center_aligned text
     */
    Text_Center,
    /**
     * Indicates right_aligned text
     */
    Text_Right,
    /**
     * Indicates justified text
     */
    Text_Justify,
    /**
     * Indicates no wrap text
     */
    Text_NoWrap,
    /**
     * Indicates lowercased text: LOWERCASED TEXT
     */
    Text_Lowercase,
    /**
     * Indicates uppercased text: uppercased text
     */
    Text_Uppercase,
    /**
     * Indicates capitalized text: capitalized text
     */
    Text_Capitalize,
    /**
     * Displays the text inside the &lt;abbr&gt; element in a slightly smaller font size
     */
    Initialism,
    /**
     * The .invisible class can be used to toggle only the visibility of an element, meaning its display is not modified and the element can still affect the flow of the document. Displays the item as
     */
    Invisible,
    /**
     * Indicates a blockquote with right_aligned content
     */
    Blockquote_reverse,
    /**
     * Removes the default list_style and left margin on list items (works on both &lt;ul&gt; and &lt;ol&gt;) This class only applies to immediate children list items (to remove the default list_style
     * from any nested lists, apply this class to any nested lists as well)
     */
    List_Unstyled,
    /*
     * Places all list items on a single line
     */
    List_Inline,
    /**
     * Lines up the terms and descriptions in the &lt;dl&gt; element side_by_side Starts off like default &lt;dl&gt;s, but when the browser window expands, it will line up side_by_side
     */
    Dl_Horizontal,
    /**
     * Adds basic styling to any button
     */
    Btn,
    /**
     * Indicates a default/standard button
     */
    Btn_Default,
    /**
     * Provides extra visual weight and identifies the primary action in a set of buttons
     */
    Btn_Primary,
    /**
     * Indicates a successful or positive action
     */
    Btn_Success,
    /**
     * Contextual button for informational alert messages
     */
    Btn_Info,
    /**
     * Indicates caution should be taken with this action
     */
    Btn_Warning,
    /**
     * Indicates a dangerous or potentially negative action
     */
    Btn_Danger,
    /**
     * Makes a button look like a link (will still have button behavior)
     */
    Btn_Link,
    /**
     * Makes a large button
     */
    Btn_Lg,
    /**
     * Makes a small button
     */
    Btn_Sm,
    /**
     * Makes an extra small button
     */
    Btn_Xs,
    /**
     * Makes a block_level button (spans the full width of the parent element)
     */
    Btn_Block,
    /**
     * Makes the button appear pressed
     */
    Active,
    /**
     * Makes the button disabled
     */
    Disabled,
    /**
     * Makes a &lt;form&gt; left_aligned with inline_block controls (This only applies to forms within viewports that are at least 768px wide)
     */
    Form_Inline,
    /**
     * Aligns labels and groups of form controls in a horizontal layout
     */
    Form_Horizontal,
    /**
     * Floats an element to the left
     */
    Pull_Left,
    /**
     * Floats an element to the right
     */
    Pull_Right,
    /**
     * Sets an element to display:block with margin_right:auto and margin_left:auto
     */
    Center_Block,
    /**
     * Forces an element to be shown
     */
    Show,
    /**
     * Forces an element to be hidden
     */
    Hidden,
    /**
     * Helps replace an element's text content with a background image
     */
    Text_Hide,
    /**
     * *
     * Indicates dropdown functionality (will reverse automatically in dropup menus)
     */
    Caret,
    /**
     * Adds rounded corners to an image (not available in IE8)
     */
    Img_Rounded,
    /**
     * Shapes the image to a circle (not available in IE8)
     */
    Img_Circle,
    /**
     * Shapes the image to a thumbnail
     */
    Img_Thumbnail,
    /**
     * Makes an image responsive (will scale nicely to the parent element)
     */
    Img_Responsive,
    /**
     * Adds basic styling (light padding and only horizontal dividers) to any &lt;table&gt;
     */
    Table,
    /**
     * Adds zebra_striping to any table row within &lt;tbody&gt; (not available in IE8)
     */
    Table_Striped,
    /**
     * Adds border on all sides of the table and cells
     */
    Table_Bordered,
    /**
     * Enables a hover state on table rows within a &lt;tbody&gt;
     */
    Table_Hover,
    /**
     * Makes table more compact by cutting cell padding in half
     */
    Table_Condensed,
    /**
     * Indicates a successful or positive action
     */
    Success,
    /**
     * Indicates a neutral informative change or action
     */
    Info,
    /**
     * Indicates a warning that might need attention
     */
    Warning,
    /**
     * Indicates a dangerous or potentially negative action
     */
    Danger,
    /**
     * Indicates a dropdown menu
     */
    Dropdown,
    /**
     * Builds the dropdown menu
     */
    Dropdown_Menu,
    /**
     * Right_aligns a dropdown menu
     */
    Dropdown_Menu_Right,
    /**
     * Adds a header inside the dropdown menu
     */
    Dropdown_Header,
    /**
     * Indicates a dropup menu
     */
    DropUp,
    /**
     * Separates items inside the dropdown menu with a horizontal line
     */
    Divider,
    /**
     * Creates navigation tabs
     */
    Nav$Nav_Tabs,
    /**
     * Creates navigation pills
     */
    Nav$Nav_Pills,
    /**
     * *
     * Creates vertical navigation pills
     */
    Nav$Nav_Pills$Nav_Stacked,
    /**
     * Makes navigation tabs/pills equal widths of their parent, at screens wider than 768px On smaller screens, the nav tabs/pills are stacked
     */
    Nav_Justified,
    /**
     * Together with tab_pane and data_toggle="tab" (data_toggle="pill" for pills), it makes the tab/pill toggable
     */
    Tab_Content,
    /**
     * Together with tab_content and data_toggle="tab" (data_toggle="pill" for pills), it makes the tab/pill toggable
     */
    Tab_Pane,
    /**
     * *
     * Provides simple pagination links (Previous/Next)
     */
    Pager,
    /**
     * Aligns the pager previous button to the left
     */
    Previous,
    /**
     * Aligns the pager next button to the right
     */
    Next,
    /**
     * Provides pagination links
     */
    Pagination,
    /**
     * Used together with the pagination class to provide larger pagination links
     */
    Pagination_lg,
    /*
     * Used together with the pagination class to provide smaller pagination links
     */
    Pagination_sm,
    /**
     * *
     * Indicates a default grey label
     */
    Label$Label_Default,
    /**
     * Indicates a blue label of type "primary"
     */
    Label$Label_Primary,
    /**
     * Indicates a green label of type "success"
     */
    Label$Label_Success,
    /**
     * Indicates a light blue label of type "info"
     */
    Label$Label_Info,
    /**
     * Indicates a yellow label of type "warning"
     */
    Label$Label_Warning,
    /**
     * Indicates a red label of type "danger"
     */
    Label$Label_Danger,
    /**
     * Indicates new or unread items
     */
    Badge,
    /**
     * Indicates a big box for calling extra attention to featured content or information
     */
    Jumbotron,
    /**
     * Huge Text
     */
    Huge,
    /**
     * Represents a Modal
     */
    Modal,
    /**
     * Instructs to fade in
     */
    Fade,
    /**
     * The content of the modal
     */
    Modal_Content,
    /**
     * The header of the modal
     */
    Modal_Header,
    /**
     * The body of the modal
     */
    Modal_Body,
    /**
     * The footer of the modal
     */
    Modal_Footer,;

    @JsonValue
    @Override
    public String toString()
    {
        String name = name().toLowerCase().replaceAll("\\$", " ").replaceAll("_", "-");
        return name;
    }

}
