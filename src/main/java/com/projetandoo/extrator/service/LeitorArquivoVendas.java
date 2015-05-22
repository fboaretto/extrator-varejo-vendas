package com.projetandoo.extrator.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.projetandoo.extrator.model.ItemVenda;
import com.projetandoo.extrator.model.Venda;

public class LeitorArquivoVendas {

	private static final String PREFIX_FIM_ARQUIVO = "------";
	
	private List<Venda> listaVendas = new ArrayList<Venda>();
	
	private static final Logger logging = Logger.getLogger(LeitorArquivoVendas.class);

	public List<Venda> leArquivo(List<String> listaProcessada) throws IOException {

		FileWriter fWriter = 
				new FileWriter("/home/fboaretto/Documentos/Projetandoo/arquivosExtracao/relatoriodeprodutoscadastradoseestoque/lista_vendas_FINAL.txt");
		PrintWriter pWriter = new PrintWriter(new BufferedWriter(fWriter));
		

		//capturando data e hora
		String dataVendasCapturada = listaProcessada.get(0);

		DateTimeFormatter dataFormat = DateTimeFormat.forPattern("dd/MM/yyyy H:mm");
		DateTime dataVendas = dataFormat.parseDateTime(dataVendasCapturada);
		Date dataVendasFormatada = dataVendas.toDate();

		logging.debug(">>>>>>>data das vendas: " + dataVendasFormatada);

		for(int i = 1; i < listaProcessada.size(); i++) {
			
			if (listaProcessada.get(i).startsWith(PREFIX_FIM_ARQUIVO))
				break;

			String numeroVenda = listaProcessada.get(i).substring(0, 9).trim();
			String tipoOperacao = listaProcessada.get(i).substring(9, 25).trim();
			String caixa = listaProcessada.get(i).substring(25, 29).trim();
			String valorTotal = listaProcessada.get(i).substring(32, 40).trim().replace(",", ".");

			Venda venda = new Venda();

			venda.setDataVenda(dataVendasFormatada);
			venda.setNumero(numeroVenda);
			venda.setTipoOperacao(tipoOperacao);
			venda.setCaixa(Integer.parseInt(caixa));
			venda.setTotal(new BigDecimal(valorTotal));

			i++;
			
			List<ItemVenda> items = new ArrayList<ItemVenda>();

			while(!listaProcessada.get(i).equals(StringUtils.EMPTY) && !listaProcessada.get(i).startsWith(PREFIX_FIM_ARQUIVO)) {

				String nomeProduto = listaProcessada.get(i).substring(5, 25).trim();
				String quantidade = listaProcessada.get(i).substring(28, 30);
				String preco = listaProcessada.get(i).substring(32, 40).trim().replace(",", ".");

				ItemVenda itemVenda = new ItemVenda();

				itemVenda.setNomeProduto(nomeProduto);
				itemVenda.setQuantidade(Integer.parseInt(quantidade));
				itemVenda.setPreco(new BigDecimal(preco));

				items.add(itemVenda);
				i++;
			}
			
			venda.setItems(items);
			logging.debug("VENDA======> " + venda);
			
			listaVendas.add(venda);
			pWriter.println(venda);
			
			//i++;
			
		}
		
		pWriter.println("\nTOTAL: " + listaVendas.size());
		pWriter.close();
		
		return listaVendas;
	}

}
