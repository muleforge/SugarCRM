
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_relationshipsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_relationshipsRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="module_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="module_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="link_field_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="related_module_query" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="related_fields" type="{http://www.sugarcrm.com/sugarcrm}select_fields"/>
 *         &lt;element name="related_module_link_name_to_fields_array" type="{http://www.sugarcrm.com/sugarcrm}link_names_to_fields_array"/>
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_relationshipsRequestType", propOrder = {

})
public class GetRelationshipsRequestType {

    @XmlElement(required = true)
    protected String session;
    @XmlElement(name = "module_name", required = true)
    protected String moduleName;
    @XmlElement(name = "module_id", required = true)
    protected String moduleId;
    @XmlElement(name = "link_field_name", required = true)
    protected String linkFieldName;
    @XmlElement(name = "related_module_query", required = true)
    protected String relatedModuleQuery;
    @XmlElement(name = "related_fields", required = true)
    protected SelectFields relatedFields;
    @XmlElement(name = "related_module_link_name_to_fields_array", required = true)
    protected LinkNamesToFieldsArray relatedModuleLinkNameToFieldsArray;
    protected int deleted;

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
     * Gets the value of the relatedModuleQuery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedModuleQuery() {
        return relatedModuleQuery;
    }

    /**
     * Sets the value of the relatedModuleQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedModuleQuery(String value) {
        this.relatedModuleQuery = value;
    }

    /**
     * Gets the value of the relatedFields property.
     * 
     * @return
     *     possible object is
     *     {@link SelectFields }
     *     
     */
    public SelectFields getRelatedFields() {
        return relatedFields;
    }

    /**
     * Sets the value of the relatedFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectFields }
     *     
     */
    public void setRelatedFields(SelectFields value) {
        this.relatedFields = value;
    }

    /**
     * Gets the value of the relatedModuleLinkNameToFieldsArray property.
     * 
     * @return
     *     possible object is
     *     {@link LinkNamesToFieldsArray }
     *     
     */
    public LinkNamesToFieldsArray getRelatedModuleLinkNameToFieldsArray() {
        return relatedModuleLinkNameToFieldsArray;
    }

    /**
     * Sets the value of the relatedModuleLinkNameToFieldsArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkNamesToFieldsArray }
     *     
     */
    public void setRelatedModuleLinkNameToFieldsArray(LinkNamesToFieldsArray value) {
        this.relatedModuleLinkNameToFieldsArray = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     */
    public int getDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     */
    public void setDeleted(int value) {
        this.deleted = value;
    }

}
