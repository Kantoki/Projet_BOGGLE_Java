package JDTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import application.Joueur;

public class TestJoueurs {

	@Test
	public void test() {
		Joueur j = new Joueur("Squalala");
		assertTrue(j.donnerNom().equals("Squalala"));
		assertTrue(j.donnerScore()==0);
		assertTrue(j.listeEstVide());
		j.modifierScore(10);
		assertTrue(j.donnerScore()==10);
		j.ajouterMotListe("plop");
		j.calculerScore();
		assertTrue(j.donnerScore()==1);
	}
}
