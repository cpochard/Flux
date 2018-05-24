package com.cpochard;

public class Voiture {

	protected String marque;
	protected String couleur;
	protected String modele;
	protected int prix;
	
	public Voiture (String tmpMarque, String tmpCouleur, String tmpModele, int tmpPrix) {
		marque = tmpMarque;
		couleur = tmpCouleur;
		modele = tmpModele;
		prix = tmpPrix;
	}

	@Override
	public String toString() {
		return "Marque : " + marque + ", couleur : " + couleur + ", modèle : " + modele + ", prix : " + prix;
	}
}
