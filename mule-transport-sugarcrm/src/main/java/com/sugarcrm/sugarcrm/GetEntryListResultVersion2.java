
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_entry_list_result_version2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_entry_list_result_version2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="result_count" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="next_offset" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "get_entry_list_result_version2", propOrder = {

})
public class GetEntryListResultVersion2 {

    @XmlElement(name = "result_count")
    protected int resultCount;
    @XmlElement(name = "next_offset")
    protected int nextOffset;
    @XmlElement(name = "entry_list", required = true)
    protected EntryList entryList;
    @XmlElement(name = "relationship_list", required = true)
    protected LinkLists relationshipList;

    /**
     * Gets the value of the resultCount property.
     * 
     */
    public int getResultCount() {
        return resultCount;
    }

    /**
     * Sets the value of the resultCount property.
     * 
     */
    public void setResultCount(int value) {
        this.resultCount = value;
    }

    /**
     * Gets the value of the nextOffset property.
     * 
     */
    public int getNextOffset() {
        return nextOffset;
    }

    /**
     * Sets the value of the nextOffset property.
     * 
     */
    public void setNextOffset(int value) {
        this.nextOffset = value;
    }

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
