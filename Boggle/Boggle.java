package Boggle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import application.Joueur;
import application.ListeMot;
import application.Plateau;

public class Boggle {
	
	private static Plateau p;
	private static Joueur[] joueurs;
	
//============================================================================================================		
	
	//Met en place les dés en indiquant la valeur de leurs faces
	
	private static void initialiserDé(String[] arguments){
		String[] facesDés = new String[16];
		if (arguments.length == 0){
    		facesDés[0] = "ETUKNO";
    		facesDés[1] = "EVGTIN";
    		facesDés[2] = "DECAMP";
    		facesDés[3] = "IELRUW";
    		facesDés[4] = "EHIFSE";
    		facesDés[5] = "RECALS";
    		facesDés[6] = "ENTDOS";
    		facesDés[7] = "OXFRIA";
    		facesDés[8] = "NADEVZ";
    		facesDés[9] = "EIOATA";
    		facesDés[10] = "GLENYU";
    		facesDés[11] = "BMAQJO";
    		facesDés[12] = "TLIBRA";
    		facesDés[13] = "SPULTE";
    		facesDés[14] = "AIMSOR";
    		facesDés[15] = "ENHRIS";
        }
        else{
        	try
        	{
        	    File f = new File (arguments[0]);
        	    Scanner scanner = new Scanner (f);
        	    for(char i=0; i<16; ++i)
        	    {
        	        try
        	        {
        	            facesDés[i]=scanner.next();
        	        }
        	        catch (NoSuchElementException exception)
        	        {
        	        	facesDés[i] = "A";
        	        }
        	    }
        	    scanner.close();
        	}
        	catch (FileNotFoundException exception)
        	{
        	    System.out.println ("Le fichier n'a pas été trouvé");
        	}
        }
		p = new Plateau(facesDés);
	}
	
//============================================================================================================	
	
	//Met en place le plateau en initialisant les dés et en lançant la recherche des mots présents sur le plateau
	
	public static void initialiserPlateau(String[] arguments){
		initialiserDé(arguments);
        try
    	{
    	    File f = new File ("dico.txt");
    	    Scanner scanner = new Scanner (f);
    	    String mot;
    	    while(true)
    	    {
    	        try
    	        {
    	            mot=scanner.next();
    	            if (p.recherche(mot)){
    	            	p.ajouterMotPlateau(mot);
    	            }
    	        }
    	        catch (NoSuchElementException exception)
    	        {
    	        	break;
    	        }
    	    }
    	    scanner.close();
    	}
    	catch (FileNotFoundException exception)
    	{
    	    System.out.println ("Le dictionaire n'a pas été trouvé");
    	}
	}
	
//========================================= MAIN =============================================================
	
	public static void main (String[] args) {
		
		boolean jouer =true, erreur=false;
        Scanner sc = new Scanner (System.in);
        int nb=1, highScore=0;
        ListeMot listeComp=new ListeMot();
		
		while (jouer){
			initialiserPlateau(args);
			do
			{
				erreur=false;
				System.out.print("Veuillez entrer le nombre de joueurs: ");
	        	try{
	        		nb=sc.nextInt();
	        	}
	        	catch(InputMismatchException exception){
	        		System.out.println("Valeur erronée, veuillez entrer un chiffre.");
	        		sc.next();
	        		erreur=true;
	        	}
	        	if (nb<=0){
	        		System.out.println("Valeur erronée, veuillez entrer un chiffre supérieur à 0.");
	        		erreur=true;
	        	}
			}
			while(erreur);
	        
			joueurs = new Joueur[nb];
			
	        for(int i=0; i<nb; i++){
	        	System.out.print("Veuillez entrer le nom du joueur "+(i+1)+": ");
	        	joueurs[i]=new Joueur(sc.next());
	        }
			
	        System.out.println(p);
	        
	        for(int i=0; i<nb; i++){
	        	System.out.println("Veuillez entrer vos mots "+joueurs[i].donnerNom()+".\nSaisissez '!' pour terminer votre tour.");
	        	String s;
	        	do{
	        		s=sc.next();
	        		if (( p.listeContient(s) ) && ( !joueurs[i].listeContient(s) )){
	        			joueurs[i].ajouterMotListe(s.replace("!", ""));
	        		}
	        	}
	        	while(!s.endsWith("!"));
	            if (i<nb-1){
	            	System.out.println(p);
	            }
	        }
	        
	        for (int i=0; i<nb-1; i++){
	        	listeComp = joueurs[i].donnerListe();
	        	for (int k=0; k<listeComp.tailleListe(); k++){
	        		boolean b=false;
	        		for (int j=i+1; j<nb; j++){
	        			b= b || joueurs[j].supprimerMotListe(listeComp.donnerMot(k));
	        		}
	        		if (b){
	        			joueurs[i].supprimerMotListe(listeComp.donnerMot(k));
	        		}
	        	}
	        }
	        for(int i=0; i<nb; i++){
	        	joueurs[i].calculerScore();
	        	if (joueurs[i].donnerScore()>highScore){
	        		highScore=joueurs[i].donnerScore();
	        	}
	        }
	        
	        System.out.println("La victoire revient à:");
	        if (highScore==0){
	        	System.out.println("Personne. Match nul!");
	        }
	        else{
		        for (int i=0; i<nb; i++){
		        	if (joueurs[i].donnerScore()==highScore){
		        		System.out.println(joueurs[i].donnerNom()+" avec un score de "+joueurs[i].donnerScore()+" points");
		        	}
		        }
	        }
	        System.out.println("\nMots possibles:\n"+p.donnerListe()+"\n\nMots corrects:");
	        for (int i=0; i<nb; i++){
	        	if (joueurs[i].donnerScore()==highScore){
	        		System.out.println(joueurs[i].donnerNom()+": "+joueurs[i].donnerListe());
	        	}
	        }
	        System.out.println("Voulez-vous rejouer? (O/N)");
	        String s;
	        do{
	        	s=sc.next();
	        }while ( !(s.toUpperCase().equals("N")) && !(s.toUpperCase().equals("O")) );
	        if (s.toUpperCase().equals("N")){
	        	break;
	        }
	        else{
	        	p.effacerPlateau();
	        	for(int i=0; i<nb; i++){
	        		joueurs[i].effacerJoueur();
	        	}
	        }
		}
        System.out.println("Fin de la partie.\nMerci d'avoir joué!");
        sc.close();
    }
}
