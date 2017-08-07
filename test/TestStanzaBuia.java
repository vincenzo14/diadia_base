package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {

	private Stanza mensa = new StanzaBuia("Mensa", "Lume");
	private Attrezzo lume = new Attrezzo("Lume", 1);

	@Test
	public void testStanzaBuiaSenzaStrumentoIlluminante() {
		assertEquals("Qui c'è buio pesto", mensa.getDescrizione());
	}
	
	@Test
	public void testStanzaBuiaConStrumentoIlluminante() {
		Stanza stanzaDiControllo = new Stanza("Mensa");
		mensa.addAttrezzo(lume);
		stanzaDiControllo.addAttrezzo(lume);
		assertTrue(mensa.hasAttrezzo("Lume"));
		assertEquals(stanzaDiControllo.getDescrizione(), mensa.getDescrizione());
	}
	
	@Test
	public void testStanzaBuiaConStrumentoNONIlluminante() {
		Attrezzo chiaveInglese = new Attrezzo("Chiave-Ingelse", 3);
		mensa.addAttrezzo(chiaveInglese);
		assertTrue(mensa.hasAttrezzo("Chiave-Ingelse"));
		assertEquals("Qui c'è buio pesto", mensa.getDescrizione());
	}

}
