package application;

public class Plateau {
	private static final short NOMBRE_DE = 16;
	private Dé[] dés;
	private boolean[] visitée;
	private ListeMot motsPrésents;

//============================================================================================================	

	public Plateau(){
		dés = new Dé[NOMBRE_DE];
		motsPrésents=new ListeMot();
		visitée=new boolean[NOMBRE_DE];
	}

//============================================================================================================	
	
	public Plateau(String[] facesDés){
		this();
		for (int i=0; i<NOMBRE_DE; i++){
			dés[i] = new Dé(facesDés[i]);
			dés[i].rouler();
		}
	}

//============================================================================================================	
	
	public void ajouterMotPlateau(String mot){
		if (!mot.isEmpty()){
			motsPrésents.ajouterMot(mot);
		}
	}

//============================================================================================================	
	
	public void mélanger(){
		for (int i=0; i<NOMBRE_DE; i++){
			dés[i].rouler();
		}
	}
	
//============================================================================================================	
	
	public boolean recherche(String mot){
		for (int i=0; i<visitée.length; i++){
			visitée[i]=false;
		}
		for (int i=0; i<NOMBRE_DE; i++){
			if (sousRecherche(mot,0,i)){
				return true;
			}
		}
		return false;
	}

//============================================================================================================	
	
	private boolean sousRecherche(String mot, int pos, int coord){
		if (pos>=mot.length()){
			return true;
		}
		if ((coord>=NOMBRE_DE)||coord<0){
			return false;
		}
		if (dés[coord].donnerLettre()!=mot.toUpperCase().charAt(pos)){
			return false;
		}
		if (visitée[coord]){
			return false;
		}
		visitée[coord]=true;
		//Pourrait être automatisé avec une boucle for...
		if (sousRecherche(mot, pos+1,coord-4)){
			return true;
		}
		if (sousRecherche(mot, pos+1,coord+4)){
			return true;
		}
		if (sousRecherche(mot, pos+1,coord-1)){
			return true;
		}
		if (sousRecherche(mot, pos+1,coord+1)){
			return true;
		}
		if (sousRecherche(mot, pos+1,coord-3)){
			return true;
		}
		if (sousRecherche(mot, pos+1,coord+3)){
			return true;
		}
		if (sousRecherche(mot, pos+1,coord-5)){
			return true;
		}
		if (sousRecherche(mot, pos+1,coord+5)){
			return true;
		}
		visitée[coord]=false;
		return false;
	}
	
//============================================================================================================	

	public ListeMot donnerListe(){
		return new ListeMot(motsPrésents);
	}
	
//============================================================================================================	

	public boolean listeContient(String s){
		return motsPrésents.contientMot(s);
	}
	
//============================================================================================================	

	public boolean listeEstVide(){
		return motsPrésents.estVide();
	}
		
//============================================================================================================	

	public void effacerPlateau(){
		motsPrésents.viderListe();
	}

//============================================================================================================	
		
	@Override
	public String toString() {
		String s="+---+---+---+---+\n|";
		for(int i=0; i<NOMBRE_DE; i++){
			s=s+" "+dés[i].donnerLettre()+" |";
			if (((i+1) % 4) == 0){
				s=s+"\n+---+---+---+---+\n";
				if (i!=15){
					s=s+"|";
				}
			}
		}
		return s;
	}
	
}
