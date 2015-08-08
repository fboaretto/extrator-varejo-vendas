
package com.projetandoo.extrator.clienteWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for salvarVendas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * <complexType name="salvarVendas">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="pedido" type="{http://schema.varejodigital.projetandoo/1.0/}VendaType" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "salvarVend", 
		 namespace = "http://service.varejodigital.projetandoo/1.0/", 
		 propOrder = { "pedido" })
public class SalvarVendas {

    protected VendaType pedido;

    /**
     * Gets the value of the pedido property.
     * 
     * @return
     *     possible object is
     *     {@link VendaType }
     *     
     */
    public VendaType getPedido() {
        return pedido;
    }

    /**
     * Sets the value of the pedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link VendaType }
     *     
     */
    public void setPedido(VendaType value) {
        this.pedido = value;
    }

}
