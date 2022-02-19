package model;

import java.io.Serializable;

public class Compte implements Serializable{
	
	private String titulaire;
	private int numero;
	private double solde;
	
	public Compte() {}
	
	public Compte(String titulaire, int numero, double solde) {
		super();
		this.titulaire = titulaire;
		this.numero = numero;
		this.solde = solde;
	}
	
	public String getTitulaire() {
		return titulaire;
	}
	
	public void setTitulaire(String titulaire) {
		this.titulaire = titulaire;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public double getSolde() {
		return solde;
	}
	
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public void Crediter(double montant) {
		
		this.solde += montant;
		
	}
	
	public void Debiter(double montant) {
		
		this.solde -= montant;
		
	}

	@Override
	public String toString() {
		return "Compte [titulaire=" + titulaire + ", numero=" + numero + ", solde=" + solde + "]";
	}
	
	

}
