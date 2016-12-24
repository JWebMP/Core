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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.components.moment;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;

/**
 *
 * @author GedMarc
 */
public class MomentTest extends BaseTestClass
{

    public MomentTest()
    {
    }

    @Test
    public void testGetFeature()
    {
        Page p = getInstance();
        p.getBody().add(new Moment(new Date()));
        p.getOptions().setDynamicRender(false);
        System.out.println(p.toString(true));

        if (!p.toString(true).contains("var jwApp = angular.module('jwApp',['angularMoment']);"))
        {
            Assert.fail("didn't put moment module into the angular script");
        }
    }

    @Test
    public void testGetOptions()
    {
    }

    @Test
    public void testGetAssignedDate()
    {
    }

    @Test
    public void testSetAssignedDate()
    {
    }

    @Test
    public void testGetVariableName()
    {
    }

    @Test
    public void testSetVariableName()
    {
    }

    @Test
    public void testGetAppliedFilters()
    {
    }

    @Test
    public void testSetAppliedFilters()
    {
    }

    @Test
    public void testPreConfigure()
    {
    }

    @Test
    public void testAddParseFilter()
    {
    }

    @Test
    public void testAddFromUnixFilter()
    {
    }

    @Test
    public void testAddUtc()
    {
    }

    @Test
    public void testAddUtcOffsetFilter()
    {
    }

    @Test
    public void testAddLocalFilter()
    {
    }

    @Test
    public void testAddTimezoneFilter()
    {
    }

    @Test
    public void testAddDateFormatFilter()
    {
    }

    @Test
    public void testAddCalendarFilter()
    {
    }

    @Test
    public void testAddDifferenceFilter()
    {
    }

    @Test
    public void testAddDurationFilter()
    {
    }

    @Test
    public void testAddSubtractionFilter()
    {
    }

    @Test
    public void testAddAdditionFilter()
    {
    }

}
