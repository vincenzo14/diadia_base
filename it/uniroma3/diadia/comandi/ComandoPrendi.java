package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;

	/**
	 * Comando "Prendi"
	 * 
	 * PRENDE l'Attrezzo, passato come parametro, dalla 
	 * Stanza per inserirlo nella Borsa del Giocatore
	 *
	 */

	public void esegui(Partita partita) {
		if (!partita.labirinto.getStanzaDiIngresso().isEmpty()){
			if (nomeAttrezzo==null) {
				System.out.println("Che attrezzo vuoi prendere? Devi specificare il nome di un Attrezzo");
				System.out.println("Attrezzi presenti nella Stanza " + partita.labirinto.getStanzaDiIngresso().getNome() + ": ");
				System.out.print(partita.labirinto.getStanzaDiIngresso().toStringAttrezziStanza());
				return;
			}
			if (partita.labirinto.getStanzaDiIngresso().hasAttrezzo(nomeAttrezzo))
				if (partita.giocatore.borsa.addAttrezzo(partita.labirinto.getStanzaDiIngresso().getAttrezzo(nomeAttrezzo))){
					partita.labirinto.getStanzaDiIngresso().removeAttrezzo(nomeAttrezzo);
					System.out.println("Hai preso l'Attrezzo: "+ nomeAttrezzo);

				} else System.out.println("Borsa troppo Pesante \nLiberati di Attrezzi per alleggerila");

			else System.out.println("Attrezzo non presente nella Stanza");

			System.out.println(partita.labirinto.getStanzaDiIngresso().getDescrizione());	 
			System.out.println(partita.giocatore.borsa.toString());

		} else System.out.println("Stanza Vuota");
	}

	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}
	
	public String getNome() {
		return ("prendi");
		
	}

	public String getParametro() {
		return this.nomeAttrezzo;		
	}

}
