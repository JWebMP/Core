package za.co.mmagon;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author mmagon
 */
public class LoggerFactoryTest
{

    private LoggerFactory instance;
    private appender1 appenderSkel;
    private AppenderSkeleton appenderSkel2;

    class appender1 extends AppenderSkeleton
    {

        @Override
        protected void append(LoggingEvent le)
        {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void close()
        {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean requiresLayout()
        {
            return false;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public LoggerFactoryTest()
    {
        instance = LoggerFactory.getInstance();

        appenderSkel = new appender1();

        appenderSkel2 = new AppenderSkeleton()
        {
            @Override
            protected void append(LoggingEvent le)
            {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void close()
            {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean requiresLayout()
            {
                return false;
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    /**
     * Test of addLogAppender method, of class LoggerFactory.
     */
    @Test
    public void testAddLogAppender()
    {
        System.out.println("Testing Log Appender Adding and Removing");
        boolean added = instance.addLogAppender(appenderSkel);
        Logger log = instance.makeNewLoggerInstance("new log");
        if (!added)
        {
            fail("Log did not add the appender.");
        }
    }

}
