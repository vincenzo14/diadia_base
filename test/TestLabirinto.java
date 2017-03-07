package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


public class TestLabirinto {

	private Labirinto labirinto = new Labirinto();
	private Stanza biblioteca = new Stanza("Biblioteca");
	private Stanza laboratorio = new Stanza("Laboratorio Campus");
	
	@Before
	public void setUp() {
		this.labirinto.setStanzaDiIngresso(biblioteca);
		}

	//	TEST LABIRINTO

	@Test
	public void testStanzaDiIngresso() {
		assertEquals(biblioteca, this.labirinto.getStanzaDiIngresso());
	}

	@Test
	public void testNonConcidenti() {
		assertFalse(this.labirinto.coincidenti());
	}
	
}
