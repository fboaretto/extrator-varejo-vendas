package com.projetandoo.extrator.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.clienteWS.StatusType;
import com.projetandoo.extrator.clienteWS.VendaType;
import com.projetandoo.extrator.clienteWS.Vendas;
import com.projetandoo.extrator.clienteWS.VendasResponseType;
import com.projetandoo.extrator.clienteWS.Vendas_Service;

public class ConsumidorVendas 
{
	private static final Logger LOGGER = Logger.getLogger(ConsumidorVendas.class);

	public static void main(String[] args) throws IOException, DatatypeConfigurationException 
	{
		String arquivoCargaVendas = 
				//".../sp001148.txt";
				".../sp001149.txt";
		
		String arquivoControleDinheiro = 
				".../vendas_enviadas.txt";
		
		String arquivoControleCartao = 
				".../vendas_enviadas_cartao.txt";

		ProcessadorArquivoVendas processador = new ProcessadorArquivoVendas();
		List<String> listaProcessada =  processador.processaArquivo(arquivoCargaVendas);

		LeitorArquivoVendas leitor = new LeitorArquivoVendas();
		Map<String, VendaType> mapaVendas = leitor.leArquivo(listaProcessada);

		//TODO .: LER DE UM ARQUIVO QUE AINDA NÃO EXISTE
		//Arquivo Controle
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoControleCartao)));
		String linhaCodigo = buffReader.readLine();

		LOGGER.debug("\n\nTOTAL ANTES:::::: " + mapaVendas.size());
		while (linhaCodigo != null) 
		{
			if (mapaVendas.containsKey(linhaCodigo))
			{
				mapaVendas.remove(linhaCodigo);
			}
			linhaCodigo = buffReader.readLine();
		}

		buffReader.close();

		LOGGER.debug("\n\n..E DEPOIS!!!:::::: " + mapaVendas.size());
		

		Authenticator.setDefault(new Authenticator() 
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(
						"...",
						"...".toCharArray());
			}
		});

		
		Vendas_Service servico = new Vendas_Service();
		Vendas vendas = servico.getVendasSOAP();

		FileWriter arquivoControleAAtualizar = new FileWriter(arquivoControleCartao, true);
		PrintWriter pWriter = new PrintWriter(arquivoControleAAtualizar);

		for (Map.Entry<String, VendaType> venda : mapaVendas.entrySet()) 
		{
			try 
			{
				VendasResponseType vendaResponse = vendas.salvarVendas(venda.getValue());

				LOGGER.debug("[" + vendaResponse.getDataProcessamento() 
						+ "] DOC venda : " + venda.getKey() 
						+ ", STATUS: " + vendaResponse.getServiceStatus());
				
				if(vendaResponse.getServiceStatus().equals(StatusType.SUCESSO))
				{
					pWriter.println(venda.getKey());
					pWriter.flush();
				}
				
			} catch (Exception e) {
				pWriter.close();
				e.printStackTrace();
			}
		}

		pWriter.close();
	}

}