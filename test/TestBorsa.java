package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;


public class TestBorsa {

	private Borsa borsa = new Borsa(10);
	private Attrezzo scudo = new Attrezzo("Scudo", 2);
	private Attrezzo lancia = new Attrezzo("Lancia", 4);
	private Attrezzo spada = new Attrezzo("Spada", 3);

	@Before
	public void setUp() {
		borsa.addAttrezzo(lancia);
		borsa.addAttrezzo(scudo);
	}

	/** TEST BORSA */
	
	@Test
	public void testPesoMassimoBorsa() {
		assertEquals(10, this.borsa.getPesoMax());
	}

	@Test
	public void testRimuoviAttrezzoDallaBorsa() {
		this.borsa.removeAttrezzo("Scudo");
		assertFalse(this.borsa.hasAttrezzo("Scudo"));
	}
	
	@Test
	public void testAggiungiAttrezzoNellaBorsa() {
		borsa.addAttrezzo(spada);
		assertTrue(this.borsa.hasAttrezzo("Spada"));
	}
	
	@Test
	public void testCercaAttrezzoNellaBorsaPerNome() {
		assertEquals(scudo, this.borsa.getAttrezzo("Scudo"));
	}

	@Test
	public void testPesoAttrezziNellaBorsa() {
		assertEquals(scudo.getPeso()+lancia.getPeso(), this.borsa.getPeso());
	}

	@Test
	public void testBorsaVuota() {
		assertFalse(this.borsa.isEmpty());
	}

	@Test
	public void testEsistenzaAttrezzoNellaBorsa() {
		assertTrue(this.borsa.hasAttrezzo("Scudo"));
	}
}
