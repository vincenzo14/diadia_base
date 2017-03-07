package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;


public class TestBorsa {

	private Borsa borsa = new Borsa(10);
	private Attrezzo scudo = new Attrezzo("Scudo", 2);
	private Attrezzo lancia = new Attrezzo("Lancia", 6);
	
	@Before
	public void setUp() {
		borsa.addAttrezzo(lancia);
		borsa.addAttrezzo(scudo);
	}

	@Test
	public void testPesoMassimoBorsa() {
		assertEquals(10, this.borsa.getPesoMax());
	}
	
	@Test
	public void testCercaNomeAttrezzoNellaBorsaPerNome() {
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
	
	@Test
	public void testRimozioneAttrezzoDallaBorsa() {
		assertEquals(scudo.getNome(), this.borsa.removeAttrezzo("Scudo").getNome());
	}
}
