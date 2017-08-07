package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa interface modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  Vincenzo D'Amico  *
 * @version 1.0
 */

public interface Comando {
    
	/** Esecuzione del Comando */
	
	public void esegui(Partita partita);
	
	public void setParametro (String parametro);
	
	public String getNome();
	
	public String getParametro();
	
}