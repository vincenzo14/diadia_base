package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBuia - una stanza in un gioco di ruolo.
 * 
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * Nella Stanza Buia se al suo interno non è presente 
 * un Attrezzo che illumina (es. Lanterna) non si potrà
 * guardare al suo interno
 * 
 * @author Vincenzo D'Amico
 * @see Attrezzo
 * @version 1.0
 */

public class StanzaBuia extends Stanza{
	
	private String attrezzoPerIllumunare;
	
	public StanzaBuia(String nome) {
		super(nome);
	}
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoPerIllumunare = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		String messaggio;
		if (this.hasAttrezzo(attrezzoPerIllumunare)){
			messaggio =  this.toString();
		} else messaggio = ("Qui c'è buio pesto");	
		return messaggio;
	}

	/**
	 * @return the attrezzoPerIllumunare
	 */
	public String getAttrezzoPerIllumunare() {
		return attrezzoPerIllumunare;
	}

	/**
	 * @param attrezzoPerIllumunare the attrezzoPerIllumunare to set
	 */
	public void setAttrezzoPerIllumunare(String attrezzoPerIllumunare) {
		this.attrezzoPerIllumunare = attrezzoPerIllumunare;
	}	

}
