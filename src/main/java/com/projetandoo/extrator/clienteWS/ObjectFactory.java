
package com.projetandoo.extrator.clienteWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the src package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PedidoRequestType_QNAME = new QName("http://service.varejodigital.projetandoo/1.0/", "pedidoRequestType");
    private final static QName _SalvarVendasResponse_QNAME = new QName("http://service.varejodigital.projetandoo/1.0/", "salvarVendasResponse");
    private final static QName _SalvarVendas_QNAME = new QName("http://service.varejodigital.projetandoo/1.0/", "salvarVendas");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: src
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VendasResponseType }
     * 
     */
    public VendasResponseType createVendasResponseType() {
        return new VendasResponseType();
    }

    /**
     * Create an instance of {@link ItemPedidoType }
     * 
     */
    public ItemPedidoType createItemPedidoType() {
        return new ItemPedidoType();
    }

    /**
     * Create an instance of {@link LojaType }
     * 
     */
    public LojaType createLojaType() {
        return new LojaType();
    }

    /**
     * Create an instance of {@link ProdutoType }
     * 
     */
    public ProdutoType createProdutoType() {
        return new ProdutoType();
    }

    /**
     * Create an instance of {@link VendaType }
     * 
     */
    public VendaType createVendaType() {
        return new VendaType();
    }

    /**
     * Create an instance of {@link SalvarVendas }
     * 
     */
    public SalvarVendas createSalvarVendas() {
        return new SalvarVendas();
    }

    /**
     * Create an instance of {@link SalvarVendasResponse }
     * 
     */
    public SalvarVendasResponse createSalvarVendasResponse() {
        return new SalvarVendasResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VendaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.varejodigital.projetandoo/1.0/", name = "pedidoRequestType")
    public JAXBElement<VendaType> createPedidoRequestType(VendaType value) {
        return new JAXBElement<VendaType>(_PedidoRequestType_QNAME, VendaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalvarVendasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.varejodigital.projetandoo/1.0/", name = "salvarVendasResponse")
    public JAXBElement<SalvarVendasResponse> createSalvarVendasResponse(SalvarVendasResponse value) {
        return new JAXBElement<SalvarVendasResponse>(_SalvarVendasResponse_QNAME, SalvarVendasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalvarVendas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.varejodigital.projetandoo/1.0/", name = "salvarVendas")
    public JAXBElement<SalvarVendas> createSalvarVendas(SalvarVendas value) {
        return new JAXBElement<SalvarVendas>(_SalvarVendas_QNAME, SalvarVendas.class, null, value);
    }

}
