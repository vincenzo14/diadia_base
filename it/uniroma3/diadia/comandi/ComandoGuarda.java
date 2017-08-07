package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	/**
	 * Comando "Guarda".
	 *
	 * Stampa le informazioni sulla Stanza corrente
	 * e sullo stato della Partita
	 * 
	 */

	private String direzione;

	public void esegui(Partita partita) {
		if (direzione==null){
			System.out.println(partita.labirinto.getStanzaDiIngresso().getDescrizione());
			System.out.println(partita.getGiocatore().toString());
		}
		else System.out.println("Il comando Guarda va usato da solo senza altri Comandi");
	}

	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	public String getNome() {
		return ("guarda");
		
	}

	public String getParametro() {
		return this.direzione;		
	}

}
