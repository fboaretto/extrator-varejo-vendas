package com.projetandoo.extrator.model;

import java.io.Serializable;

public class Loja implements Serializable
{

	private static final long serialVersionUID = 6160457143945962179L;

	private long id;

	private long codigoInterno;


	public Loja(long id, long codigoInterno) {
		this.id = id;
		this.codigoInterno = codigoInterno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(long codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	@Override
	public String toString() 
	{
		return "Loja [id=" + id + ", codigoInterno=" + codigoInterno + "]";
	}

}
