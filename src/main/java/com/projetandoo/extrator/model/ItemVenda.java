package com.projetandoo.extrator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemVenda implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Produto produto;
	
	private int quantidade;
	
	private BigDecimal preco;
	
	private String nomeProduto;
	
	
	@Override
	public String toString() {
		return getNomeProduto() + "||" + getQuantidade() + "||" + getPreco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
}
