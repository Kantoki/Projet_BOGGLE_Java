package application;

public class Joueur {

	private String nom;
	private int score;
	private ListeMot motsTrouvés;
	
//============================================================================================================	
	
	public Joueur(String nom) {
		this.nom=nom;
		this.score=0;
		motsTrouvés = new ListeMot();
	}
	
//============================================================================================================	
	
	public String donnerNom(){
		return nom;
	}
	
//============================================================================================================	
	
	public ListeMot donnerListe(){
		return new ListeMot(motsTrouvés);
	}
	
//============================================================================================================	
	
	public int donnerScore(){
		return score;
	}
		
	
//============================================================================================================	
	
	public void modifierScore(int s){
		score = s;
	}
	
//============================================================================================================	

	public void calculerScore(){
		int s=0;
		for(int i=0; i<motsTrouvés.tailleListe(); i++){
			if (motsTrouvés.donnerMot(i).length()>=3){
				s+=1;
				if (motsTrouvés.donnerMot(i).length()>=5){
					s+=1;
					if (motsTrouvés.donnerMot(i).length()>=6){
						s+=1;
						if (motsTrouvés.donnerMot(i).length()>=7){
							s+=2;
							if (motsTrouvés.donnerMot(i).length()>=8){
								s+=6;
							}
						}
					}
				}
			
			}
		}
		modifierScore(s);
	}
	
//============================================================================================================	

	public void ajouterMotListe(String mot){
		if (!mot.isEmpty()){
			motsTrouvés.ajouterMot(mot);
		}
	}

//============================================================================================================	
	
	public boolean supprimerMotListe(String mot){
		return motsTrouvés.supprimerMot(mot);
	}
		
//============================================================================================================	

	public boolean listeContient(String s){
		return motsTrouvés.contientMot(s);
	}
	
//============================================================================================================	

	public boolean listeEstVide(){
		return motsTrouvés.estVide();
	}
	
//============================================================================================================	

		public void effacerJoueur(){
		motsTrouvés.viderListe();
	}
		
//============================================================================================================	
	
	@Override
	public String toString(){
		return ("Nom du joueur : " + nom + " a pour score : " + score + "\n" + motsTrouvés);
	}
}
