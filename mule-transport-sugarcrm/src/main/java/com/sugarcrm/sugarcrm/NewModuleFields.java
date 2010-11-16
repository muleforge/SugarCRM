
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for new_module_fields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="new_module_fields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="module_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="module_fields" type="{http://www.sugarcrm.com/sugarcrm}field_list"/>
 *         &lt;element name="link_fields" type="{http://www.sugarcrm.com/sugarcrm}link_field_list"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "new_module_fields", propOrder = {

})
public class NewModuleFields {

    @XmlElement(name = "module_name", required = true)
    protected String moduleName;
    @XmlElement(name = "module_fields", required = true)
    protected FieldList moduleFields;
    @XmlElement(name = "link_fields", required = true)
    protected LinkFieldList linkFields;

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
     * Gets the value of the moduleFields property.
     * 
     * @return
     *     possible object is
     *     {@link FieldList }
     *     
     */
    public FieldList getModuleFields() {
        return moduleFields;
    }

    /**
     * Sets the value of the moduleFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldList }
     *     
     */
    public void setModuleFields(FieldList value) {
        this.moduleFields = value;
    }

    /**
     * Gets the value of the linkFields property.
     * 
     * @return
     *     possible object is
     *     {@link LinkFieldList }
     *     
     */
    public LinkFieldList getLinkFields() {
        return linkFields;
    }

    /**
     * Sets the value of the linkFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkFieldList }
     *     
     */
    public void setLinkFields(LinkFieldList value) {
        this.linkFields = value;
    }



}
