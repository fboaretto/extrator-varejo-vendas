package com.projetandoo.extrator.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.model.ItemVenda;
import com.projetandoo.extrator.model.Venda;

public class ExtratorArquivoVendas {

	private static final Logger logging = Logger.getLogger(ExtratorArquivoVendas.class);
	
	public static void main(String[] args) throws IOException {

		String arquivoCargaCompras = args[0];

		ProcessadorArquivoVendas processador = new ProcessadorArquivoVendas();
		List<String> listaProcessada =  processador.processaArquivo(arquivoCargaCompras);
		
		LeitorArquivoVendas leitor = new LeitorArquivoVendas();
		List<Venda> listaVendas = leitor.leArquivo(listaProcessada);

		logging.debug("\n\n*********** vendas & items: " + listaVendas.size()	+ "\n");
		for (Venda venda : listaVendas) {
			logging.debug("Num da Venda: " + venda.getNumero());
			logging.debug("Items vendidos:");
			for (ItemVenda item : venda.getItems()) {
				logging.debug(item.toString());
			}
			logging.debug("\n");
		}

	}

}
