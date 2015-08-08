
package com.projetandoo.extrator.clienteWS;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemPedidoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * <complexType name="ItemPedidoType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="quantidade" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         <element name="preco" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         <element name="produto" type="{http://schema.varejodigital.projetandoo/1.0/}ProdutoType" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * </pre>
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemPedidoType", propOrder = {
		"quantidade",
		"preco",
		"produto"
})
public class ItemPedidoType {

	@XmlElement(required = true)
	protected BigDecimal quantidade;

	@XmlElement(required = true)
	protected BigDecimal preco;

	protected ProdutoType produto;

	/**
	 * Gets the value of the quantidade property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *     
	 */
	public BigDecimal getQuantidade() {
		return quantidade;
	}

	/**
	 * Sets the value of the quantidade property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *     
	 */
	public void setQuantidade(BigDecimal value) {
		this.quantidade = value;
	}

	/**
	 * Gets the value of the preco property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *     
	 */
	public BigDecimal getPreco() {
		return preco;
	}

	/**
	 * Sets the value of the preco property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *     
	 */
	public void setPreco(BigDecimal value) {
		this.preco = value;
	}

	/**
	 * Gets the value of the produto property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link ProdutoType }
	 *     
	 */
	public ProdutoType getProduto() {
		return produto;
	}

	/**
	 * Sets the value of the produto property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link ProdutoType }
	 *     
	 */
	public void setProduto(ProdutoType value) {
		this.produto = value;
	}

	@Override
	public String toString() {
		return "ItemPedidoType [quantidade=" + quantidade + 
				", preco=" + preco + 
				", produto=" + produto.getCodigoInterno() + "]";
	}

}
