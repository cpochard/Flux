package com.cpochard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {

		ecrireFichier ("test.txt", "Bien le bonjour!");
		lireFichier ("test.txt");

		Voiture maVoiture = new Voiture ("Renault", "verte", "clio", 3000);
		System.out.println(maVoiture.toString());
		ecrireFichier ("sauvegarde.txt", maVoiture.toString());

		comparaisonLecture();
	}

	//Méthode qui écrit contenu dans nomFichier
	public static void ecrireFichier (String nomFichier, String contenu) {
		File fichier = new File (nomFichier);
		FileWriter flux;
		BufferedWriter fluxTampon;
		try {
			fluxTampon = new BufferedWriter (new FileWriter (fichier));
			fluxTampon.write(contenu);
			fluxTampon.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Méthode qui lit un fichier et retourne son contenu
	public static void lireFichier (String nomFichier) {
		long debut = System.currentTimeMillis();
		File fichier = new File (nomFichier);
		FileReader flux;
		BufferedReader fluxTampon;
		try {
			fluxTampon = new BufferedReader (new FileReader (fichier));
			String ligne, contenuFichier = "";
			while ((ligne = fluxTampon.readLine()) != null)
				contenuFichier += ligne;
			//System.out.println(contenuFichier);
			fluxTampon.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis()-debut);
	}

	public static void lireFichierSansBuffered () {
		long debut = System.currentTimeMillis();
		File fichier = new File ("motsEnA.txt");
		FileReader flux;
		try {
			flux = new FileReader (fichier);
			String contenuFichier = "";
			int i =0;
			while ((i=flux.read()) != -1)
				contenuFichier+= (char)i;
			//System.out.println(contenuFichier);
			flux.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis()-debut);
	}

	public static void comparaisonLecture () {
		lireFichierSansBuffered();
		lireFichier ("motsEnA.txt");
	}


}

