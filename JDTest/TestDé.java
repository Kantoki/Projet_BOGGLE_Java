package JDTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import application.D�;

public class TestD� {

	@Test
	public void test() {
		D� d = new D�("abcde");
		assertTrue(d.donnerLettre()=='A');
		d.rouler();
		assertTrue(d.donnerLettre()>='A' && d.donnerLettre()<='E');
	}

}
