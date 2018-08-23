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
package com.jwebmp.core.base.html.interfaces;

import com.jwebmp.core.base.ComponentBase;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

/**
 * @author Marc Magon
 * @version 1.0
 * @since 07 Aug 2015
 */
public interface DisplayObjectType<C extends IComponentHierarchyBase, J extends ComponentBase>
		extends DisplayObjects<C, J>
{

}
