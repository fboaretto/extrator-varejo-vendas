
package com.projetandoo.extrator.clienteWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProdutoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * <complexType name="ProdutoType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="codigoBarra" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="codigoInterno" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProdutoType", propOrder = {
		"codigoBarra",
		"codigoInterno"
})
public class ProdutoType {

	@XmlElement(required = true)
	protected String codigoBarra;

	protected long codigoInterno;

	/**
	 * Gets the value of the codigoBarra property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getCodigoBarra() {
		return codigoBarra;
	}

	/**
	 * Sets the value of the codigoBarra property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setCodigoBarra(String value) {
		this.codigoBarra = value;
	}

	/**
	 * Gets the value of the codigoInterno property.
	 * 
	 */
	public long getCodigoInterno() {
		return codigoInterno;
	}

	/**
	 * Sets the value of the codigoInterno property.
	 * 
	 */
	public void setCodigoInterno(long value) {
		this.codigoInterno = value;
	}

}
