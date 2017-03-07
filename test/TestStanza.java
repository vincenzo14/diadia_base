package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;



public class TestStanza {

	private Stanza aulaN1 = new Stanza("AulaN1");
	private Stanza aulaN10 = new Stanza("AulaN10");
	private Stanza aulaN11 = new Stanza("AulaN11");
	private Stanza mensa = new Stanza("Mensa");
	private Stanza ascensore = new Stanza("Ascensore");

	private Attrezzo spada = new Attrezzo("Spada", 5);
	private Attrezzo scudo = new Attrezzo("Scudo", 7);

	@Before
	public void setUp() {

		this.aulaN1.impostaUscita("nord", aulaN10);
		this.aulaN10.impostaUscita("sud", aulaN1);

		this.aulaN11.impostaUscita("sud", aulaN10);
		this.aulaN10.impostaUscita("nord", aulaN11);

		this.mensa.impostaUscita("ovest", aulaN10);
		this.aulaN10.impostaUscita("est", mensa);

		this.ascensore.impostaUscita("est", aulaN10);
		this.aulaN10.impostaUscita("ovest", ascensore);

		this.aulaN10.addAttrezzo(scudo);
		this.aulaN1.addAttrezzo(spada);

	}

	//	TEST SULLA STANZA

	@Test
	public void testUscita() {
		assertEquals(aulaN11, this.aulaN10.getUscita("nord"));
	}

	@Test
	public void testUscitaNonNulla() {
		assertNotNull(this.aulaN1.getUscita("nord"));
	}

	@Test
	public void testUscitaNulla() {
		assertNull(this.aulaN11.getUscita("nord"));

	}

	//	TEST SUGLI ATTREZZI NELLA STANZA

	@Test
	public void testAttrezzo() {
		assertEquals(spada, this.aulaN1.getAttrezzo("Spada"));
	}

	@Test
	public void testAttrezzoPerNome() {
		assertEquals(spada, this.aulaN1.getAttrezzo("Spada"));
	}

	@Test
	public void testVerificaAttrezzo() {
		assertTrue(this.aulaN10.hasAttrezzo("Scudo"));
	}

	@Test
	public void testAttrezzoNullo() {
		assertNull(this.aulaN10.getAttrezzo("Lancia"));

	}
}
