package com.model;

public class User {

	int id;
	String nom,log,pass;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String nom, String log, String pass) {
		super();
		this.nom = nom;
		this.log = log;
		this.pass = pass;
	}
	
	
	
}
