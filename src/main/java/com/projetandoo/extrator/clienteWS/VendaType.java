
package com.projetandoo.extrator.clienteWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VendaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * <complexType name="VendaType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="item" type="{http://schema.varejodigital.projetandoo/1.0/}ItemPedidoType" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *         <element name="loja" type="{http://schema.varejodigital.projetandoo/1.0/}LojaType"/>
 *         <element name="dataCompra" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * </pre>
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VendaType", propOrder = {
		"item",
		"loja",
		"dataCompra"
})
public class VendaType {

	@XmlElement(namespace = "http://schema.varejodigital.projetandoo/1.0/")
	protected List<ItemPedidoType> item;

	@XmlElement(required = true)
	protected LojaType loja;

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar dataCompra;

	/**
	 * Gets the value of the item property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the item property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getItem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ItemPedidoType }
	 * 
	 */
	public List<ItemPedidoType> getItem() {
		if (item == null) {
			item = new ArrayList<ItemPedidoType>();
		}
		return this.item;
	}

	/**
	 * Gets the value of the loja property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link LojaType }
	 *     
	 */
	public LojaType getLoja() {
		return loja;
	}

	/**
	 * Sets the value of the loja property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link LojaType }
	 *     
	 */
	public void setLoja(LojaType value) {
		this.loja = value;
	}

	/**
	 * Gets the value of the dataCompra property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public XMLGregorianCalendar getDataCompra() {
		return dataCompra;
	}

	/**
	 * Sets the value of the dataCompra property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public void setDataCompra(XMLGregorianCalendar value) {
		this.dataCompra = value;
	}

}
