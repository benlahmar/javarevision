package com.model;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	int id;
	String libelle;
	
	
	List<Livre> livres=new ArrayList<Livre>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	
	
}
