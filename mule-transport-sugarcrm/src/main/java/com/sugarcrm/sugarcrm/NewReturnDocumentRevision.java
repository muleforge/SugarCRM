
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for new_return_document_revision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="new_return_document_revision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="document_revision" type="{http://www.sugarcrm.com/sugarcrm}document_revision"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "new_return_document_revision", propOrder = {

})
public class NewReturnDocumentRevision {

    @XmlElement(name = "document_revision", required = true)
    protected DocumentRevision documentRevision;

    /**
     * Gets the value of the documentRevision property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentRevision }
     *     
     */
    public DocumentRevision getDocumentRevision() {
        return documentRevision;
    }

    /**
     * Sets the value of the documentRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentRevision }
     *     
     */
    public void setDocumentRevision(DocumentRevision value) {
        this.documentRevision = value;
    }

}
