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
     * Pads a string to the given length with blanks
     *
     * @param original
     * @param length
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
