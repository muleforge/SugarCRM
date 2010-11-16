
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_entry_result_version2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_entry_result_version2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="entry_list" type="{http://www.sugarcrm.com/sugarcrm}entry_list"/>
 *         &lt;element name="relationship_list" type="{http://www.sugarcrm.com/sugarcrm}link_lists"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_entry_result_version2", propOrder = {

})
public class GetEntryResultVersion2 {

    @XmlElement(name = "entry_list", required = true)
    protected EntryList entryList;
    @XmlElement(name = "relationship_list", required = true)
    protected LinkLists relationshipList;

    /**
     * Gets the value of the entryList property.
     * 
     * @return
     *     possible object is
     *     {@link EntryList }
     *     
     */
    public EntryList getEntryList() {
        return entryList;
    }

    /**
     * Sets the value of the entryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntryList }
     *     
     */
    public void setEntryList(EntryList value) {
        this.entryList = value;
    }

    /**
     * Gets the value of the relationshipList property.
     * 
     * @return
     *     possible object is
     *     {@link LinkLists }
     *     
     */
    public LinkLists getRelationshipList() {
        return relationshipList;
    }

    /**
     * Sets the value of the relationshipList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkLists }
     *     
     */
    public void setRelationshipList(LinkLists value) {
        this.relationshipList = value;
    }

}
