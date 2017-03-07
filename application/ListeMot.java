package application;

import java.util.ArrayList;
import java.util.Iterator;

public class ListeMot {
	private ArrayList<String> mots;

//============================================================================================================	

	public ListeMot(){
		mots = new ArrayList<String>();
	}
	
//============================================================================================================	

	public ListeMot(ListeMot liste){
		mots = new ArrayList<String>(liste.mots);
	}
	
//============================================================================================================	
	
	private String normalize(String s){
		String sn=s.trim();
		sn=sn.toUpperCase();
		sn=sn.replace('É', 'E');
		sn=sn.replace('È', 'E');
		sn=sn.replace('Ê', 'E');
		sn=sn.replace('À', 'A');
		sn=sn.replace('Â', 'A');
		for (int i=0; i<sn.length(); i++){
			if ((sn.charAt(i)<'A') || (sn.charAt(i)>'Z')){
				sn=sn.replace(String.valueOf(sn.charAt(i)),"");
			}
		}
		return sn;
	}
	
//============================================================================================================	
		
	public void ajouterMot(String mot){
		mots.add(normalize(mot));
	}
	
//============================================================================================================	
	
	public boolean contientMot(String mot){
		return mots.contains(normalize(mot));
	}
	
//============================================================================================================	
	
	public boolean supprimerMot(String mot){
		return mots.remove(normalize(mot));
	}
	
//============================================================================================================	
	
	public int tailleListe(){
		return mots.size();
	}
	
//============================================================================================================	
	
	public boolean estVide(){
		return mots.isEmpty();
	}

//============================================================================================================	
		
	public String donnerMot(int i){
		return mots.get(i);
	}

//============================================================================================================	
		
	public void viderListe(){
		mots.clear();
	}
	
//============================================================================================================	
	
	@Override
	public String toString(){
		String s="";
		int i=0;
		Iterator<String> itr = mots.iterator();
	      while(itr.hasNext()) {
	    	 s = s+itr.next();
	         i++;
	         if (i % 5 ==0){
	        	 s=s.substring(0, s.length())+"\n";
	         }
	         else{
	        	 s=s+" - ";
	         }
	      }
		return s;
	}
	
}
