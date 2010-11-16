
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for set_relationshipRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="set_relationshipRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="module_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="module_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="link_field_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="related_ids" type="{http://www.sugarcrm.com/sugarcrm}select_fields"/>
 *         &lt;element name="name_value_list" type="{http://www.sugarcrm.com/sugarcrm}name_value_list"/>
 *         &lt;element name="delete" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "set_relationshipRequestType", propOrder = {

})
public class SetRelationshipRequestType {

    @XmlElement(required = true)
    protected String session;
    @XmlElement(name = "module_name", required = true)
    protected String moduleName;
    @XmlElement(name = "module_id", required = true)
    protected String moduleId;
    @XmlElement(name = "link_field_name", required = true)
    protected String linkFieldName;
    @XmlElement(name = "related_ids", required = true)
    protected SelectFields relatedIds;
    @XmlElement(name = "name_value_list", required = true)
    protected NameValueList nameValueList;
    protected int delete;

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
     * Gets the value of the moduleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Sets the value of the moduleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleName(String value) {
        this.moduleName = value;
    }

    /**
     * Gets the value of the moduleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * Sets the value of the moduleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleId(String value) {
        this.moduleId = value;
    }

    /**
     * Gets the value of the linkFieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkFieldName() {
        return linkFieldName;
    }

    /**
     * Sets the value of the linkFieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkFieldName(String value) {
        this.linkFieldName = value;
    }

    /**
     * Gets the value of the relatedIds property.
     * 
     * @return
     *     possible object is
     *     {@link SelectFields }
     *     
     */
    public SelectFields getRelatedIds() {
        return relatedIds;
    }

    /**
     * Sets the value of the relatedIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectFields }
     *     
     */
    public void setRelatedIds(SelectFields value) {
        this.relatedIds = value;
    }

    /**
     * Gets the value of the nameValueList property.
     * 
     * @return
     *     possible object is
     *     {@link NameValueList }
     *     
     */
    public NameValueList getNameValueList() {
        return nameValueList;
    }

    /**
     * Sets the value of the nameValueList property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameValueList }
     *     
     */
    public void setNameValueList(NameValueList value) {
        this.nameValueList = value;
    }

    /**
     * Gets the value of the delete property.
     * 
     */
    public int getDelete() {
        return delete;
    }

    /**
     * Sets the value of the delete property.
     * 
     */
    public void setDelete(int value) {
        this.delete = value;
    }

}
