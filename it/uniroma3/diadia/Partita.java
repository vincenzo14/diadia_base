package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Vincenzo D'Amico
 * @see Stanza
 * @version 1.0
 */

public class Partita {
	private boolean finita;
	public Labirinto labirinto;
	public Giocatore giocatore;
		
	public Partita(){
		
		this.giocatore = new Giocatore();
		this.labirinto = new Labirinto();
		this.finita = false;
		}

   	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.coincidenti();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	/**
	 * @return the labirinto
	 */
	public Labirinto getLabirinto() {
		return labirinto;
	}

	/**
	 * @param labirinto the labirinto to set
	 */
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	/**
	 * @return the giocatore
	 */
	public Giocatore getGiocatore() {
		return giocatore;
	}

	/**
	 * @param giocatore the giocatore to set
	 */
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public boolean giocatoreIsVivo() {
		boolean vivo = true;
		if (this.giocatore.getCfu()==0)
		vivo = false;
		
		return vivo;
	}
	
	
	
}
