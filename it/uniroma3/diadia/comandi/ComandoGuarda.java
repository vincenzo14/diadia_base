package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.direzioni.Direzione;

public class ComandoGuarda implements Comando {

	/**
	 * Comando "Guarda".
	 *
	 * Stampa le informazioni sulla Stanza corrente
	 * e sullo stato della Partita
	 * 
	 */

	private String borsaOrdinata;

	public void esegui(Partita partita) {
		if (borsaOrdinata==null){
			System.out.println(partita.labirinto.getStanzaDiIngresso().getDescrizione());
			System.out.println(partita.getGiocatore().toString());
		}
		else if (partita.giocatore.borsa.isEmpty()) {
			System.out.println("Borsa Vuota");
		}
		else if (borsaOrdinata.equals("borsaPerNome")) {
			System.out.println(partita.getGiocatore().borsa.getContenutoOrdinatoPerNome());
		}
		else if (borsaOrdinata.equals("borsaPerPeso")) {
			System.out.println(partita.getGiocatore().borsa.getContentutoPerPeso());
		}
		else if (borsaOrdinata.equals("borsaPerSogliaPeso")) {
			System.out.println(partita.getGiocatore().borsa.getContenutoRaggruppatoPerPeso());
		}


	}

	public void setParametro(String parametro) {
		this.borsaOrdinata = parametro;
	}

	public String getNome() {
		return ("guarda");

	}

	public String getParametro() {
		return this.borsaOrdinata;		
	}
	@Override
	public void setDirezione(Direzione parametro) {		
	}

}
