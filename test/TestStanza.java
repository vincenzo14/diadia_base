package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import diadia.Attrezzo;
import diadia.Stanza;

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

	@Test
	public void testImpostaUscita() {
		assertEquals(aulaN11, this.aulaN10.getUscita("nord"));
	}
	
	@Test
	public void testImpostaUscitaNonNulla() {
		assertNotNull(this.aulaN1.getUscita("nord"));
	}

	@Test
	public void testImpostaUscitaNulla() {
		assertNull(this.aulaN11.getUscita("nord"));

	}
}
