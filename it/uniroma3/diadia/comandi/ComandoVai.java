package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;

	/**
	 * Comando "Vai".
	 *
	 * Cerca di andare in una direzione. Se c'è una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	
	public void esegui(Partita partita) {
		Stanza stanzaDiIngresso = partita.labirinto.getStanzaDiIngresso();
		Stanza prossimaStanza = null;
		if (direzione==null) {
			System.err.println("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaDiIngresso.getStanzaAdiacente(this.direzione);
		if (prossimaStanza==null) {
			System.err.println("Direzione Errata!");
			return;
		}
		if (prossimaStanza==stanzaDiIngresso) {
			return;
		}
		partita.labirinto.setStanzaDiIngresso(prossimaStanza);
		System.out.println(partita.labirinto.getStanzaDiIngresso().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	public String getNome() {
		return ("vai");
		
	}

	public String getParametro() {
		return this.direzione;		
	}

}
