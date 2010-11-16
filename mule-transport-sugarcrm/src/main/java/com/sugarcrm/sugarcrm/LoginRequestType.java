
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loginRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loginRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="user_auth" type="{http://www.sugarcrm.com/sugarcrm}user_auth"/>
 *         &lt;element name="application_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_value_list" type="{http://www.sugarcrm.com/sugarcrm}name_value_list"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginRequestType", propOrder = {

})
public class LoginRequestType {

    @XmlElement(name = "user_auth", required = true)
    protected UserAuth userAuth;
    @XmlElement(name = "application_name", required = true)
    protected String applicationName;
    @XmlElement(name = "name_value_list", required = true)
    protected NameValueList nameValueList;

    /**
     * Gets the value of the userAuth property.
     * 
     * @return
     *     possible object is
     *     {@link UserAuth }
     *     
     */
    public UserAuth getUserAuth() {
        return userAuth;
    }

    /**
     * Sets the value of the userAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAuth }
     *     
     */
    public void setUserAuth(UserAuth value) {
        this.userAuth = value;
    }

    /**
     * Gets the value of the applicationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Sets the value of the applicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationName(String value) {
        this.applicationName = value;
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

}
