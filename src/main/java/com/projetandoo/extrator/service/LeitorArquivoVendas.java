package com.projetandoo.extrator.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.projetandoo.extrator.clienteWS.ItemPedidoType;
import com.projetandoo.extrator.clienteWS.LojaType;
import com.projetandoo.extrator.clienteWS.ObjectFactory;
import com.projetandoo.extrator.clienteWS.ProdutoType;
import com.projetandoo.extrator.clienteWS.VendaType;

public class LeitorArquivoVendas 
{
	private static final String LEITURA_VENDAS_DINHEIRO = 
			".../lista_vendas_FINAL.txt";
	
	private static final String LEITURA_VENDAS_CARTAO = 
			".../lista_vendas_CARTAO.txt";

	private static final String COD_BARRA_DEFAULT = "1111111111111";

	private static final Logger LOGGER = Logger.getLogger(LeitorArquivoVendas.class);

	private Map<String, VendaType> mapVendas = new HashMap<String, VendaType>();

	private ObjectFactory factory = new ObjectFactory();

	private LojaType loja = factory.createLojaType();

	public Map<String, VendaType> leArquivo(List<String> listaProcessada) throws IOException, DatatypeConfigurationException 
	{
		//FileWriter fWriter = new FileWriter(LEITURA_VENDAS_DINHEIRO);
		FileWriter fWriter = new FileWriter(LEITURA_VENDAS_CARTAO);
		PrintWriter pWriter = new PrintWriter(new BufferedWriter(fWriter));

		loja.setId((long) 1);
		loja.setCodigoInterno((long) 1);

		for (String linha : listaProcessada)
		{
			String documentoVenda = linha.substring(0,11);

			String data 		  = linha.substring(12,22).trim();
			String hora 		  = linha.substring(23,31).replace(".", ":").trim();
			String dataEHora 	  = data + " " + hora;

			XMLGregorianCalendar dataVendaType = obterDataParaVendaType(dataEHora);

			String quantidade 	  = linha.substring(32, 36).trim();

			String precoCusto 	  = linha.substring(41, 51).trim();
			String precoCustoFormatado 	 = formataValor(precoCusto);

			String codigoInternoProduto  = linha.substring(63, 69).trim();


			ItemPedidoType itemVenda = factory.createItemPedidoType();
			ProdutoType produto = factory.createProdutoType();

			itemVenda.setQuantidade(new BigDecimal(quantidade));
			itemVenda.setPreco(new BigDecimal(precoCustoFormatado));

			/**setando cod. barra com valor default 
			 * (não vem o campo no arquivo)*/
			produto.setCodigoBarra(COD_BARRA_DEFAULT);

			produto.setCodigoInterno(Long.parseLong(codigoInternoProduto));

			itemVenda.setProduto(produto);

			if(mapVendas.containsKey(documentoVenda))
			{
				mapVendas.get(documentoVenda).getItem().add(itemVenda);
			}
			else
			{
				VendaType venda = factory.createVendaType();

				venda.getItem().add(itemVenda);

				venda.setLoja(loja);
				venda.setDataCompra(dataVendaType);

				mapVendas.put(documentoVenda, venda);
			}
		}

		int count = 0;
		for (Map.Entry<String, VendaType> par : mapVendas.entrySet()) 
		{
			for (ItemPedidoType item : par.getValue().getItem()) 
			{
				count++;
				pWriter.println(item.toString());
			}
		}

		pWriter.println("\nTOTAL: " + count);
		pWriter.close();

		return mapVendas;
	}


	public XMLGregorianCalendar obterDataParaVendaType(String dataEHora) throws DatatypeConfigurationException 
	{
		DateTimeFormatter dataFormat = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		DateTime dataVenda = dataFormat.parseDateTime(dataEHora);
		Date dataVendaFormatada = dataVenda.toDate();

		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(dataVendaFormatada);

		XMLGregorianCalendar dataVendaType = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		return dataVendaType;
	}


	public String formataValor(String valor)
	{
		String valorFormatado = valor;

		if (valorFormatado.startsWith(","))
			valorFormatado = "0".concat(valorFormatado);

		return valorFormatado.replace(",", ".");
	}

}
