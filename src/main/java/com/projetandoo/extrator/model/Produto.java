package com.projetandoo.extrator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable
{

	private static final long serialVersionUID = 2145737540105006578L;

	private long codigoInterno;

	private String nome;

	private BigDecimal valorCusto;

	private BigDecimal valorVenda;


	public long getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(long codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	@Override
	public String toString() 
	{
		return "Produto [codigoInterno=" + codigoInterno + ", nome=" + nome	+ "]";
	}

}
