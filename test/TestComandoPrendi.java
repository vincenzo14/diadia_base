package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class TestComandoPrendi {

	private FabbricaDiComandi fabbrica = new FabbricaDiComandiFisarmonica();

	Comando comandoPrendiPrimoAttrezzo = fabbrica.costruisciComando("prendi osso");
	Attrezzo osso = new Attrezzo("osso",1);

	@Test
	public void testNomeComandoPrendiPrimoAttrezzo() {
		assertEquals(("prendi"), comandoPrendiPrimoAttrezzo.getNome());
	}

	@Test
	public void testNomeParametroPrendiPrimoAttrezzo() {
		assertEquals(osso.getNome(), comandoPrendiPrimoAttrezzo.getParametro());
	}

	@Test
	public void testFunzionamentoComandoPrendiPrimoAttrezzoNellaStanza() {
		Partita partita = new Partita();
		Stanza mensa = new StanzaMagica("mensa");
		partita.labirinto.setStanzaDiIngresso(mensa);
		mensa.addAttrezzo(osso);		
		assertTrue(!mensa.isEmpty());
		assertTrue(partita.giocatore.borsa.isEmpty());
		comandoPrendiPrimoAttrezzo.esegui(partita);
		assertTrue(mensa.isEmpty());
		assertTrue(!partita.giocatore.borsa.isEmpty());
	}

}
