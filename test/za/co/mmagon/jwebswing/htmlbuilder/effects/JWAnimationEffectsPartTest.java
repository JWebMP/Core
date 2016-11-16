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
package za.co.mmagon.jwebswing.htmlbuilder.effects;

import za.co.mmagon.jwebswing.generics.Direction;
import org.junit.Test;

/**
 *
 * @author GedMarc
 */
public class JWAnimationEffectsPartTest
{

    public JWAnimationEffectsPartTest()
    {

    }

    @Test
    public void test()
    {
        JWAnimationEffectsPart pt = new JWAnimationEffectsPart();
        pt.setDirection(Direction.Vertical);
        pt.setEasing(EasingEffects.swing);
        System.out.println(pt.toString());
    }
}
