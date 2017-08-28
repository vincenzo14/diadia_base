package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	private static String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "saluta", "interagisci"};

	/**
	 * Comando "Aiuto".
	 *
	 * Mosrtra al Giocatore tutte le possibili azioni
	 * che si possono compiere nel Gioco
	 * 
	 */
	
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	public void setParametro(String parametro) {
		
	}

	public String getNome() {
		return ("aiuto");
		
	}

	public String getParametro() {
		return null;		
	}

}
