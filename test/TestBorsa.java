package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;


public class TestBorsa {

	private Borsa borsa = new Borsa(10);
	private Attrezzo scudo = new Attrezzo("Scudo", 2);
	private Attrezzo freccia = new Attrezzo("Freccia", 1);
	private Attrezzo spada = new Attrezzo("Spada", 1);
	private Attrezzo albicocca = new Attrezzo("Albicocca", 1);
	private Attrezzo piombo = new Attrezzo("Piombo", 4);
	private Attrezzo rete = new Attrezzo("Rete", 0);
	private Attrezzo piuma = new Attrezzo("Piuma", 0);
	private Attrezzo polvere = new Attrezzo("Polvere", 0);

	@Before
	public void setUp() {
		borsa.addAttrezzo(freccia);
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
		assertEquals(scudo.getPeso()+freccia.getPeso(), this.borsa.getPeso());
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
	public void testOrdineAttrezziNellaBorsaPerPeso() {
		borsa.addAttrezzo(albicocca);
		borsa.addAttrezzo(piombo);
		borsa.addAttrezzo(freccia);
		borsa.addAttrezzo(rete);
		System.out.println("\nContenuto Borsa ordinato per PESO: ");
		System.out.println(borsa.getContentutoPerPeso());
	}

	@Test
	public void testOrdineAttrezziNellaBorsaPerNome() {
		borsa.addAttrezzo(rete);
		borsa.addAttrezzo(piombo);
		borsa.addAttrezzo(albicocca);
		borsa.addAttrezzo(freccia);
		System.out.println("\nContenuto Borsa ordinato per NOME: ");
		System.out.println(borsa.getContenutoOrdinatoPerNome());
	}

	@Test
	public void testOrdineAttrezziNellaBorsaPerSogliaDiPeso() {
		borsa.addAttrezzo(rete);
		borsa.addAttrezzo(piombo);
		borsa.addAttrezzo(albicocca);
		borsa.addAttrezzo(freccia);
		System.out.println("\nContenuto Borsa raggruppato secondo il PESO: ");
		System.out.println(borsa.getContenutoRaggruppatoPerPeso());
	}

	@Test
	public void testOrdineAttrezziNellaBorsaPerPesoSenzaDoppioni() {
		borsa.addAttrezzo(rete);
		borsa.addAttrezzo(piombo);
		borsa.addAttrezzo(albicocca);
		borsa.addAttrezzo(freccia);
		borsa.addAttrezzo(piombo);
		borsa.addAttrezzo(rete);
		borsa.addAttrezzo(polvere);
		borsa.addAttrezzo(piuma);
		System.out.println("\nContenuto Borsa senza doppioni secondo il PESO: ");
		System.out.println(borsa.getSortedSetOrdinatoPerPeso());
	}

}
