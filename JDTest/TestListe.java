package JDTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import application.ListeMot;

public class TestListe {

	@Test
	public void test() {
		ListeMot l = new ListeMot();
		
		assertTrue(l.estVide());
		
		l.ajouterMot("Wololo");
		l.ajouterMot("!Olà que ase?");
		
		assertTrue(l.contientMot("Wololo"));
		assertTrue(l.contientMot("OLAQUEASE"));
		assertTrue(l.contientMot("!Olà que ase?"));
		assertFalse(l.contientMot("Marin"));
		
		assertTrue(l.tailleListe()==2);
		
		assertTrue(l.donnerMot(0).equals("WOLOLO"));
		
		assertTrue(l.supprimerMot("OLAQUEASE"));
		assertFalse(l.supprimerMot("LAMA"));
		
		ListeMot m = new ListeMot(l);
		
		assertTrue(m.tailleListe()==1);
		
		l.viderListe();
		
		assertTrue(l.estVide());
	}

}
