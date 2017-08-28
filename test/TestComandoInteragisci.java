package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;
import static it.uniroma3.diadia.direzioni.Direzione.*;

public class TestComandoInteragisci {

	Attrezzo attrezzo = new Attrezzo("Attrezzo", 3);
	Attrezzo attrezzo1 = new Attrezzo("Attrezzo1", 1);
	Attrezzo attrezzo2 = new Attrezzo("Attrezzo2", 2);
	Attrezzo attrezzo3 = new Attrezzo("Attrezzo3", 3);
	Attrezzo attrezzo4 = new Attrezzo("Attrezzo4", 2);
	Mago mago = new Mago("Mago", "descrizone del Mago per uso di TEST", attrezzo);
	Strega strega = new Strega("Strega", "descrizone della Strega per uso di TEST");
	Cane cane = new Cane("Cane", "descrizone del Cane per uso di TEST");
	Stanza stanzaDelMago = new Stanza("Stanza del Mago");
	Stanza stanzaDellaStrega = new Stanza("Stanza della Strega");
	Stanza stanzaDelCane = new Stanza("Stanza del Cane");

	@Before
	public void setUp() {
		stanzaDellaStrega.impostaUscita(nord, stanzaDelMago);
		stanzaDellaStrega.impostaUscita(sud, stanzaDelCane);
		stanzaDellaStrega.aggiungiPersonaggio(strega);
		stanzaDelMago.aggiungiPersonaggio(mago);
		stanzaDelCane.aggiungiPersonaggio(cane);
		stanzaDelCane.addAttrezzo(attrezzo1);
		stanzaDelCane.addAttrezzo(attrezzo2);
		stanzaDelCane.addAttrezzo(attrezzo3);
		stanzaDelCane.addAttrezzo(attrezzo4);
		
	}

	@Test
	public void testCambioStasnzaDopoInterazioneConLaStregaSenzaSaluto() {
		Partita partita = new Partita();		
		partita.labirinto.setStanzaDiIngresso(stanzaDellaStrega);		
		strega.agisci(partita);
		assertEquals(partita.labirinto.getStanzaDiIngresso(), stanzaDelMago);
	}

	@Test
	public void testAttrezzoPosatoNellaStanzaDopoInterazioneConIlMago() {
		Partita partita = new Partita();
		partita.labirinto.setStanzaDiIngresso(stanzaDelMago);
		assertTrue(stanzaDelMago.isEmpty());
		mago.agisci(partita);
		assertNull(mago.getAttrezzo());	
		assertFalse(stanzaDelMago.isEmpty());
		assertTrue(stanzaDelMago.hasAttrezzo("Attrezzo"));
	}
	
	@Test
	public void testSottrazioneCFUDopoInterazioneConIlCane() {
		Partita partita = new Partita();
		partita.labirinto.setStanzaDiIngresso(stanzaDelCane);		
		cane.agisci(partita);
		assertEquals(partita.giocatore.getCfu(), 19);
	}

}
