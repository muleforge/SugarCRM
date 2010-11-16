
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for return_search_result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="return_search_result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="entry_list" type="{http://www.sugarcrm.com/sugarcrm}link_list"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "return_search_result", propOrder = {

})
public class ReturnSearchResult {

    @XmlElement(name = "entry_list", required = true)
    protected LinkList entryList;

    /**
     * Gets the value of the entryList property.
     * 
     * @return
     *     possible object is
     *     {@link LinkList }
     *     
     */
    public LinkList getEntryList() {
        return entryList;
    }

    /**
     * Sets the value of the entryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkList }
     *     
     */
    public void setEntryList(LinkList value) {
        this.entryList = value;
    }

}
