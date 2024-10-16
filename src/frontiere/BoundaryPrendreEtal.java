package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol� " + nomVendeur + " mais il faut �tre un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un �tal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("D�sol� " + nomVendeur + " je n'ai plus d'�tal qui ne soit pas d�j� occup�.");
			} else {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un �tal pour vous !");
				String produit;
				int nbProduit = 0;
				StringBuilder question = new StringBuilder();
				System.out.println("Il me faudrait quelques renseignements :\n");
				produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre ?");
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
