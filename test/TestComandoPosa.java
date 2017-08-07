package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class TestComandoPosa {

	private FabbricaDiComandi fabbrica = new FabbricaDiComandiFisarmonica();

	Comando comandoPosaPrimoAttrezzo = fabbrica.costruisciComando("posa osso");
	Attrezzo osso = new Attrezzo("osso",1);

	@Test
	public void testNomeComandoPosaPrimoAttrezzo() {
		assertEquals(("posa"), comandoPosaPrimoAttrezzo.getNome());
	}

	@Test
	public void testNomeParametroPosaPrimoAttrezzo() {
		assertEquals(osso.getNome(), comandoPosaPrimoAttrezzo.getParametro());
	}

	@Test
	public void testFunzionamentoComandoPosaPrimoAttrezzoNellaStanza() {
		Partita partita = new Partita();
		partita.giocatore.borsa.addAttrezzo(osso);
		Stanza mensa = new StanzaMagica("mensa");
		partita.labirinto.setStanzaDiIngresso(mensa);
		assertTrue(mensa.isEmpty());
		assertTrue(!partita.giocatore.borsa.isEmpty());
		comandoPosaPrimoAttrezzo.esegui(partita);
		assertTrue(!mensa.isEmpty());
		assertTrue(partita.giocatore.borsa.isEmpty());		
	}

}
