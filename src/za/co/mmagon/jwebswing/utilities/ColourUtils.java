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

/**
 * Provides basics for Colours
 *
 * @author MMagon
 * @since 22 Jun 2013
 * @version 1.0
 */
public class ColourUtils
{

    private static String hexToRGB(String color)
    {
        //System.out.println("HEX TO RGB [" + color + "]");
        String val1 = color.substring(0, 2);
        String val2 = color.substring(2, 4);
        String val3 = color.substring(4, 6);
        return hexToDecimal(val1) + "," + hexToDecimal(val2) + "," + hexToDecimal(val3);
    }

    private static String rgbToHex(String color)
    {
        //System.out.println("RGB TO HEX [" + color + "]");
        String[] RGB = color.split(",");
        return toHex(RGB[0]) + toHex(RGB[1]) + toHex(RGB[2]);
    }

    private static int hexToDecimal(String hex)
    {
        return Math.max(0, Math.min(Integer.parseInt(hex, 16), 255));
    }

    /**
     * Returns a heat map colour between the min and maximum set
     *
     * @param province
     * @return
     */
    /**
     * @param minNumber
     * @param maxNumber
     * @param value
     * @param colourMin
     * @param colourMax
     * @return
     */
    public static String getColourBetweenColours(double minNumber, double maxNumber, double value, String colourMin, String colourMax)
    {
        Integer[] colMax = new Integer[3];
        Integer[] colMin = new Integer[3];

        String maxRGB = hexToRGB(colourMax);
        String minRGB = hexToRGB(colourMin);

        colMax[0] = Integer.parseInt(maxRGB.split(",")[0]);
        colMax[1] = Integer.parseInt(maxRGB.split(",")[1]);
        colMax[2] = Integer.parseInt(maxRGB.split(",")[2]);

        colMin[0] = Integer.parseInt(minRGB.split(",")[0]);
        colMin[1] = Integer.parseInt(minRGB.split(",")[1]);
        colMin[2] = Integer.parseInt(minRGB.split(",")[2]);

        // ratio difference here numerically
        int[] diff = new int[3];
        diff[0] = colMin[0] - colMax[0];
        diff[1] = colMin[1] - colMax[1];
        diff[2] = colMin[2] - colMax[2];

        double dividend = value - minNumber;
        double divisor = maxNumber - minNumber;

        double perc = dividend / divisor;
        //System.out.println("perc " + perc);
        Integer[] c = new Integer[3];

        c[0] = colMin[0] - (int) (perc * diff[0]);
        c[1] = colMin[1] - (int) (perc * diff[1]);
        c[2] = colMin[2] - (int) (perc * diff[2]);

        String co = c[0] + "," + c[1] + "," + c[2];
        //System.out.println("CO - " + co);
        String newColour = rgbToHex(co);
        return newColour;
    }

    /**
     * Converts a colour to hex i suppose
     */
    private static final String chars = "0123456789ABCDEF";

    private static String toHex(String color)
    {
    	//System.out.println("TO HEX [" + color + "]");
        //return Integer.toHexString(Integer.parseInt(color));

        //cant do as it truncates the 09 to 9
//    	System.out.println(Integer.toHexString(Integer.parseInt(color)));
        if (color == null)
        {
            return "00";
        }
        Integer N;
        N = Integer.parseInt(color);
        if (N == 0)
        {
            return "00";
        }
        N = Math.max(0, N);
        N = Math.min(N, 255);
        N = Math.round(N);
        char s = chars.charAt((N - N % 16) / 16);
        char s1 = chars.charAt(N % 16);
        return "" + s + s1;// "0123456789ABCDEF".charAt((N-N%16)/16)+ "0123456789ABCDEF".charAt(N%16);
    }

    /**
     * @param args
     */
    public static void main(String... args)
    {
        System.out.println(107560.0 / 1000);
        System.out.println(Math.ceil(107560.0 / 1000));
        System.out.println(Math.ceil(1.3));
        System.out.println("hi");
        Double dob = Double.parseDouble("2098.0583935946");
        System.out.println(dob);

        int minNumber = 2635518;
        int maxNumber = 49869420;

        System.out.println(getColourBetweenColours(minNumber, maxNumber, 26671095, "ffffff", "900020"));
        System.out.println(getColourBetweenColours(minNumber, maxNumber, 49869420, "ffffff", "900020"));
        System.out.println(getColourBetweenColours(minNumber, maxNumber, 5538699, "ffffff", "900020"));
//    	System.out.println(getColour(minNumber, maxNumber, value));

    }
}
