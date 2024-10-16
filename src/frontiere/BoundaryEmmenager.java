package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois " + nomVisiteur);
					StringBuilder question2 = new StringBuilder();
					question2.append("Quelle est votre force ?\n");
					int choixUtilisateur2 = -1;
					choixUtilisateur2 = Clavier.entrerEntier(question2.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, choixUtilisateur2);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
		
		int choixUtilisateur = -1;
		int effetPotionMax = -1;
		int effetPotionMin = 0;
		
		StringBuilder question = new StringBuilder();
		question.append("Quelle est votre force ?\n");
		choixUtilisateur = Clavier.entrerEntier(question.toString());
		
		while (effetPotionMax<effetPotionMin) {
			StringBuilder question2 = new StringBuilder();
			question2.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
			effetPotionMin = Clavier.entrerEntier(question2.toString());
			
			StringBuilder question3 = new StringBuilder();
			question3.append("Quelle est la force de potion la plus forte que vous produisez ?\n");
			effetPotionMax = Clavier.entrerEntier(question3.toString());
			
			if(effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
			}
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, choixUtilisateur, effetPotionMin, effetPotionMax);
	}
	
}
