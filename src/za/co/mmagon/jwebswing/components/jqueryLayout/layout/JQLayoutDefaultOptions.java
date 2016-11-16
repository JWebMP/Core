package za.co.mmagon.jwebswing.components.jqueryLayout.layout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.components.bootstrap.BootstrapSize;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Cursors;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
import za.co.mmagon.jwebswing.htmlbuilder.effects.JWAnimationEffectsPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * Users the JavaScript part rather
 *
 * @since 2014 07 28
 * @version 1.0
 * @author MMagon
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JQLayoutDefaultOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Layout Options object
     * <p>
     */
    public JQLayoutDefaultOptions()
    {
    }
    
    /**
     * If the layout is responsive or not
     */
    private Boolean responsive;
    /**
     * When the layout should be responsive
     */
    private BootstrapSize responsiveWhen;
    
    
    /**
     * When open, pane can be resized
     */
    private Boolean resizable;
    /**
     * Pane can open and close
     */
    private Boolean closable;
    /**
     * When closed; pane can 'slide' open over other panes - closes on mouse-out
     */
    private Boolean slidable;
    /**
     * Show pane resizing or show outline
     */
    private Boolean livePaneResizing;
    /**
     * Enable animation on Pane
     */
    private Boolean animatePaneSizing;
    /**
     * Sets to show the overflow for the panel or not
     */
    private Boolean showOverflowOnHover;
    /**
     * Scrolls to a bookmark This option handles of bookmarks that are passed on the URL of the page: http://www.site.com/page.html#myBookmark
     */
    private Boolean scrollToBookmarkOnLoad;

    //Element Selectors Strings
    private JQLayoutDiv paneSelector;
    private JQLayoutDiv contentSelector;
    private JQLayoutDiv contentIgnoreSelector;

    //Auto-generated Classnames
    private String paneClass;
    private String resizerClass;
    private String togglerClass;
    private String buttonClass;

    //Pane Size & Spacing
    private Integer size;
    private Integer minSize;
    private Integer maxSize;
    private Integer spacing_closed;
    private Integer spacing_open;

    //Resizer-bar Formatting
    private Cursors resizerCursor;
    private Double resizerDragOpacity;
    private Cursors sliderCursor;
    private Boolean maskIframesOnResize;
    private String slideTrigger_open;
    private String slideTrigger_close;

    //Toggler-button Formatting
    private Integer togglerLength_open;
    private Integer togglerLength_closed;
    private Boolean hideTogglerOnSlide;
    private String togglerAlign_open;
    private String togglerAlign_closed;
    private String togglerContent_open;
    private String togglerContent_closed;

    //Pane Open/Close Hotkeys
    private Boolean enableCursorHotkey;
    private CustomHotkeyModifier customHotkeyModifier;
    private Character customHotkey;

    //Pane Animation Effects
    private EasingEffects fxName;
    private EasingEffects fxName_open;
    private EasingEffects fxName_close;
    private Integer fxSpeed;
    private Integer fxSpeed_open;
    private Integer fxSpeed_close;
    private JWAnimationEffectsPart fxSettings;
    private JWAnimationEffectsPart fxSettings_open;
    private JWAnimationEffectsPart fxSettings_close;

    //Layout State Initialization
    private Boolean initClosed;
    private Boolean initHidden;

    //Custom entries for all the addons
    //Panel override entry
    @JsonIgnore
    private JQLayoutDiv layoutDiv;
    @JsonRawValue(value = true)
    @JsonProperty(value = "onresizeall_end")
    private String onResize;

    public String getOnResize()
    {
        return onResize;
    }

    public void setOnResize(String onResize)
    {
        this.onResize = onResize;
    }

    /**
     * When open, pane can be resized
     *
     * @return
     */
    public Boolean isResizable()
    {
        return resizable;
    }

    /**
     * When open, pane can be resized
     *
     * @param resizable
     */
    public void setResizable(Boolean resizable)
    {
        this.resizable = resizable;
    }

    /**
     * Pane can open and close
     *
     * @return
     */
    public Boolean isClosable()
    {
        return closable;
    }

    /**
     * Pane can open and close
     *
     * @param closable
     */
    public void setClosable(Boolean closable)
    {
        this.closable = closable;
    }

    /**
     * When closed; pane can 'slide' open over other panes - closes on mouse-out
     *
     * @return
     */
    public Boolean isSlidable()
    {
        return slidable;
    }

    /**
     * When closed; pane can 'slide' open over other panes - closes on mouse-out
     *
     * @param slidable
     */
    public void setSlidable(Boolean slidable)
    {
        this.slidable = slidable;
    }

    /**
     * Show pane resizing or show outline
     *
     * @return
     */
    public Boolean isLivePaneResizing()
    {
        return livePaneResizing;
    }

    /**
     * Show pane resizing or show outline
     *
     * @param livePaneResizing
     */
    public void setLivePaneResizing(Boolean livePaneResizing)
    {
        this.livePaneResizing = livePaneResizing;
    }

    /**
     * Enable animation on Pane
     *
     * @return
     */
    public Boolean isAnimatePaneSizing()
    {
        return animatePaneSizing;
    }

    /**
     * Enable animation on Pane
     *
     * @param animatePaneSizing
     */
    public void setAnimatePaneSizing(Boolean animatePaneSizing)
    {
        this.animatePaneSizing = animatePaneSizing;
    }

    /**
     * Scrolls to a bookmark This option handles of bookmarks that are passed on the URL of the page: http://www.site.com/page.html#myBookmark
     *
     * @return
     */
    public Boolean isShowOverflowOnHover()
    {
        return showOverflowOnHover;
    }

    /**
     * Scrolls to a bookmark This option handles of bookmarks that are passed on the URL of the page: http://www.site.com/page.html#myBookmark
     * <p>
     * @param showOverflowOnHover
     */
    public void setShowOverflowOnHover(Boolean showOverflowOnHover)
    {
        this.showOverflowOnHover = showOverflowOnHover;
    }

    /**
     * Scrolls to a bookmark This option handles of bookmarks that are passed on the URL of the page: http://www.site.com/page.html#myBookmark
     * <p>
     * @return
     */
    public Boolean isScrollToBookmarkOnLoad()
    {
        return scrollToBookmarkOnLoad;
    }

    /**
     * Scrolls to a bookmark This option handles of bookmarks that are passed on the URL of the page: http://www.site.com/page.html#myBookmark
     * <p>
     * @param scrollToBookmarkOnLoad
     */
    public void setScrollToBookmarkOnLoad(Boolean scrollToBookmarkOnLoad)
    {
        this.scrollToBookmarkOnLoad = scrollToBookmarkOnLoad;
    }

    /**
     * paneSelector = ".ui-layout-PANE" (any valid jQuery selector string)
     * <p>
     * MUST set individually for EACH PANE
     * <p>
     * Default values are: ".ui-layout-north", ".ui-layout-west", etc. Any valid jQuery selector string can be used - classNames, IDs, etc.
     * <p>
     * To allow for 'nesting' of layouts, there are rules for how pane-elements are related to the layout-container. More flexibility was added in version 1.1.2 to handle panes are nested inside a
     * 'form' or other element.
     * <p>
     * Rules for the relationship between a pane and its container:
     * <p>
     * When an 'ID' is specified for paneSelector, the pane-element only needs to be a descendant of the container – it does NOT have to be a 'child'.
     * <p>
     * When a 'class-name' is specified for paneSelector, the pane-element must be EITHER: a child of the container, or... a child of a form-element that is a child of the container (must be the
     * 'first form' inside the container)
     * <p>
     * @return
     */
    public JQLayoutDiv getPaneSelector()
    {
        return paneSelector;
    }

    /**
     * paneSelector = ".ui-layout-PANE" (any valid jQuery selector string)
     * <p>
     * MUST set individually for EACH PANE
     * <p>
     * Default values are: ".ui-layout-north", ".ui-layout-west", etc. Any valid jQuery selector string can be used - classNames, IDs, etc.
     * <p>
     * To allow for 'nesting' of layouts, there are rules for how pane-elements are related to the layout-container. More flexibility was added in version 1.1.2 to handle panes are nested inside a
     * 'form' or other element.
     * <p>
     * Rules for the relationship between a pane and its container:
     * <p>
     * When an 'ID' is specified for paneSelector, the pane-element only needs to be a descendant of the container – it does NOT have to be a 'child'.
     * <p>
     * When a 'class-name' is specified for paneSelector, the pane-element must be EITHER: a child of the container, or... a child of a form-element that is a child of the container (must be the
     * 'first form' inside the container)
     * <p>
     * @param paneSelector
     */
    public void setPaneSelector(JQLayoutDiv paneSelector)
    {
        this.paneSelector = paneSelector;
    }

    /**
     * contentSelector = ".ui-layout-content" (any valid jQuery selector string)
     * <p>
     * MUST be a 'child' of one of the panes
     * <p>
     * Selector string for INNER div/element. This div will auto-size so only it scrolls, and not the entire pane.
     * <p>
     * Same class-name could be used for divs inside all panes.
     * <p>
     * SEE Content-Scrolling below for more information.
     * <p>
     * @return
     */
    public JQLayoutDiv getContentSelector()
    {
        return contentSelector;
    }

    /**
     * contentSelector = ".ui-layout-content" (any valid jQuery selector string)
     * <p>
     * MUST be a 'child' of one of the panes
     * <p>
     * Selector string for INNER div/element. This div will auto-size so only it scrolls, and not the entire pane.
     * <p>
     * Same class-name could be used for divs inside all panes.
     * <p>
     * SEE Content-Scrolling below for more information.
     * <p>
     * @param contentSelector
     */
    public void setContentSelector(JQLayoutDiv contentSelector)
    {
        this.contentSelector = contentSelector;
    }

    /**
     * contentIgnoreSelector = "ui-layout-ignore" (any valid jQuery selector string)
     * <p>
     * Selector string for INNER divs/elements. These elements will be 'ignored' when calculations are done to auto-size the content element. This may be necessary if there are elements inside the
     * pane that are absolutely-positioned and intended to 'overlay' other elements.
     * <p>
     * Same class-name could be used for elements inside all panes
     * <p>
     * @return
     */
    public JQLayoutDiv getContentIgnoreSelector()
    {
        return contentIgnoreSelector;
    }

    /**
     * contentIgnoreSelector = "ui-layout-ignore" (any valid jQuery selector string)
     * <p>
     * Selector string for INNER divs/elements. These elements will be 'ignored' when calculations are done to auto-size the content element. This may be necessary if there are elements inside the
     * pane that are absolutely-positioned and intended to 'overlay' other elements.
     * <p>
     * Same class-name could be used for elements inside all panes
     * <p>
     * @param contentIgnoreSelector
     */
    public void setContentIgnoreSelector(JQLayoutDiv contentIgnoreSelector)
    {
        this.contentIgnoreSelector = contentIgnoreSelector;
    }

    /**
     * paneClass = "ui-layout-pane" (any valid className)
     * <p>
     * Used for auto-generated classNames for each 'layout pane':
     * <p>
     * // default classes applied to the 'west pane'. class="ui-layout-pane ui-layout-pane-west ui-layout-pane-open ui-layout-pane-west-open"
     * <p>
     * The last two classes change when the pane is closed:
     * <p>
     * class="... ui-layout-pane-closed ui-layout-pane-west-closed"
     * <p>
     *
     * @return
     */
    public String getPaneClass()
    {
        return paneClass;
    }

    /**
     * paneClass = "ui-layout-pane" (any valid className)
     * <p>
     * Used for auto-generated classNames for each 'layout pane':
     * <p>
     * // default classes applied to the 'west pane' class="ui-layout-pane ui-layout-pane-west ui-layout-pane-open ui-layout-pane-west-open"
     * <p>
     * The last two classes change when the pane is closed:
     * <p>
     * class="... ui-layout-pane-closed ui-layout-pane-west-closed"
     *
     *
     * @param paneClass
     */
    public void setPaneClass(String paneClass)
    {
        this.paneClass = paneClass;
    }

    /**
     * resizerClass = "ui-layout-resizer" (any valid className)
     * <p>
     * Used for auto-generated classNames for each 'resizer-bar':
     * <p>
     * class="ui-layout-resizer ui-layout-resizer-west ui-layout-resizer-open ui-layout-resizer-west-open"
     * <p>
     * The last two classes change when the pane is closed:
     * <p>
     * class="... ui-layout-resizer-closed ui-layout-resizer-west-closed"
     * <p>
     * If the pane was 'slid open', 2 additional classes are generated:
     * <p>
     * class="... ui-layout-resizer-sliding ui-layout-resizer-west-sliding"
     * <p>
     * When a pane is 'resized', the 'real resizer-bar' gets 2 additional classes:
     * <p>
     * class="... ui-layout-resizer-drag ui-layout-resizer-west-drag"
     * <p>
     * The 'cloned resizer-bar' – which is actually 'dragged' – gets 2 different styles:
     * <p>
     * class="... ui-layout-resizer-dragging ui-layout-resizer-west-dragging"
     * <p>
     * @return
     */
    public String getResizerClass()
    {
        return resizerClass;
    }

    /**
     * resizerClass = "ui-layout-resizer" (any valid className)
     * <p>
     * Used for auto-generated classNames for each 'resizer-bar':
     * <p>
     * class="ui-layout-resizer ui-layout-resizer-west ui-layout-resizer-open ui-layout-resizer-west-open"
     * <p>
     * The last two classes change when the pane is closed:
     * <p>
     * class="... ui-layout-resizer-closed ui-layout-resizer-west-closed"
     * <p>
     * If the pane was 'slid open', 2 additional classes are generated:
     * <p>
     * class="... ui-layout-resizer-sliding ui-layout-resizer-west-sliding"
     * <p>
     * When a pane is 'resized', the 'real resizer-bar' gets 2 additional classes:
     * <p>
     * class="... ui-layout-resizer-drag ui-layout-resizer-west-drag"
     * <p>
     * The 'cloned resizer-bar' – which is actually 'dragged' – gets 2 different styles:
     * <p>
     * class="... ui-layout-resizer-dragging ui-layout-resizer-west-dragging"
     *
     * @param resizerClass
     */
    public void setResizerClass(String resizerClass)
    {
        this.resizerClass = resizerClass;
    }

    /**
     * togglerClass = "ui-layout-toggler" (any valid className)
     * <p>
     * Used for auto-generated classNames for each 'toggler-button':
     * <p>
     * class="ui-layout-toggler ui-layout-toggler-open ui-layout-toggler-west ui-layout-toggler-west-open"
     * <p>
     * The last two classes change when the pane is closed:
     * <p>
     * class="... ui-layout-toggler-closed ui-layout-toggler-west-closed"
     * <p>
     * The toggler is 'inside' the resizer, so can also be accessed using those classes:
     * <p>
     * CSS Rule - hide toggler while resizing .ui-layout-resizer-drag ui-layout-toggler { display: none; }
     *
     *
     * @return
     */
    public String getTogglerClass()
    {
        return togglerClass;
    }

    /**
     * togglerClass = "ui-layout-toggler" (any valid className)
     * <p>
     * Used for auto-generated classNames for each 'toggler-button':
     * <p>
     * class="ui-layout-toggler ui-layout-toggler-open ui-layout-toggler-west ui-layout-toggler-west-open"
     * <p>
     * The last two classes change when the pane is closed:
     * <p>
     * class="... ui-layout-toggler-closed ui-layout-toggler-west-closed"
     * <p>
     * The toggler is 'inside' the resizer, so can also be accessed using those classes:
     * <p>
     * /* CSS Rule - hide toggler while resizing .ui-layout-resizer-drag ui-layout-toggler { display: none; }
     *
     * @param togglerClass
     */
    public void setTogglerClass(String togglerClass)
    {
        this.togglerClass = togglerClass;
    }

    /**
     * buttonClass = "ui-layout-button" (any valid className)
     * <p>
     * This is used as a prefix when generating classNames for 'custom buttons'. (Do not confuse with normal 'toggler-buttons')
     * <p>
     * FIRST, the 'type' (action) of the button is appended:
     * <p>
     * ui-layout-button-toggle ui-layout-button-open ui-layout-button-close ui-layout-button-pin
     * <p>
     * THEN, the 'pane name' of the button is appended, like:
     * <p>
     * ui-layout-button-toggle-west ui-layout-button-open-south
     * <p>
     * Here are the generated styles for a custom 'close-button' for the 'west-pane':
     * <p>
     * class="ui-layout-button-close ui-layout-button-close-west"
     * <p>
     * Pin-buttons have additional classes added for 'pin-up' and 'pin-down' states:
     * <p>
     * class="ui-layout-button-pin ui-layout-button-pin-west ui-layout-button-pin-up ui-layout-button-pin-west-up"
     * <p>
     * The last two classes change when the pane is 'pinned' (open):
     * <p>
     * class="... ui-layout-button-pin-down ui-layout-button-pin-west-down"
     *
     * @return
     */
    public String getButtonClass()
    {
        return buttonClass;
    }

    /**
     * buttonClass = "ui-layout-button" (any valid className)
     * <p>
     * This is used as a prefix when generating classNames for 'custom buttons'. (Do not confuse with normal 'toggler-buttons')
     * <p>
     * FIRST, the 'type' (action) of the button is appended:
     * <p>
     * ui-layout-button-toggle ui-layout-button-open ui-layout-button-close ui-layout-button-pin
     * <p>
     * THEN, the 'pane name' of the button is appended, like:
     * <p>
     * ui-layout-button-toggle-west ui-layout-button-open-south
     * <p>
     * Here are the generated styles for a custom 'close-button' for the 'west-pane':
     * <p>
     * class="ui-layout-button-close ui-layout-button-close-west"
     * <p>
     * Pin-buttons have additional classes added for 'pin-up' and 'pin-down' states:
     * <p>
     * class="ui-layout-button-pin ui-layout-button-pin-west ui-layout-button-pin-up ui-layout-button-pin-west-up"
     * <p>
     * The last two classes change when the pane is 'pinned' (open):
     * <p>
     * class="... ui-layout-button-pin-down ui-layout-button-pin-west-down"
     *
     * @param buttonClass
     */
    public void setButtonClass(String buttonClass)
    {
        this.buttonClass = buttonClass;
    }

    /**
     * size = "auto" (N/S) "200" (E/W) ("auto" or integer - pixels)
     * <p>
     * Specifies the initial size of the panes - 'height' for north south panes - 'width' for east and west. If "auto", then pane will size to fit its content - most useful for north/south panes (to
     * auto-fit your banner or toolbar), but also works for east/west panes.
     * <p>
     * You normally will want different sizes for the panes, but a 'default size' can be set
     *
     * @return
     */
    public Integer getSize()
    {
        return size;
    }

    /**
     * size = "auto" (N/S) "200" (E/W) ("auto" or integer - pixels)
     * <p>
     * Specifies the initial size of the panes - 'height' for north south panes - 'width' for east and west. If "auto", then pane will size to fit its content - most useful for north/south panes (to
     * auto-fit your banner or toolbar), but also works for east/west panes.
     * <p>
     * You normally will want different sizes for the panes, but a 'default size' can be set
     *
     * @param size
     */
    public void setSize(Integer size)
    {
        this.size = size;
    }

    /**
     * minSize = 50 (integer - pixels)
     * <p>
     * Minimum-size limit when resizing a pane (0 = as small as pane can go)
     *
     * @return
     */
    public Integer getMinSize()
    {
        return minSize;
    }

    /**
     * minSize = 50 (integer - pixels)
     * <p>
     * Minimum-size limit when resizing a pane (0 = as small as pane can go)
     *
     * @param minSize
     */
    public void setMinSize(Integer minSize)
    {
        this.minSize = minSize;
    }

    /**
     * Maximum-size limit when resizing a pane (0 = as large as pane can go)
     *
     * @return
     */
    public Integer getMaxSize()
    {
        return maxSize;
    }

    /**
     * Maximum-size limit when resizing a pane (0 = as large as pane can go)
     *
     * @param maxSize
     */
    public void setMaxSize(Integer maxSize)
    {
        this.maxSize = maxSize;
    }

    /**
     * Spacing between pane and adjacent pane - when pane is 'open' or 'closed' default 6
     *
     * @return
     */
    public Integer getSpacing_closed()
    {
        return spacing_closed;
    }

    /**
     * Spacing between pane and adjacent pane - when pane is 'open' or 'closed' default 6
     *
     * @param spacing_closed
     */
    public void setSpacing_closed(Integer spacing_closed)
    {
        this.spacing_closed = spacing_closed;
    }

    /**
     * Spacing between pane and adjacent pane - when pane is 'open' or 'closed'
     *
     * @return
     */
    public Integer getSpacing_open()
    {
        return spacing_open;
    }

    /**
     * Spacing between pane and adjacent pane - when pane is 'open' or 'closed'
     *
     * @param spacing_open
     */
    public void setSpacing_open(Integer spacing_open)
    {
        this.spacing_open = spacing_open;
    }

    /**
     * resizerCursor = "resizer-p" (any valid CSS cursor)
     * <p>
     * MUST set individually for EACH PANE Default values are: "resize-n", "resize-w", etc.
     * <p>
     * This is the cursor when the mouse is over the 'resizer-bar'. However, if the mouse is over the 'toggler-button' inside the resizer bar, then the cursor is a 'pointer' - ie, the togglerCursor
     * instead of the resizerCursor.
     *
     * @return
     */
    public Cursors getResizerCursor()
    {
        return resizerCursor;
    }

    /**
     * resizerCursor = "resizer-p" (any valid CSS cursor)
     * <p>
     * MUST set individually for EACH PANE Default values are: "resize-n", "resize-w", etc.
     * <p>
     * This is the cursor when the mouse is over the 'resizer-bar'. However, if the mouse is over the 'toggler-button' inside the resizer bar, then the cursor is a 'pointer' - ie, the togglerCursor
     * instead of the resizerCursor.
     *
     * @param resizerCursor
     */
    public void setResizerCursor(Cursors resizerCursor)
    {
        this.resizerCursor = resizerCursor;
    }

    /**
     * resizerDragOpacity = 1 (decimal value between 0 and 1)
     * <p>
     * Opacity of resizer bar when 'dragging' to resize a pane.
     * <p>
     * This value is passed to the ui.draggable widget
     * <p>
     * Leave this set to '1' if you want to use CSS to control opacity. Otherwise you must use !important to override the specified opacity.
     *
     * @return
     */
    public Double getResizerDragOpacity()
    {
        return resizerDragOpacity;
    }

    /**
     * resizerDragOpacity = 1 (decimal value between 0 and 1)
     * <p>
     * Opacity of resizer bar when 'dragging' to resize a pane.
     * <p>
     * This value is passed to the ui.draggable widget
     * <p>
     * Leave this set to '1' if you want to use CSS to control opacity. Otherwise you must use !important to override the specified opacity.
     *
     * @param resizerDragOpacity
     */
    public void setResizerDragOpacity(Double resizerDragOpacity)
    {
        this.resizerDragOpacity = resizerDragOpacity;
    }

    /**
     * sliderCursor = "pointer" (any valid CSS cursor)
     * <p>
     * Cursor when resizer-bar will trigger 'sliding open' - ie, when pane is 'closed'
     *
     * @return
     */
    public Cursors getSliderCursor()
    {
        return sliderCursor;
    }

    /**
     * sliderCursor = "pointer" (any valid CSS cursor)
     * <p>
     * Cursor when resizer-bar will trigger 'sliding open' - ie, when pane is 'closed'
     *
     * @param sliderCursor
     */
    public void setSliderCursor(Cursors sliderCursor)
    {
        this.sliderCursor = sliderCursor;
    }

    /**
     * maskIframesOnResize = true (true, false, jQuery Selector string)
     * <p>
     * When enabled, layout will 'mask' iframes on the page when the resizer-bar is 'dragged' to resize a pane. This solved problems related to dragging an element over an iframe.
     * <p>
     * If desired, you can mask only specific iframes and/or only when specific panes are resized
     *
     * @return
     */
    public Boolean isMaskIframesOnResize()
    {
        return maskIframesOnResize;
    }

    /**
     * maskIframesOnResize = true (true, false, jQuery Selector string)
     * <p>
     * When enabled, layout will 'mask' iframes on the page when the resizer-bar is 'dragged' to resize a pane. This solved problems related to dragging an element over an iframe.
     * <p>
     * If desired, you can mask only specific iframes and/or only when specific panes are resized
     *
     * @param maskIframesOnResize
     */
    public void setMaskIframesOnResize(Boolean maskIframesOnResize)
    {
        this.maskIframesOnResize = maskIframesOnResize;
    }

    /**
     * slideTrigger_open = "click" ("click", "dblclick", "mouseover"}
     *
     * @return
     */
    public String getSlideTrigger_open()
    {
        return slideTrigger_open;
    }

    /**
     * slideTrigger_open = "click" ("click", "dblclick", "mouseover"
     *
     * @param slideTrigger_open
     */
    public void setSlideTrigger_open(String slideTrigger_open)
    {
        this.slideTrigger_open = slideTrigger_open;
    }

    /**
     * slideTrigger_close = "mouseout" ("click", "mouseout")
     * <p>
     * Trigger events to 'slide open' and 'slide closed' a pane
     *
     * @return
     */
    public String getSlideTrigger_close()
    {
        return slideTrigger_close;
    }

    /**
     * slideTrigger_close = "mouseout" ("click", "mouseout")
     * <p>
     * Trigger events to 'slide open' and 'slide closed' a pane
     *
     * @param slideTrigger_close
     */
    public void setSlideTrigger_close(String slideTrigger_close)
    {
        this.slideTrigger_close = slideTrigger_close;
    }

    /**
     * togglerLength_closed = 50 (integer - pixels)
     * <p>
     * Length of toggler-button when pane is 'open' or 'closed'.
     * <p>
     * Length means 'width' for north/south togglers, and 'height' for east/west togglers.
     * <p>
     * "100%" OR -1 means 'full height/width of resizer bar' - 0 means 'hidden'
     *
     * @return
     */
    public Integer getTogglerLength_open()
    {
        return togglerLength_open;
    }

    /**
     *  /**
     * togglerLength_closed = 50 (integer - pixels)
     * <p>
     * Length of toggler-button when pane is 'open' or 'closed'.
     * <p>
     * Length means 'width' for north/south togglers, and 'height' for east/west togglers.
     * <p>
     * "100%" OR -1 means 'full height/width of resizer bar' - 0 means 'hidden'
     *
     * @param togglerLength_open
     */
    public void setTogglerLength_open(Integer togglerLength_open)
    {
        this.togglerLength_open = togglerLength_open;
    }

    /**
     * togglerLength_closed = 50 (integer - pixels)
     * <p>
     * Length of toggler-button when pane is 'open' or 'closed'.
     * <p>
     * Length means 'width' for north/south togglers, and 'height' for east/west togglers.
     * <p>
     * "100%" OR -1 means 'full height/width of resizer bar' - 0 means 'hidden'
     *
     * @return
     */
    public Integer getTogglerLength_closed()
    {
        return togglerLength_closed;
    }

    /**
     * togglerLength_closed = 50 (integer - pixels)
     * <p>
     * Length of toggler-button when pane is 'open' or 'closed'.
     * <p>
     * Length means 'width' for north/south togglers, and 'height' for east/west togglers.
     * <p>
     * "100%" OR -1 means 'full height/width of resizer bar' - 0 means 'hidden'
     *
     * @param togglerLength_closed
     */
    public void setTogglerLength_closed(Integer togglerLength_closed)
    {
        this.togglerLength_closed = togglerLength_closed;
    }

    /**
     * hideTogglerOnSlide = false (true, false)
     * <p>
     * If true, the toggler-button is hidden when a pane is 'slid-open'. This makes sense because the user only needs to 'mouse-off' to close the pane.
     * <p>
     * You could set this 'false' and use CSS to do the same thing:
     *
     * @return
     */
    public Boolean isHideTogglerOnSlide()
    {
        return hideTogglerOnSlide;
    }

    /**
     * hideTogglerOnSlide = false (true, false)
     * <p>
     * If true, the toggler-button is hidden when a pane is 'slid-open'. This makes sense because the user only needs to 'mouse-off' to close the pane.
     * <p>
     * You could set this 'false' and use CSS to do the same thing:
     *
     * @param hideTogglerOnSlide
     */
    public void setHideTogglerOnSlide(Boolean hideTogglerOnSlide)
    {
        this.hideTogglerOnSlide = hideTogglerOnSlide;
    }

    /**
     * togglerAlign_open = "center" (position-keyword or integer - pixels) togglerAlign_closed = "center" (position-keyword or integer - pixels)
     * <p>
     * Alignment of toggler button inside the resizer-bar when pane is 'open' or 'closed'.
     * <p>
     * A positive integer means a pixel offset from top or left
     * <p>
     * A negative integer means a pixel offset from bottom or right
     * <p>
     * Position-Keywords: "left", "center", "right", "top", "middle", "bottom"
     *
     * @return
     */
    public String getTogglerAlign_open()
    {
        return togglerAlign_open;
    }

    /**
     * togglerAlign_open = "center" (position-keyword or integer - pixels) togglerAlign_closed = "center" (position-keyword or integer - pixels)
     * <p>
     * Alignment of toggler button inside the resizer-bar when pane is 'open' or 'closed'.
     * <p>
     * A positive integer means a pixel offset from top or left
     * <p>
     * A negative integer means a pixel offset from bottom or right
     * <p>
     * Position-Keywords: "left", "center", "right", "top", "middle", "bottom"
     *
     * @param togglerAlign_open
     */
    public void setTogglerAlign_open(String togglerAlign_open)
    {
        this.togglerAlign_open = togglerAlign_open;
    }

    /**
     * togglerAlign_open = "center" (position-keyword or integer - pixels) togglerAlign_closed = "center" (position-keyword or integer - pixels)
     * <p>
     * Alignment of toggler button inside the resizer-bar when pane is 'open' or 'closed'.
     * <p>
     * A positive integer means a pixel offset from top or left
     * <p>
     * A negative integer means a pixel offset from bottom or right
     * <p>
     * Position-Keywords: "left", "center", "right", "top", "middle", "bottom"
     *
     * @return
     */
    public String getTogglerAlign_closed()
    {
        return togglerAlign_closed;
    }

    /**
     * togglerAlign_open = "center" (position-keyword or integer - pixels) togglerAlign_closed = "center" (position-keyword or integer - pixels)
     * <p>
     * Alignment of toggler button inside the resizer-bar when pane is 'open' or 'closed'.
     * <p>
     * A positive integer means a pixel offset from top or left
     * <p>
     * A negative integer means a pixel offset from bottom or right
     * <p>
     * Position-Keywords: "left", "center", "right", "top", "middle", "bottom"
     *
     * @param togglerAlign_closed
     */
    public void setTogglerAlign_closed(String togglerAlign_closed)
    {
        this.togglerAlign_closed = togglerAlign_closed;
    }

    public String getTogglerContent_open()
    {
        return togglerContent_open;
    }

    /**
     * togglerContent_open = "" (text or HTML) togglerContent_closed = "" (text or HTML)
     * <p>
     * Usually a background-image is set in CSS to customize a toggler-button. However, you can also put text inside a toggler by using these options. The text is wrapped in a SPAN, which is then
     * added inside the toggler DIV. The SPAN classes identify them as either 'open' or 'closed' content:
     *
     * @param togglerContent_open
     */
    public void setTogglerContent_open(Component togglerContent_open)
    {
        this.togglerContent_open = togglerContent_open.toString(true);
    }

    /**
     * togglerContent_open = "" (text or HTML) togglerContent_closed = "" (text or HTML)
     * <p>
     * Usually a background-image is set in CSS to customize a toggler-button. However, you can also put text inside a toggler by using these options. The text is wrapped in a SPAN, which is then
     * added inside the toggler DIV. The SPAN classes identify them as either 'open' or 'closed' content:
     *
     * @return
     */
    public String getTogglerContent_closed()
    {
        return togglerContent_closed;
    }

    /**
     * togglerContent_open = "" (text or HTML) togglerContent_closed = "" (text or HTML)
     * <p>
     * Usually a background-image is set in CSS to customize a toggler-button. However, you can also put text inside a toggler by using these options. The text is wrapped in a SPAN, which is then
     * added inside the toggler DIV. The SPAN classes identify them as either 'open' or 'closed' content:
     *
     * @param togglerContent_closed
     */
    public void setTogglerContent_closed(Component togglerContent_closed)
    {
        this.togglerContent_closed = togglerContent_closed.toString(true);
    }

    /**
     * enableCursorHotkey = true (true, false)
     * <p>
     * If 'true', then 'cursor hotkeys' are enabled. Can be set per-pane if desired.
     * <p>
     * <p>
     * These default hotkeys cannot be changed - only enabled or disabled.
     * <p>
     * <p>
     * The cursor/arrow key must be pressed in combination with CTRL -or- SHIFT
     * <p>
     * Toggle North-pane: CTRL+Up or SHIFT+Up Toggle South-pane: CTRL+Down or SHIFT+Down Toggle West-pane: CTRL+Left or SHIFT+Left Toggle East-pane: CTRL+Right or SHIFT+Right * The SHIFT+ARROW
     * combinations are ignored if pressed while the cursor is in a form field, allowing users to 'select text' — eg: SHIFT+Right in a TEXTAREA
     *
     * @return
     */
    public Boolean isEnableCursorHotkey()
    {
        return enableCursorHotkey;
    }

    /**
     * enableCursorHotkey = true (true, false)
     * <p>
     * If 'true', then 'cursor hotkeys' are enabled. Can be set per-pane if desired.
     * <p>
     * <p>
     * These default hotkeys cannot be changed - only enabled or disabled.
     * <p>
     * <p>
     * The cursor/arrow key must be pressed in combination with CTRL -or- SHIFT
     * <p>
     * Toggle North-pane: CTRL+Up or SHIFT+Up Toggle South-pane: CTRL+Down or SHIFT+Down Toggle West-pane: CTRL+Left or SHIFT+Left Toggle East-pane: CTRL+Right or SHIFT+Right * The SHIFT+ARROW
     * combinations are ignored if pressed while the cursor is in a form field, allowing users to 'select text' — eg: SHIFT+Right in a TEXTAREA
     *
     * @param enableCursorHotkey
     */
    public void setEnableCursorHotkey(Boolean enableCursorHotkey)
    {
        this.enableCursorHotkey = enableCursorHotkey;
    }

    /**
     * customHotkeyModifier = "SHIFT" ("CTRL", "SHIFT", "CTRL+SHIFT")
     * <p>
     * Custom hotkeys must be pressed in combination with either the CTRL or SHIFT key - or both together. Use this option to choose which modifier-key(s) to use with the customHotKey.
     * <p>
     * If this option is missing or invalid, "CTRL+SHIFT" is assumed.
     * <p>
     * NOTE: The ALT key cannot be used because it is not detected by some browsers.
     *
     * @return
     */
    public CustomHotkeyModifier getCustomHotkeyModifier()
    {
        return customHotkeyModifier;
    }

    /**
     * customHotkeyModifier = "SHIFT" ("CTRL", "SHIFT", "CTRL+SHIFT")
     * <p>
     * Custom hotkeys must be pressed in combination with either the CTRL or SHIFT key - or both together. Use this option to choose which modifier-key(s) to use with the customHotKey.
     * <p>
     * If this option is missing or invalid, "CTRL+SHIFT" is assumed.
     * <p>
     * NOTE: The ALT key cannot be used because it is not detected by some browsers.
     *
     * @param customHotkeyModifier
     */
    public void setCustomHotkeyModifier(CustomHotkeyModifier customHotkeyModifier)
    {
        this.customHotkeyModifier = customHotkeyModifier;
    }

    /**
     * customHotkey = "" (alphanumeric character OR a charCode)
     * <p>
     * MUST set individually for EACH PANE
     * <p>
     * If a hotkey is specified, it is automatically enabled. It does not matter whether 'cursor hotkeys' are also enabled – those are separate.
     * <p>
     * You can specify any of the following values:
     * <p>
     * letter from A to Z number from 0 to 9 Javascript charCode value for the key
     * <p>
     * The customHotkeys option must be set separately for each pane, but the customHotkeyModifier option can be set once, as the 'default' for all panes.
     *
     * @return
     */
    public Character getCustomHotkey()
    {
        return customHotkey;
    }

    /**
     * customHotkey = "" (alphanumeric character OR a charCode)
     * <p>
     * MUST set individually for EACH PANE
     * <p>
     * If a hotkey is specified, it is automatically enabled. It does not matter whether 'cursor hotkeys' are also enabled – those are separate.
     * <p>
     * You can specify any of the following values:
     * <p>
     * letter from A to Z number from 0 to 9 Javascript charCode value for the key
     * <p>
     * The customHotkeys option must be set separately for each pane, but the customHotkeyModifier option can be set once, as the 'default' for all panes.
     *
     * @param customHotkey
     */
    public void setCustomHotkey(Character customHotkey)
    {
        this.customHotkey = customHotkey;
    }

    /**
     * fxName = "slide" ("none", "slide", "drop", "scale", customer effect name)
     * <p>
     * Animation effect for open/close. Choose a preset effect OR can specify a custom fxName as long as you also specify fxSettings
     *
     * @return
     */
    public EasingEffects getFxName()
    {
        return fxName;
    }

    /**
     * fxName = "slide" ("none", "slide", "drop", "scale", customer effect name)
     * <p>
     * Animation effect for open/close. Choose a preset effect OR can specify a custom fxName as long as you also specify fxSettings
     *
     * @param fxName
     */
    public void setFxName(EasingEffects fxName)
    {
        this.fxName = fxName;
    }

    /**
     * fxName = "slide" ("none", "slide", "drop", "scale", customer effect name)
     * <p>
     * Animation effect for open/close. Choose a preset effect OR can specify a custom fxName as long as you also specify fxSettings
     *
     * @return
     */
    public EasingEffects getFxName_open()
    {
        return fxName_open;
    }

    /**
     * fxName = "slide" ("none", "slide", "drop", "scale", customer effect name)
     * <p>
     * Animation effect for open/close. Choose a preset effect OR can specify a custom fxName as long as you also specify fxSettings
     *
     * @param fxName_open
     */
    public void setFxName_open(EasingEffects fxName_open)
    {
        this.fxName_open = fxName_open;
    }

    /**
     * fxName = "slide" ("none", "slide", "drop", "scale", customer effect name)
     * <p>
     * Animation effect for open/close. Choose a preset effect OR can specify a custom fxName as long as you also specify fxSettings s
     *
     * @return
     */
    public EasingEffects getFxName_close()
    {
        return fxName_close;
    }

    /**
     * fxName = "slide" ("none", "slide", "drop", "scale", customer effect name)
     * <p>
     * Animation effect for open/close. Choose a preset effect OR can specify a custom fxName as long as you also specify fxSettings
     *
     * @param fxName_close
     */
    public void setFxName_close(EasingEffects fxName_close)
    {
        this.fxName_close = fxName_close;
    }

    /**
     * fxSpeed = integer - ms
     * <p>
     * Speed of animations – standard jQuery keyword like 'fast', or a millisecond value.
     *
     * @return
     */
    public Integer getFxSpeed()
    {
        return fxSpeed;
    }

    /**
     * fxSpeed = "normal" ("fast", "normal", "slow", integer - ms)
     * <p>
     * Speed of animations – standard jQuery keyword like 'fast', or a millisecond value.
     *
     * @param fxSpeed
     */
    public void setFxSpeed(Integer fxSpeed)
    {
        this.fxSpeed = fxSpeed;
    }

    /**
     * fxSpeed = "normal" ("fast", "normal", "slow", integer - ms)
     * <p>
     * Speed of animations – standard jQuery keyword like 'fast', or a millisecond value.
     *
     * @return
     */
    public Integer getFxSpeed_open()
    {
        return fxSpeed_open;
    }

    /**
     * fxSpeed = "normal" ("fast", "normal", "slow", integer - ms)
     * <p>
     * Speed of animations – standard jQuery keyword like 'fast', or a millisecond value.
     *
     * @param fxSpeed_open
     */
    public void setFxSpeed_open(Integer fxSpeed_open)
    {
        this.fxSpeed_open = fxSpeed_open;
    }

    /**
     * fxSpeed = "normal" ("fast", "normal", "slow", integer - ms)
     * <p>
     * Speed of animations – standard jQuery keyword like 'fast', or a millisecond value.
     *
     * @return
     */
    public Integer getFxSpeed_close()
    {
        return fxSpeed_close;
    }

    /**
     * fxSpeed = "normal" ("fast", "normal", "slow", integer - ms)
     * <p>
     * Speed of animations – standard jQuery keyword like 'fast', or a millisecond value.
     *
     * @param fxSpeed_close
     */
    public void setFxSpeed_close(Integer fxSpeed_close)
    {
        this.fxSpeed_close = fxSpeed_close;
    }

    /**
     * fxSettings = {} (Hash containing fx-settings)
     * <p>
     * You can customize the default animation settings by passing new settings, like:
     * <p>
     * $("body").layout({ fxName: "slide" , fxSettings: { duration: 500, easing: "bounceInOut" } });
     *
     * @return
     */
    public JWAnimationEffectsPart getFxSettings()
    {
        return fxSettings;
    }

    /**
     * fxSettings = {} (Hash containing fx-settings)
     * <p>
     * You can customize the default animation settings by passing new settings, like:
     * <p>
     * $("body").layout({ fxName: "slide" , fxSettings: { duration: 500, easing: "bounceInOut" } });
     *
     * @param fxSettings
     */
    public void setFxSettings(JWAnimationEffectsPart fxSettings)
    {
        this.fxSettings = fxSettings;
    }

    /**
     * fxSettings = {} (Hash containing fx-settings)
     * <p>
     * You can customize the default animation settings by passing new settings, like:
     * <p>
     * $("body").layout({ fxName: "slide" , fxSettings: { duration: 500, easing: "bounceInOut" } });
     *
     * @return
     */
    public JWAnimationEffectsPart getFxSettings_open()
    {
        return fxSettings_open;
    }

    /**
     * fxSettings = {} (Hash containing fx-settings)
     * <p>
     * You can customize the default animation settings by passing new settings, like:
     * <p>
     * $("body").layout({ fxName: "slide" , fxSettings: { duration: 500, easing: "bounceInOut" } });
     *
     * @param fxSettings_open
     */
    public void setFxSettings_open(JWAnimationEffectsPart fxSettings_open)
    {
        this.fxSettings_open = fxSettings_open;
    }

    /**
     * fxSettings = {} (Hash containing fx-settings)
     * <p>
     * You can customize the default animation settings by passing new settings, like:
     * <p>
     * $("body").layout({ fxName: "slide" , fxSettings: { duration: 500, easing: "bounceInOut" } });
     *
     * @return
     */
    public JWAnimationEffectsPart getFxSettings_close()
    {
        return fxSettings_close;
    }

    /**
     * fxSettings = {} (Hash containing fx-settings)
     * <p>
     * You can customize the default animation settings by passing new settings, like:
     * <p>
     * $("body").layout({ fxName: "slide" , fxSettings: { duration: 500, easing: "bounceInOut" } });
     *
     * @param fxSettings_close
     */
    public void setFxSettings_close(JWAnimationEffectsPart fxSettings_close)
    {
        this.fxSettings_close = fxSettings_close;
    }

    /**
     * initClosed = false (true, false)
     * <p>
     * If 'true', then pane is 'closed' when layout is created
     *
     * @return
     */
    public Boolean isInitClosed()
    {
        return initClosed;
    }

    /**
     * initClosed = false (true, false)
     * <p>
     * If 'true', then pane is 'closed' when layout is created
     *
     * @param initClosed
     */
    public void setInitClosed(Boolean initClosed)
    {
        this.initClosed = initClosed;
    }

    /**
     * initHidden = false (true, false)
     * <p>
     * If 'true', then pane is 'hidden' when layout is created - no resizer or spacing is visible, as if the pane does not exist!
     *
     * @return
     */
    public Boolean isInitHidden()
    {
        return initHidden;
    }

    /**
     * initHidden = false (true, false)
     * <p>
     * If 'true', then pane is 'hidden' when layout is created - no resizer or spacing is visible, as if the pane does not exist!
     *
     * @param initHidden
     */
    public void setInitHidden(Boolean initHidden)
    {
        this.initHidden = initHidden;
    }

    /**
     * Gets the Layout Div for which these options belong
     *
     * @return
     */
    public final JQLayoutDiv getLayoutDiv()
    {
        return layoutDiv;
    }

    /**
     * Sets the Layout Div for which these options belong
     *
     * @param layoutDiv
     */
    public final void setLayoutDiv(JQLayoutDiv layoutDiv)
    {
        this.layoutDiv = layoutDiv;
    }

    /**
     * Specifies HotKey Entries specific to the layout
     */
    public enum CustomHotkeyModifier
    {

        /**
         * Control Key
         */
        CNTRL,
        /**
         * Shift Key
         */
        SHIFT,
        /**
         * Control and Shift Key
         */
        CNTRL_SHIFT;

        /**
         * Returns the name of the enumerator replacing all underscores with +
         *
         * @return
         */
        @Override
        public String toString()
        {
            return name().replaceAll("_", "+");
        }
    }

    /**
     * If the layout is responsive
     * @return 
     */
    public Boolean getResponsive()
    {
        if(responsive == null)
            return false;
        return responsive;
    }

    /**
     * If the layout is responsive
     * @param responsive 
     */
    public void setResponsive(Boolean responsive)
    {
        this.responsive = responsive;
    }

    /**
     * From when should the layout be responsive
     * @return 
     */
    public BootstrapSize getResponsiveWhen()
    {
        if(responsiveWhen == null)
            return BootstrapSize.Medium;
        return responsiveWhen;
    }

    /**
     * Sets when the layout should be responsive
     * @param responsiveWhen 
     */
    public void setResponsiveWhen(BootstrapSize responsiveWhen)
    {
        this.responsiveWhen = responsiveWhen;
    }
    
    

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
    
}
