package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	/** 
	 * Comando "Fine"
	 *  
	 *  Azione con la quale di desidera Smettere
	 *  
	 */
	
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");
		partita.setFinita();
	}

	public void setParametro(String parametro) {
	}
	
	public String getNome() {
		return ("fine");
		
	}

	public String getParametro() {
		return null;		
	}

}
