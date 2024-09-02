/*
 * Copyright (C) 2017 GedMarc
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

package com.jwebmp.core.base.page;


import com.guicedee.client.IGuiceContext;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.RequirementsPriority;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.RenderAfterScripts;
import com.jwebmp.core.services.RenderBeforeScripts;
import jakarta.validation.constraints.NotNull;

import java.util.*;

public class ScriptsInsertPageConfigurator
        extends RequirementsPriorityAbstractInsertPageConfigurator<ScriptsInsertPageConfigurator>
{
    public ScriptsInsertPageConfigurator()
    {
        //No config required
    }

    @NotNull
    @Override
    public Page<?> configure(IPage<?> pager)
    {
        Page page = (Page) pager;
        if (!page.isConfigured() && enabled())
        {
            IComponentHierarchyBase<?, ?> addable;
            if (page.getOptions()
                    .isScriptsInHead())
            {
                addable = page.getHead();
            }
            else
            {
                addable = page.getBody();
            }

            //noinspection unchecked
            getScripts(page, (IComponentHierarchyBase<GlobalChildren, ?>) addable);
            for (Object o : page.getHead()
                                .getChildren())
            {
                IComponentHierarchyBase<?, ?> headObject = (IComponentHierarchyBase<?, ?>) o;
                //headObject.toString();
            }
        }
        return page;
    }

    private void getScripts(Page<?> page, IComponentHierarchyBase<GlobalChildren, ?> scriptAddTo)
    {
        renderBeforeScripts(scriptAddTo);
        addScriptsTo(page, scriptAddTo);
        renderAfterScripts(scriptAddTo);
    }

    private void renderBeforeScripts(IComponentHierarchyBase<GlobalChildren, ?> scriptAddTo)
    {
        Set<RenderBeforeScripts> renderB = IGuiceContext.loaderToSetNoInjection(ServiceLoader.load(RenderBeforeScripts.class));//.get(RenderBeforeScriptsKey);
        Paragraph<?> before = new Paragraph<>().setTextOnly(true);
        renderB.forEach(render -> before.setText(before.getText(0)
                                                       .toString() + render.render(scriptAddTo.getPage())
                                                                           .toString()));
        if (before.getText(0)
                  .toString()
                  .trim()
                  .length() > 0)
        {
            scriptAddTo.add(before);
        }
    }

    /**
     * Adds scripts to a component, ordered by priority and sort order.
     * <p>
     * Does not do top shelf
     *
     * @param component The component to add scripts to
     */
    private void addScriptsTo(Page<?> page, IComponentHierarchyBase<GlobalChildren, ?> component)
    {
        List<IComponentHierarchyBase<?, ?>> requirements = new ArrayList<>();

        List<RequirementsPriority> arrs = new ArrayList<>(Arrays.asList(RequirementsPriority.values()));
        for (RequirementsPriority priority : arrs)
        {
            if (priority.equals(RequirementsPriority.Top_Shelf))
            {
                continue;
            }
            List<IComponentHierarchyBase<?, ?>> alls = getPriorityRequirements(page, priority, requirements, false, true);
            alls.forEach(component::add);
        }
    }

    private void renderAfterScripts(IComponentHierarchyBase<GlobalChildren, ?> scriptAddTo)
    {
        Set<RenderAfterScripts> renderA = IGuiceContext.loaderToSetNoInjection(ServiceLoader.load(RenderAfterScripts.class));//.get(RenderAfterScriptsKey);
        Paragraph<?> after = new Paragraph<>().setTextOnly(true);
        for (RenderAfterScripts render : renderA)
        {
            after.setText(after.getText(0)
                               .toString() + render.render(scriptAddTo.getPage())
                                                   .toString());
        }
        if (after.getText(0)
                 .toString()
                 .trim()
                 .length() > 0)
        {
            scriptAddTo.add(after);
        }
    }

    @Override
    public Integer sortOrder()
    {
        return Integer.MAX_VALUE - 8;
    }
}
