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
    "property"
})
@XmlRootElement(name = "Properties")
public class Properties
{

    @XmlElement(name = "Property", required = true)
    protected List<Property> property;

    /**
     * Gets the value of the property property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     * <p>
     * <p>
     */
    public List<Property> getProperty()
    {
        if (property == null)
        {
            property = new ArrayList<Property>();
        }
        return this.property;
    }

}
