package com.projetandoo.extrator.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class ProcessadorArquivoVendas {

	private static final String PREFIX_CABECALHO_ITEMCOMPRA = "Descricao";
	private static final String PREFIX_CABECALHO_COMPRA		= " Numero";
	private static final String PREFIX_FIM_ARQUIVO 			= "-------";
	private static final String PREFIX_MARKAO 				= "MARKAO COSMETICOS";
	
	private static final Logger logging = Logger.getLogger(ProcessadorArquivoVendas.class);

	public List<String> processaArquivo(String arquivoCarga) throws IOException {

		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCarga), "IBM850"));
		
		List<String> linhasProcessadas = new ArrayList<String>();
		
		String linha = buffReader.readLine();
		linha = buffReader.readLine();

		//split na segunda linha para capturar dia e hora das vendas:
		String[] items = StringUtils.split(linha);
		linhasProcessadas.add(items[2] + " " + items[3]);

		//Ignorando header inicial
		for (int i = 1; i <= 11; i++) {
			linha = buffReader.readLine();
		}

		while (linha != null) {

			if (linha.contains(PREFIX_MARKAO)) {
				for (int i = 1; i <= 6; i++)
					linha = buffReader.readLine();
			}

			if (linha.startsWith(PREFIX_CABECALHO_COMPRA)) {

				linha = buffReader.readLine();

				if (linha.contains(PREFIX_MARKAO)) {
					for (int i = 1; i <= 6; i++)
						linha = buffReader.readLine();
				}
			}

			if (linha.startsWith(PREFIX_CABECALHO_ITEMCOMPRA)) {

				linha = buffReader.readLine();

				if (linha.contains(PREFIX_MARKAO)) {
					for (int i = 1; i <= 6; i++)
						linha = buffReader.readLine();
				}
			}

			if (linha.startsWith(PREFIX_FIM_ARQUIVO)) {
				linhasProcessadas.add(linha);
				logging.debug(linha);
				break;
			}
			
			logging.debug(linha);

			linhasProcessadas.add(linha);
			linha = buffReader.readLine();
		}

		buffReader.close();
		
		return linhasProcessadas;
	}

}
