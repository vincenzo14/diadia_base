package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.personaggi.Mago;

public class TestComandoSaluta {

	FabbricaDiComandiFisarmonica fdcf = new FabbricaDiComandiFisarmonica();
	Attrezzo attrezzo = new Attrezzo("Attrezzo", 3);
	Mago mago = new Mago("Mago", "descrizone del mago per uso di TEST", attrezzo);

	@Test
	public void testSalutoAlMagoCheCambiaUnaVoltaSalutato() {
		assertNotEquals(mago.saluta(), mago.saluta());
		assertEquals(mago.saluta(), mago.saluta());
	}

	@Test
	public void testSalutoAlMagoCheCambiaUnaVoltaSalutato_true_false() {
		assertFalse(mago.isHaSalutato());
		mago.saluta();
		assertTrue(mago.isHaSalutato());
	}

	@Test
	public void testSalutoAlMagoInUnaPartita() {
		Partita p = new Partita();
		Stanza stanzaDelMago = new Stanza("Stanza del Mago");
		p.labirinto.setStanzaDiIngresso(stanzaDelMago);
		stanzaDelMago.aggiungiPersonaggio(mago);
		assertFalse(mago.isHaSalutato());
		mago.saluta();
		assertTrue(mago.isHaSalutato());
	}
}
