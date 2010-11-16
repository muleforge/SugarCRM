
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_entriesRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_entriesRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="module_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ids" type="{http://www.sugarcrm.com/sugarcrm}select_fields"/>
 *         &lt;element name="select_fields" type="{http://www.sugarcrm.com/sugarcrm}select_fields"/>
 *         &lt;element name="link_name_to_fields_array" type="{http://www.sugarcrm.com/sugarcrm}link_names_to_fields_array"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_entriesRequestType", propOrder = {

})
public class GetEntriesRequestType {

    @XmlElement(required = true)
    protected String session;
    @XmlElement(name = "module_name", required = true)
    protected String moduleName;
    @XmlElement(required = true)
    protected SelectFields ids;
    @XmlElement(name = "select_fields", required = true)
    protected SelectFields selectFields;
    @XmlElement(name = "link_name_to_fields_array", required = true)
    protected LinkNamesToFieldsArray linkNameToFieldsArray;

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
     * Gets the value of the ids property.
     * 
     * @return
     *     possible object is
     *     {@link SelectFields }
     *     
     */
    public SelectFields getIds() {
        return ids;
    }

    /**
     * Sets the value of the ids property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectFields }
     *     
     */
    public void setIds(SelectFields value) {
        this.ids = value;
    }

    /**
     * Gets the value of the selectFields property.
     * 
     * @return
     *     possible object is
     *     {@link SelectFields }
     *     
     */
    public SelectFields getSelectFields() {
        return selectFields;
    }

    /**
     * Sets the value of the selectFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectFields }
     *     
     */
    public void setSelectFields(SelectFields value) {
        this.selectFields = value;
    }

    /**
     * Gets the value of the linkNameToFieldsArray property.
     * 
     * @return
     *     possible object is
     *     {@link LinkNamesToFieldsArray }
     *     
     */
    public LinkNamesToFieldsArray getLinkNameToFieldsArray() {
        return linkNameToFieldsArray;
    }

    /**
     * Sets the value of the linkNameToFieldsArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkNamesToFieldsArray }
     *     
     */
    public void setLinkNameToFieldsArray(LinkNamesToFieldsArray value) {
        this.linkNameToFieldsArray = value;
    }

}
