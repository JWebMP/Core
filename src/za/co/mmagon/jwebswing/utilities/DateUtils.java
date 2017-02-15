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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GedMarc
 * @since 06 Feb 2017
 *
 */
public class DateUtils
{

    public static Date EndOfTime;

    static
    {
        try
        {
            EndOfTime = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse("2999/12/31 11:59:59");
        }
        catch (ParseException ex)
        {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
