package JDTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Test;

import application.Plateau;

public class TestPlateau {

	@Test
	public void test() {
		Plateau p = new Plateau();
		String[] s = new String[16];
		for (int i = 0; i<16; i++){
			s[i]=String.valueOf((char)(i+'A'));
		}
		p = new Plateau(s);

		assertTrue(p.listeEstVide());
		assertTrue(p.recherche("AFIN"));
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
		assertFalse(p.listeEstVide());
		assertTrue(p.listeContient("AFIN"));
		p.effacerPlateau();
		assertTrue(p.listeEstVide());
	}

}
