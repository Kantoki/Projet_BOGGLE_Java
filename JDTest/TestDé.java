package JDTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import application.Dé;

public class TestDé {

	@Test
	public void test() {
		Dé d = new Dé("abcde");
		assertTrue(d.donnerLettre()=='A');
		d.rouler();
		assertTrue(d.donnerLettre()>='A' && d.donnerLettre()<='E');
	}

}
