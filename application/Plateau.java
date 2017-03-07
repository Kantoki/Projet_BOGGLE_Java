package application;

public class Plateau {
	private static final short NOMBRE_DE = 16;
	private D�[] d�s;
	private boolean[] visit�e;
	private ListeMot motsPr�sents;

//============================================================================================================	

	public Plateau(){
		d�s = new D�[NOMBRE_DE];
		motsPr�sents=new ListeMot();
		visit�e=new boolean[NOMBRE_DE];
	}

//============================================================================================================	
	
	public Plateau(String[] facesD�s){
		this();
		for (int i=0; i<NOMBRE_DE; i++){
			d�s[i] = new D�(facesD�s[i]);
			d�s[i].rouler();
		}
	}

//============================================================================================================	
	
	public void ajouterMotPlateau(String mot){
		if (!mot.isEmpty()){
			motsPr�sents.ajouterMot(mot);
		}
	}

//============================================================================================================	
	
	public void m�langer(){
		for (int i=0; i<NOMBRE_DE; i++){
			d�s[i].rouler();
		}
	}
	
//============================================================================================================	
	
	public boolean recherche(String mot){
		for (int i=0; i<visit�e.length; i++){
			visit�e[i]=false;
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
		if (d�s[coord].donnerLettre()!=mot.toUpperCase().charAt(pos)){
			return false;
		}
		if (visit�e[coord]){
			return false;
		}
		visit�e[coord]=true;
		//Pourrait �tre automatis� avec une boucle for...
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
		visit�e[coord]=false;
		return false;
	}
	
//============================================================================================================	

	public ListeMot donnerListe(){
		return new ListeMot(motsPr�sents);
	}
	
//============================================================================================================	

	public boolean listeContient(String s){
		return motsPr�sents.contientMot(s);
	}
	
//============================================================================================================	

	public boolean listeEstVide(){
		return motsPr�sents.estVide();
	}
		
//============================================================================================================	

	public void effacerPlateau(){
		motsPr�sents.viderListe();
	}

//============================================================================================================	
		
	@Override
	public String toString() {
		String s="+---+---+---+---+\n|";
		for(int i=0; i<NOMBRE_DE; i++){
			s=s+" "+d�s[i].donnerLettre()+" |";
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
