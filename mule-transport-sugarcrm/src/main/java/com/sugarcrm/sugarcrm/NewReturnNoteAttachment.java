
package com.sugarcrm.sugarcrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for new_return_note_attachment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="new_return_note_attachment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="note_attachment" type="{http://www.sugarcrm.com/sugarcrm}new_note_attachment"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "new_return_note_attachment", propOrder = {

})
public class NewReturnNoteAttachment {

    @XmlElement(name = "note_attachment", required = true)
    protected NewNoteAttachment noteAttachment;

    /**
     * Gets the value of the noteAttachment property.
     * 
     * @return
     *     possible object is
     *     {@link NewNoteAttachment }
     *     
     */
    public NewNoteAttachment getNoteAttachment() {
        return noteAttachment;
    }

    /**
     * Sets the value of the noteAttachment property.
     * 
     * @param value
     *     allowed object is
     *     {@link NewNoteAttachment }
     *     
     */
    public void setNoteAttachment(NewNoteAttachment value) {
        this.noteAttachment = value;
    }

}
