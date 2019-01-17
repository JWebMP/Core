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
package com.jwebmp.core.utilities;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class to assist with maps and their values
 *
 * @author GedMarc
 */
public class MapUtils
{
	/**
	 * Never make one xD
	 */
	private MapUtils()
	{
		//Not constructable
	}

	/**
	 * Sorts a map in order by value
	 *
	 * @param map
	 * @param <K>
	 * @param <V>
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map)
	{
		return map.entrySet()
		          .stream()
		          .sorted(Map.Entry.comparingByValue())
		          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	/**
	 * Sorts a map by value in the reverse
	 *
	 * @param map
	 * @param <K>
	 * @param <V>
	 *
	 * @return
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueReverse(Map<K, V> map)
	{
		return map.entrySet()
		          .stream()
		          .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
		          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
}
