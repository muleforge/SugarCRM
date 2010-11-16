
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for set_relationshipsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="set_relationshipsRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="module_names" type="{http://www.sugarcrm.com/sugarcrm}select_fields"/>
 *         &lt;element name="module_ids" type="{http://www.sugarcrm.com/sugarcrm}select_fields"/>
 *         &lt;element name="link_field_names" type="{http://www.sugarcrm.com/sugarcrm}select_fields"/>
 *         &lt;element name="related_ids" type="{http://www.sugarcrm.com/sugarcrm}new_set_relationhip_ids"/>
 *         &lt;element name="name_value_lists" type="{http://www.sugarcrm.com/sugarcrm}name_value_lists"/>
 *         &lt;element name="delete_array" type="{http://www.sugarcrm.com/sugarcrm}deleted_array"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "set_relationshipsRequestType", propOrder = {

})
public class SetRelationshipsRequestType {

    @XmlElement(required = true)
    protected String session;
    @XmlElement(name = "module_names", required = true)
    protected SelectFields moduleNames;
    @XmlElement(name = "module_ids", required = true)
    protected SelectFields moduleIds;
    @XmlElement(name = "link_field_names", required = true)
    protected SelectFields linkFieldNames;
    @XmlElement(name = "related_ids", required = true)
    protected NewSetRelationhipIds relatedIds;
    @XmlElement(name = "name_value_lists", required = true)
    protected NameValueLists nameValueLists;
    @XmlElement(name = "delete_array", required = true)
    protected DeletedArray deleteArray;

    /**
     * Gets the value of the session property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSession() {
        return session;
    }

    /**
     * Sets the value of the session property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSession(String value) {
        this.session = value;
    }

    /**
     * Gets the value of the moduleNames property.
     * 
     * @return
     *     possible object is
     *     {@link SelectFields }
     *     
     */
    public SelectFields getModuleNames() {
        return moduleNames;
    }

    /**
     * Sets the value of the moduleNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectFields }
     *     
     */
    public void setModuleNames(SelectFields value) {
        this.moduleNames = value;
    }

    /**
     * Gets the value of the moduleIds property.
     * 
     * @return
     *     possible object is
     *     {@link SelectFields }
     *     
     */
    public SelectFields getModuleIds() {
        return moduleIds;
    }

    /**
     * Sets the value of the moduleIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectFields }
     *     
     */
    public void setModuleIds(SelectFields value) {
        this.moduleIds = value;
    }

    /**
     * Gets the value of the linkFieldNames property.
     * 
     * @return
     *     possible object is
     *     {@link SelectFields }
     *     
     */
    public SelectFields getLinkFieldNames() {
        return linkFieldNames;
    }

    /**
     * Sets the value of the linkFieldNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectFields }
     *     
     */
    public void setLinkFieldNames(SelectFields value) {
        this.linkFieldNames = value;
    }

    /**
     * Gets the value of the relatedIds property.
     * 
     * @return
     *     possible object is
     *     {@link NewSetRelationhipIds }
     *     
     */
    public NewSetRelationhipIds getRelatedIds() {
        return relatedIds;
    }

    /**
     * Sets the value of the relatedIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link NewSetRelationhipIds }
     *     
     */
    public void setRelatedIds(NewSetRelationhipIds value) {
        this.relatedIds = value;
    }

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

    /**
     * Gets the value of the deleteArray property.
     * 
     * @return
     *     possible object is
     *     {@link DeletedArray }
     *     
     */
    public DeletedArray getDeleteArray() {
        return deleteArray;
    }

    /**
     * Sets the value of the deleteArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeletedArray }
     *     
     */
    public void setDeleteArray(DeletedArray value) {
        this.deleteArray = value;
    }

}
