package application;

public class D� {
	private String faces;
	private char lettre;

//============================================================================================================	

	public D�(){
		lettre=' ';
		faces="";
	}

//============================================================================================================	
	
	public D�(String l){
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
