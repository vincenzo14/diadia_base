package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static it.uniroma3.diadia.direzioni.Direzione.*;

public class TestStanzaBloccata {

	private Stanza mensa = new StanzaBloccata("Mensa", nord, "Chiave");
	private Attrezzo chiave = new Attrezzo("Chiave", 1);
	private Stanza stanzaAdiacente = new Stanza("Aula");

	@Before
	public void setUp() {
		mensa.impostaUscita(nord, stanzaAdiacente);
		stanzaAdiacente.impostaUscita(sud, mensa);
	}

	@Test
	public void testStanzaBloccataSenzaStrumentoAprente() {
		assertNotEquals(stanzaAdiacente.getDescrizione(), (mensa.getStanzaAdiacente(nord).getDescrizione()));
	}

	@Test
	public void testStanzaBloccatConStrumentoAprente() {
		mensa.addAttrezzo(chiave);
		assertEquals(stanzaAdiacente.getDescrizione(), (mensa.getStanzaAdiacente(nord).getDescrizione()));
	}

	@Test
	public void testStanzaBloccatConStrumentoNONAprente() {
		Attrezzo chiaveInglese = new Attrezzo("Chiave-Ingelse", 3);
		mensa.addAttrezzo(chiaveInglese);
		assertTrue(mensa.hasAttrezzo("Chiave-Ingelse"));
		assertEquals(mensa.getDescrizione(), (mensa.getStanzaAdiacente(nord).getDescrizione()));
	}

}
