/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.popovers;

import java.util.ArrayList;
import java.util.List;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * Popovers
 * <p>
 * Add small overlay content, like those found in iOS, to any element for housing secondary information.
 * <p>
 * Overview
 * <p>
 * Things to know when using the popover plugin:
 * <p>
 * Popovers rely on the 3rd party library Tether for positioning. You must include tether.min.js before bootstrap.js in order for popovers to work!
 * <p>
 * Popovers require the tooltip plugin as a dependency.
 * <p>
 * Popovers are opt-in for performance reasons, so you must initialize them yourself.
 * <p>
 * Zero-length title and content values will never show a popover.
 * <p>
 * Specify container: 'body' to avoid rendering problems in more complex components (like our input groups, button groups, etc).
 * <p>
 * Triggering popovers on hidden elements will not work.
 * <p>
 * Popovers for .disabled or disabled elements must be triggered on a wrapper element.
 * <p>
 * When triggered from hyperlinks that span multiple lines, popovers will be centered. Use white-space: nowrap; on your as to avoid this behavior.
 * <p>
 * <p>
 * Got all that? Great, let’s see how they work with some examples.
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class BSPopOverOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * Apply a CSS fade transition to the popover
     */
    private Boolean animation;
    /**
     * Appends the popover to a specific element. Example: container: 'body'. This option is particularly useful in that it allows you to position the popover in the flow of the document near the
     * triggering element - which will prevent the popover from floating away from the triggering element during a window resize. FALSE
     * <p>
     */
    private String container;
    /**
     * Default content value if data-content attribute isn't present.
     */
    private String content;
    /**
     * Delay showing and hiding the popover (ms) - does not apply to manual trigger type
     * <p>
     * If a number is supplied, delay is applied to both hide/show
     * <p>
     * Object structure is: delay: { "show": 500, "hide": 100 }
     */
    private Integer delay;
    /**
     * Insert HTML into the popover.
     * <p>
     * If false, jQuery's text method will be used to insert content into the DOM. Use text if you're worried about XSS attacks.
     */
    private Boolean html;
    /**
     *
     * <p>
     * How to position the popover - top | bottom | left | right.
     * <p>
     * When a function is used to determine the placement, it is called with the popover DOM node as its first argument and the triggering element DOM node as its second. The this context is set to
     * the popover instance.
     */
    private String placement;
    /**
     * If a selector is provided, popover objects will be delegated to the specified targets.
     * <p>
     * In practice, this is used to enable dynamic HTML content to have popovers added. See this and an informative example.
     */
    private String selector;
    /**
     * Base HTML to use when creating the popover.
     * <p>
     * The popover's title will be injected into the .popover-title.
     * <p>
     * The popover's content will be injected into the .popover-content.
     * <p>
     * .popover-arrow will become the popover's arrow.
     * <p>
     * The outermost wrapper element should have the .popover class.
     */
    private String template;
    /**
     * Default title value if title attribute isn't present.
     * <p>
     * If a function is given, it will be called with its this reference set to the element that the popover is attached to.
     */
    private String title;
    /**
     * How popover is triggered - click | hover | focus | manual. You may pass multiple triggers; separate them with a space. `manual` cannot be combined with any other trigger.
     */
    private String trigger;
    /**
     * An array of constraints - passed through to Tether. For more information refer to Tether's constraint docs.
     */
    private List<String> constraints;
    /**
     * Offset of the popover relative to its target. For more information refer to Tether's offset docs.
     */
    private String offset;

    /**
     * Popovers
     * <p>
     * Add small overlay content, like those found in iOS, to any element for housing secondary information.
     * <p>
     * Overview
     * <p>
     * Things to know when using the popover plugin:
     * <p>
     * Popovers rely on the 3rd party library Tether for positioning. You must include tether.min.js before bootstrap.js in order for popovers to work!
     * <p>
     * Popovers require the tooltip plugin as a dependency.
     * <p>
     * Popovers are opt-in for performance reasons, so you must initialize them yourself.
     * <p>
     * Zero-length title and content values will never show a popover.
     * <p>
     * Specify container: 'body' to avoid rendering problems in more complex components (like our input groups, button groups, etc).
     * <p>
     * Triggering popovers on hidden elements will not work.
     * <p>
     * Popovers for .disabled or disabled elements must be triggered on a wrapper element.
     * <p>
     * When triggered from hyperlinks that span multiple lines, popovers will be centered. Use white-space: nowrap; on your as to avoid this behavior.
     * <p>
     * <p>
     * Got all that? Great, let’s see how they work with some examples.
     */
    public BSPopOverOptions()
    {

    }

    /**
     * Apply a CSS fade transition to the popover
     *
     * @return
     */
    public Boolean getAnimation()
    {
        return animation;
    }

    /**
     * Apply a CSS fade transition to the popover
     *
     * @param animation
     */
    public void setAnimation(Boolean animation)
    {
        this.animation = animation;
    }

    /**
     * Default content value if data-content attribute isn't present.
     *
     * @return
     */
    public String getContent()
    {
        return content;
    }

    /**
     * Default content value if data-content attribute isn't present.
     *
     * @param content
     */
    public void setContent(String content)
    {
        this.content = content;
    }

    /**
     * Appends the popover to a specific element. Example: container: 'body'. This option is particularly useful in that it allows you to position the popover in the flow of the document near the
     * triggering element - which will prevent the popover from floating away from the triggering element during a window resize.	FALSE
     *
     * @return
     */
    public String getContainer()
    {
        return container;
    }

    /**
     * Appends the popover to a specific element. Example: container: 'body'. This option is particularly useful in that it allows you to position the popover in the flow of the document near the
     * triggering element - which will prevent the popover from floating away from the triggering element during a window resize.	FALSE
     *
     * @param container
     */
    public void setContainer(String container)
    {
        this.container = container;
    }

    /**
     * An array of constraints - passed through to Tether. For more information refer to Tether's constraint docs.
     *
     * @return
     */
    public List<String> getConstraints()
    {
        if (constraints == null)
        {
            constraints = new ArrayList<>();
        }
        return constraints;
    }

    /**
     * An array of constraints - passed through to Tether. For more information refer to Tether's constraint docs.
     *
     * @param constraints
     */
    public void setConstraints(List<String> constraints)
    {
        this.constraints = constraints;
    }

    /**
     * Delay showing and hiding the popover (ms) - does not apply to manual trigger type
     * <p>
     * If a number is supplied, delay is applied to both hide/show
     * <p>
     * Object structure is: delay: { "show": 500, "hide": 100 }
     *
     * @return
     */
    public Integer getDelay()
    {
        return delay;
    }

    /**
     * Delay showing and hiding the popover (ms) - does not apply to manual trigger type
     * <p>
     * If a number is supplied, delay is applied to both hide/show
     * <p>
     * Object structure is: delay: { "show": 500, "hide": 100 }
     *
     * @param delay
     */
    public void setDelay(Integer delay)
    {
        this.delay = delay;
    }

    /**
     * Insert HTML into the popover.
     * <p>
     * If false, jQuery's text method will be used to insert content into the DOM. Use text if you're worried about XSS attacks.
     *
     * @return
     */
    public Boolean getHtml()
    {
        return html;
    }

    /**
     * Insert HTML into the popover.
     * <p>
     * If false, jQuery's text method will be used to insert content into the DOM. Use text if you're worried about XSS attacks.
     *
     * @param html
     */
    public void setHtml(Boolean html)
    {
        this.html = html;
    }

    /**
     *
     * <p>
     * How to position the popover - top | bottom | left | right.
     * <p>
     * When a function is used to determine the placement, it is called with the popover DOM node as its first argument and the triggering element DOM node as its second. The this context is set to
     * the popover instance.
     *
     * @return
     */
    public String getPlacement()
    {
        return placement;
    }

    /**
     *
     * <p>
     * How to position the popover - top | bottom | left | right.
     * <p>
     * When a function is used to determine the placement, it is called with the popover DOM node as its first argument and the triggering element DOM node as its second. The this context is set to
     * the popover instance.
     *
     * @param placement
     */
    public void setPlacement(String placement)
    {
        this.placement = placement;
    }

    /**
     * If a selector is provided, popover objects will be delegated to the specified targets. In practice, this is used to enable dynamic HTML content to have popovers added. See this and an
     * informative example.
     *
     * @return
     */
    public String getSelector()
    {
        return selector;
    }

    /**
     * If a selector is provided, popover objects will be delegated to the specified targets. In practice, this is used to enable dynamic HTML content to have popovers added. See this and an
     * informative example.
     *
     * @param selector
     */
    public void setSelector(String selector)
    {
        this.selector = selector;
    }

    /**
     * Base HTML to use when creating the popover.
     * <p>
     * The popover's title will be injected into the .popover-title.
     * <p>
     * The popover's content will be injected into the .popover-content.
     * <p>
     * .popover-arrow will become the popover's arrow.
     * <p>
     * The outermost wrapper element should have the .popover class.
     *
     * @return
     */
    public String getTemplate()
    {
        return template;
    }

    /**
     * Base HTML to use when creating the popover.
     * <p>
     * The popover's title will be injected into the .popover-title.
     * <p>
     * The popover's content will be injected into the .popover-content.
     * <p>
     * .popover-arrow will become the popover's arrow.
     * <p>
     * The outermost wrapper element should have the .popover class.
     *
     * @param template
     */
    public void setTemplate(String template)
    {
        this.template = template;
    }

    /**
     * Default title value if title attribute isn't present.
     * <p>
     * If a function is given, it will be called with its this reference set to the element that the popover is attached to.
     *
     * @return
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Default title value if title attribute isn't present.
     * <p>
     * If a function is given, it will be called with its this reference set to the element that the popover is attached to.
     *
     * @param title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * How popover is triggered - click | hover | focus | manual. You may pass multiple triggers; separate them with a space. `manual` cannot be combined with any other trigger.
     *
     * @return
     */
    public String getTrigger()
    {
        return trigger;
    }

    /**
     * How popover is triggered - click | hover | focus | manual. You may pass multiple triggers; separate them with a space. `manual` cannot be combined with any other trigger.
     *
     * @param trigger
     */
    public void setTrigger(String trigger)
    {
        this.trigger = trigger;
    }

    /**
     * Offset of the popover relative to its target. For more information refer to Tether's offset docs.
     *
     * @return
     */
    public String getOffset()
    {
        return offset;
    }

    /**
     * Offset of the popover relative to its target. For more information refer to Tether's offset docs.
     *
     * @param offset
     */
    public void setOffset(String offset)
    {
        this.offset = offset;
    }

    /**
     * Render as javascript
     *
     * @return
     */
    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

}
