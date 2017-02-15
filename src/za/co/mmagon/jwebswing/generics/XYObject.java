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
package za.co.mmagon.jwebswing.generics;

import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/**
 * This Class is basic XY Co-Ordinates
 *
 * @author GedMarc
 * @param <X> x Co-Ordinate Class
 * @param <Y> y Co-Ordinate class
 *
 * @since 25 Dec 2015
 */
public class XYObject<X extends Serializable, Y extends Serializable> implements Serializable
{

    private static final long serialVersionUID = 1L;

    private final SimpleDateFormat outputFormat;

    @JsonIgnore
    private X X;
    @JsonIgnore
    private Y Y;

    /**
     * Constructs a blank XY Object
     */
    public XYObject()
    {
        this.outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Constructs with this XY Object
     *
     * @param X
     * @param Y
     */
    public XYObject(X X, Y Y)
    {
        this.outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.X = X;
        this.Y = Y;
    }

    /**
     * Returns X
     *
     * @return
     */
    public X getX()
    {
        return X;
    }

    /**
     * Sets X
     *
     * @param X
     */
    public void setX(X X)
    {
        this.X = X;
    }

    /**
     * Returns Y
     *
     * @return
     */
    public Y getY()
    {
        return Y;
    }

    /**
     * Sets Y
     *
     * @param Y
     */
    public void setY(Y Y)
    {
        this.Y = Y;
    }

    /**
     * An Array Representation [X,Y]
     *
     * @return
     */
    @Override
    @JsonValue
    @JsonRawValue
    public String toString()
    {
        if (!StringUtils.isNumericSpace(getX().toString()))
        {
            if (getX() instanceof Date)
            {
                String formatted = "['" + outputFormat.format(Date.class.cast(getX())) + "'," + getY() + "]";
                return formatted;
            }
            else if (getX() instanceof String)
            {
                return "['" + getX() + "'," + getY() + "]";
            }
        }
        return "[" + getX() + "," + getY() + "]";
    }

}
