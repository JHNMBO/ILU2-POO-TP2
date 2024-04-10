package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois; // Pas de Gaulois ni Etal
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		//Complete
		if(!(controlAcheterProduit.verifierIdentite(nomAcheteur))) {
			System.out.println("Je suis désole " + nomAcheteur + 
					" mais il faut être un habitant de notre village pour commercer ici");
		}
		
		System.out.println("Quel produit voulez-vous acheter ?");
		String Produit = scan.next();
		Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(Produit);
		if(vendeurs.length==0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		}
		
		System.out.println("Chez quel commercant voulez-vous acheter ?");
		for (int i = 0; i < vendeurs.length; i++) {
			String nom = vendeurs[i].getNom();
			System.out.println(i + " - " + nom);
		}
		int indice = Clavier.entrerEntier("");
		String nomVendeur = vendeurs[indice].getNom();
		
		if(!(controlAcheterProduit.verifierIdentite(nomVendeur))) {
			System.out.println("Je suis désole " + nomVendeur + 
					" mais il faut être un habitant de notre village pour commercer ici");
		}
		
		Etal etalVendeur = controlAcheterProduit.trouverEtalVendeur(nomVendeur);
		int nbProduit = Clavier.entrerEntier(nomAcheteur + " se déplace jusqu'a l'étal du vendeur " 
				+ nomVendeur + "\nBonjour " + nomAcheteur + "\nCombien de " + Produit + 
				" voulez-vous acheter ?");
		int quantiteAchete = controlAcheterProduit.acheterProduit(nomVendeur, nbProduit);
		if(quantiteAchete==0) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteAchete + " " + 
					Produit + ", malheureusement il n'y en a plus");
		}
		else if(nbProduit>etalVendeur.getQuantite()) {
			System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + 
		Produit + ", malheureusement " + nomVendeur + " n'en a plus que " + etalVendeur.getQuantite() + 
		". " + nomAcheteur + " achète tout le stock de " + nomVendeur);
		}
		else {
			System.out.println(nomAcheteur + " achète " + quantiteAchete + " " + Produit + " à " + nomVendeur);
		}
	}
}
