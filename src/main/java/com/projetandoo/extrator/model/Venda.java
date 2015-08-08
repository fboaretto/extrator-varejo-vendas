package com.projetandoo.extrator.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda implements Serializable, Comparable<Venda> 
{

	private static final long serialVersionUID = -4223724357585674565L;

	private String documento;

	private List<ItemVenda> items = new ArrayList<ItemVenda>();

	private Loja loja;

	private Date dataVenda;


	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public List<ItemVenda> getItems() {
		return items;
	}

	public void setItems(List<ItemVenda> items) {
		this.items = items;
	}

	@Override
	public String toString() 
	{
		return "Venda [documento=" + documento + ", items=" + items + ", loja="
				+ loja + ", dataVenda=" + dataVenda + "]";
	}

	@Override
	public int compareTo(Venda outraVenda) 
	{
		if (this.documento.equals(outraVenda.documento)) {
			return 1;
		}
		return 0;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result
				+ ((documento == null) ? 0 : documento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		return true;
	}

}
