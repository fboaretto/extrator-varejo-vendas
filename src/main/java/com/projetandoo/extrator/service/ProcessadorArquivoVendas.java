package com.projetandoo.extrator.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ProcessadorArquivoVendas {

	private static final String PREFIX_MARKAO = "MARKAO COSMETICOS";

	private static final Logger LOGGER = Logger.getLogger(ProcessadorArquivoVendas.class);

	public List<String> processaArquivo(String arquivoCarga) throws IOException 
	{
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCarga), "IBM850"));

		List<String> linhasProcessadas = new ArrayList<String>();

		String linha = "";

		//Ignorando header inicial
		for (int i = 1; i <= 11; i++) {
			linha = buffReader.readLine();
		}

		while (linha != null && !linha.isEmpty()) 
		{
			if (linha.contains(PREFIX_MARKAO)) 
			{
				for (int i = 1; i <= 4; i++)
					linha = buffReader.readLine();
			}

			String novaLinha = linha.substring(101,112) + "|" + linha;
			linhasProcessadas.add(novaLinha);

			linha = buffReader.readLine();
		}

		for (String string : linhasProcessadas)
		{
			LOGGER.debug("***** " + string);
		}

		LOGGER.debug(">>>>linhas: " + linhasProcessadas.size());
		buffReader.close();

		return linhasProcessadas;
	}

}
