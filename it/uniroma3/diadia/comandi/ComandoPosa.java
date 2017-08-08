package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;

	/**
	 * Comando "Posa".
	 *
	 * Rimuove l'Attrezzo passato come parametro dalla 
	 * Borsa del Giocatore per POSARLO nella Stanza
	 *
	 */

	public void esegui(Partita partita) {
		if (!partita.giocatore.borsa.isEmpty()){
			if (nomeAttrezzo==null) {
				System.err.println("Che attrezzo vuoi posare? Devi specificare il nome di un Attrezzo");
				System.out.println(partita.giocatore.borsa.toString());
				return;
			}
			if (partita.giocatore.borsa.hasAttrezzo(nomeAttrezzo)){
				Attrezzo a = partita.giocatore.borsa.removeAttrezzo(nomeAttrezzo);
				partita.labirinto.getStanzaDiIngresso().addAttrezzo(a);
				System.out.println("Hai posato l'Attrezzo: " + a.getNome() + " Peso: "+ a.getPeso()+" Kg");

			} else System.err.println("Attrezzo non presente nella Borsa");

			System.out.println(partita.labirinto.getStanzaDiIngresso().getDescrizione());	
			System.out.println(partita.giocatore.borsa.toString());

		} else System.err.println("Borsa Vuota");
	}

	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}
	
	public String getNome() {
		return ("posa");
		
	}

	public String getParametro() {
		return this.nomeAttrezzo;		
	}

}
