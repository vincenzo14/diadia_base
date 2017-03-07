package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;


public class TestGiocatore {
	
	private Giocatore giocatore = new Giocatore();
	private Partita partita = new Partita();
	private Attrezzo spada = new Attrezzo("Spada", 5);
	

	@Before
	public void setUp() {
		
		giocatore.borsa.addAttrezzo(spada);
		
	}

	@Test
	public void testCFUGiocatore() {
		assertEquals(20, this.giocatore.getCfu());
	}

	@Test
	public void testCFUTerminati() {
		this.partita.giocatore.setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testBorsaGiocatoreVuota() {
		assertFalse(this.giocatore.borsa.isEmpty());
	}
}
