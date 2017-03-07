package application;

public class Dé {
	private String faces;
	private char lettre;

//============================================================================================================	

	public Dé(){
		lettre=' ';
		faces="";
	}

//============================================================================================================	
	
	public Dé(String l){
		this();
		faces=l.toUpperCase();
		lettre=faces.charAt(0);
	}

//============================================================================================================	
	
	public void rouler(){
		lettre=faces.charAt((int)(+Math.random()*faces.length()));
	}
	
//============================================================================================================	
	
	public char donnerLettre(){
		return(lettre);
	}
}
