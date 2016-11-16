package za.co.mmagon.jwebswing.utilities;

import za.co.mmagon.jwebswing.base.html.Area;

/**
 * Assists with managing Polygons
 * @since 2013/11/22
 * @version 1.0
 * @author mmagon
 *
 * 
 */
public class PolygonUtils
{

    public static synchronized int[] getCenterPointOfPolygon(String polygonCoordinates)
    {
        int[] centroid = new int[2];
        int[][] polyArr = Area.getArrayFromStringCoordinates(polygonCoordinates);
        int numberOfCoords = polyArr.length;

        double pi = 22 / (double)7;
        
        
        int x = 0;
        int y = 0;
        int z = 0;
        for (int[] is : polyArr)
        {
            x += is[0];
            y += is[1];
        }
        x = x/numberOfCoords;
        y= y/numberOfCoords;

        centroid[0] = x;
        centroid[1] = y;
        
        return centroid;
    }
}
