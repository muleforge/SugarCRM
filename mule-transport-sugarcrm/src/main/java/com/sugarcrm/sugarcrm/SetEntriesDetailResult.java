
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for set_entries_detail_result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="set_entries_detail_result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name_value_lists" type="{http://www.sugarcrm.com/sugarcrm}name_value_lists"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "set_entries_detail_result", propOrder = {

})
public class SetEntriesDetailResult {

    @XmlElement(name = "name_value_lists", required = true)
    protected NameValueLists nameValueLists;

    /**
     * Gets the value of the nameValueLists property.
     * 
     * @return
     *     possible object is
     *     {@link NameValueLists }
     *     
     */
    public NameValueLists getNameValueLists() {
        return nameValueLists;
    }

    /**
     * Sets the value of the nameValueLists property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameValueLists }
     *     
     */
    public void setNameValueLists(NameValueLists value) {
        this.nameValueLists = value;
    }

}
