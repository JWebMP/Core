package za.co.mmagon;

import com.armineasy.injection.GuiceContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import za.co.mmagon.logger.LogFactory;

/**
 *
 * @author mmagon
 */
public class LoggerFactoryTest
{

    private LogFactory instance;

    public LoggerFactoryTest()
    {
        instance = LogFactory.getInstance();
    }

    /**
     * Test of addLogAppender method, of class LogFactory.
     */
    @Test
    public void testAddLogAppender()
    {
        System.out.println("Testing Log Appender Adding and Removing");
        Logger log = instance.getLogger("new lo g");
        log.info("yes");
        log.config("debug");
        log.log(Level.WARNING, "warn");
        log.log(Level.SEVERE, "error");
        log.log(Level.FINE, "trace");
    }

    /**
     * Test of addLogAppender method, of class LogFactory.
     */
    @Test
    public void testInitialize()
    {
        System.out.println("Testing Initialization");
        GuiceContext.inject();
        System.out.println("Testing Initialization");
        GuiceContext.inject();
        GuiceContext.reflect();
    }

}
