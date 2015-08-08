package com.projetandoo.extrator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemVenda implements Serializable
{

	private static final long serialVersionUID = 5551199815289359909L;

	private BigDecimal quantidade;

	private BigDecimal preco;

	private Produto produto;


	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString()
	{
		return "ItemVenda [quantidade=" + quantidade + ", preco=" + preco
				+ ", produto=" + produto + "]";
	}


}
