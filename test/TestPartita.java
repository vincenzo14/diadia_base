package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


public class TestPartita {

	private Partita partita = new Partita();
	private Stanza atrio = new Stanza("Atrio");

	@Before
	public void setUp() {

		this.partita.labirinto.setStanzaDiIngresso(atrio);
	}

	/**	TEST SULLA PARTITA */

	@Test
	public void testCFU() {
		assertEquals(20, this.partita.giocatore.getCfu());
	}
	
	@Test
	public void testCFUTerminati() {
		this.partita.giocatore.setCfu(0);
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testStanzaDiIngresso() {
		assertEquals(atrio, this.partita.labirinto.getStanzaDiIngresso());
	}
}
