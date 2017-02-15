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
package za.co.mmagon.jwebswing.utilities;

import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Woops lost the site
 */
public class GUIDGenerator
{

    /**
     * Retrieve a new unique GUID
     *
     * @return
     */
    public static final synchronized String generateGuid()
    {
        return "jw" + UUID.randomUUID().toString().substring(0, 6);
    }

    /**
     * Retrieve a new unique GUID
     *
     * @return
     */
    public static final synchronized String generateGuidFull()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * Pads a string to the given length with blanks
     *
     * @param original
     * @param length
     *
     * @return
     */
    public static final synchronized String ensureLength(String original, int length)
    {
        String output = original;
        int diff = output.length() - length;
        if (diff > 0)
        {
            // String is too long; trim it down to the proper side
            output = output.substring(0, length);
        }
        else if (diff < 0)
        {
            // String is too short; pad it with trailing zeroes
            for (int i = 0; i < diff; i++)
            {
                output += "0";
            }
        }
        return output;
    }

    /**
     * Returns a specific GUID section
     *
     * @param characters
     *
     * @return
     */
    public static final synchronized String createGuidSection(int characters)
    {
        String ret = "";
        Random random = new Random();
        for (int i = 0; i < characters; i++)
        {
            ret += Integer.toHexString(random.nextInt(15));
        }
        return ret;
    }
}
