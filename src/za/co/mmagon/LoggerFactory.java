package za.co.mmagon;

import java.io.File;
import java.util.ArrayList;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * The default logger factory for most apps
 * @author MMagon
 * @since 22 Jun 2013
 * @version 1.0
 */
public class LoggerFactory implements org.apache.log4j.spi.LoggerFactory
{

    private static final String LOGFILELOCATION = LoggerFactory.class.getResource("log4j.properties").getFile();
    private static final LoggerFactory INSTANCE;
    private static final Logger LOG;

    private static Level loggerLevel = Level.TRACE;

    static
    {
        INSTANCE = new LoggerFactory();
        File f = new File(LOGFILELOCATION);
        if (f.exists())
        {
            PropertyConfigurator.configure(LOGFILELOCATION);
            LOG = INSTANCE.makeNewLoggerInstance("Log Factory");
            LOG.debug("Loading Logging Configuration from file : " + LOGFILELOCATION);
        }
        else
        {
            BasicConfigurator.configure();
            LOG = INSTANCE.makeNewLoggerInstance("Log Factory");
            LOG.debug("No Log4J configuration found, doing Basic Configurator");
        }
        LOG.info("[Logger Factory]-[Created]");
    }
    private final ArrayList<AppenderSkeleton> appenders = new ArrayList<>();

    /**
     * Constructs a new instance of logger factory
     */
    private LoggerFactory()
    {
    }

    /**
     * Returns the set log level
     *
     * @return
     */
    public static Level getLoggerLevel()
    {
        return loggerLevel;
    }

    /**
     * Sets the log level
     *
     * @param loggerLevel
     */
    public static void setLoggerLevel(Level loggerLevel)
    {
        LoggerFactory.loggerLevel = loggerLevel;
        Logger.getRootLogger().setLevel(loggerLevel);
    }

    /**
     * Adds a new global log appender
     *
     * @param appender
     * @return
     */
    public boolean addLogAppender(AppenderSkeleton appender)
    {
        if (appender != null)
        {
            if (!appenders.contains(appender))
            {
                appenders.add(appender);
                if (appender.getName() == null)
                {
                    appender.setName(appender.getClass().getSimpleName());
                }
                Logger.getRootLogger().addAppender(appender);
                LOG.debug("[New Log Appender]-[" + appender.getName() + "]");
            }
            return Logger.getRootLogger().getAppender(appender.getName()) != null;
        }
        return false;

    }

    /**
     * Build a new logger instance into Log4J
     * <p>
     * @param string The name of the logger instance
     * @return
     */
    @Override
    public org.apache.log4j.Logger makeNewLoggerInstance(String string)
    {
        Logger newLog = Logger.getLogger("" + string + "");
        newLog.setLevel(getLoggerLevel());
        return newLog;
    }

    /**
     * Return my instance
     *
     * @return
     */
    public static LoggerFactory getInstance()
    {
        return INSTANCE;
    }

}
