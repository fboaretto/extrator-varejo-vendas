package com.projetandoo.extrator.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private Date dataVenda;

	private String numero;

	private String tipoOperacao;

	private int caixa;

	private BigDecimal total;

	private Collection<ItemVenda> items = new HashSet<ItemVenda>();


	@Override
	public String toString() {
		return getId() + "||" + getNumero() + "||" + getTipoOperacao() + "||"
				+ getCaixa() + "||" + getTotal() + "||" + getItems().size() + "||" + getDataVenda();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Collection<ItemVenda> getItems() {
		return items;
	}

	public void setItems(Collection<ItemVenda> items) {
		this.items = items;
	}

	public int getCaixa() {
		return caixa;
	}

	public void setCaixa(int caixa) {
		this.caixa = caixa;
	}

}
