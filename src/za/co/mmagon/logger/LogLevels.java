package za.co.mmagon.logger;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "LogLevels")
@XmlEnum
public enum LogLevels
{

    INFO,
    DEBUG,
    WARN,
    ERROR,
    FATAL,
    TRACE;

    public String value()
    {
        return name();
    }

    public static LogLevels fromValue(String v)
    {
        return valueOf(v);
    }

}
