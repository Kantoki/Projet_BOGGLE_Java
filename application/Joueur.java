package application;

public class Joueur {

	private String nom;
	private int score;
	private ListeMot motsTrouv�s;
	
//============================================================================================================	
	
	public Joueur(String nom) {
		this.nom=nom;
		this.score=0;
		motsTrouv�s = new ListeMot();
	}
	
//============================================================================================================	
	
	public String donnerNom(){
		return nom;
	}
	
//============================================================================================================	
	
	public ListeMot donnerListe(){
		return new ListeMot(motsTrouv�s);
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
		for(int i=0; i<motsTrouv�s.tailleListe(); i++){
			if (motsTrouv�s.donnerMot(i).length()>=3){
				s+=1;
				if (motsTrouv�s.donnerMot(i).length()>=5){
					s+=1;
					if (motsTrouv�s.donnerMot(i).length()>=6){
						s+=1;
						if (motsTrouv�s.donnerMot(i).length()>=7){
							s+=2;
							if (motsTrouv�s.donnerMot(i).length()>=8){
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
			motsTrouv�s.ajouterMot(mot);
		}
	}

//============================================================================================================	
	
	public boolean supprimerMotListe(String mot){
		return motsTrouv�s.supprimerMot(mot);
	}
		
//============================================================================================================	

	public boolean listeContient(String s){
		return motsTrouv�s.contientMot(s);
	}
	
//============================================================================================================	

	public boolean listeEstVide(){
		return motsTrouv�s.estVide();
	}
	
//============================================================================================================	

		public void effacerJoueur(){
		motsTrouv�s.viderListe();
	}
		
//============================================================================================================	
	
	@Override
	public String toString(){
		return ("Nom du joueur : " + nom + " a pour score : " + score + "\n" + motsTrouv�s);
	}
}
