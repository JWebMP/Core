package za.co.mmagon.logger;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder =
{
    "logEntry"
})
@XmlRootElement(name = "Log")
public class Log
{

    @XmlElement(name = "LogEntry")
    protected List<LogEntry> logEntry;

    /**
     * Gets the value of the logEntry property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logEntry property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogEntry().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogEntry }
     * <p>
     * <p>
     */
    public List<LogEntry> getLogEntry()
    {
        if (logEntry == null)
        {
            logEntry = new ArrayList<LogEntry>();
        }
        return this.logEntry;
    }

}
