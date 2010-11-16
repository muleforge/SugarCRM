
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for new_set_relationship_list_result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="new_set_relationship_list_result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="failed" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "new_set_relationship_list_result", propOrder = {

})
public class NewSetRelationshipListResult {

    protected int created;
    protected int failed;
    protected int deleted;

    /**
     * Gets the value of the created property.
     * 
     */
    public int getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     */
    public void setCreated(int value) {
        this.created = value;
    }

    /**
     * Gets the value of the failed property.
     * 
     */
    public int getFailed() {
        return failed;
    }

    /**
     * Sets the value of the failed property.
     * 
     */
    public void setFailed(int value) {
        this.failed = value;
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
