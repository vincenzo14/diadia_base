package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{

	/**
	 * Comando "Non Valido".
	 *
	 * Se il giocatore non inserisci un comando valido
	 * facilmente reperibile dal comando aiuto viene
	 * stampato a video un messaggio di errore.
	 * 
	 */
	
	public void esegui(Partita partita) {
		System.err.println("Comando non valido! Usa il comando 'aiuto' per conoscere le possibili azioni");
	}

	public void setParametro(String parametro) {
	}
	
	public String getNome() {
		return ("nonValido");
		
	}

	public String getParametro() {
		return null;		
	}

}
