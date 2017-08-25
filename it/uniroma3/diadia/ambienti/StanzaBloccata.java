package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBloccata - una stanza in un gioco di ruolo.
 * 
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * Nella Stanza Bloccata se al suo interno non è presente 
 * un Attrezzo che permette di aprire la porta nella direzione
 * indicate non si potrà accedere alla stanza successiva
 * 
 * @author Vincenzo D'Amico
 * @see Attrezzo
 * @version 1.0
 */

public class StanzaBloccata extends Stanza{

	private String direzione;
	private String attrezzoAprente;

	public StanzaBloccata(String nome) {
		super(nome);
	}

	public StanzaBloccata(String nome, String direzione, String attrezzoAprente) {
		super(nome);
		this.direzione = direzione;
		this.attrezzoAprente = attrezzoAprente;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (this.direzione.equals(direzione)) {
			if (this.hasAttrezzo(attrezzoAprente)) {
				return this.getStanzeAdiacenti().get(direzione);
			} else {System.out.println("La Stanza  è Bloccata a " 
					+ this.direzione.toUpperCase() 
					+ "! \nCerca un Attrezzo per Aprirla");
			return this;
			}
		}
		return this.getStanzeAdiacenti().get(direzione);
	}

	/**
	 * @return the direzione
	 */
	public String getDirezione() {
		return direzione;
	}

	/**
	 * @param direzione the direzione to set
	 */
	public void setDirezione(String direzione) {
		this.direzione = direzione;
	}

	/**
	 * @return the attrezzoAprente
	 */
	public String getAttrezzoAprente() {
		return attrezzoAprente;
	}

	/**
	 * @param attrezzoAprente the attrezzoAprente to set
	 */
	public void setAttrezzoAprente(String attrezzoAprente) {
		this.attrezzoAprente = attrezzoAprente;
	}

	@Override
	public String getDescrizione() {
		StringBuilder s = new StringBuilder();
		s.append(this.getNome());
		s.append("\nContenuto Stanza ("+this.getAttrezzi().size()+" / 10) Attrezzi");
		s.append("\nUscite: ");
		for (String direzione : getDirezioni()){
			if (direzione!=null)
				s.append(" " + direzione);
		}
		if (this.hasAttrezzo(attrezzoAprente))
			s.append("\nLa stanza a " + direzione + " è Sbloccata");
		else if (direzione.equals(this.direzione))
			s.append("\nLa stanza a " + direzione + " è Bloccata");
		if (!this.isEmpty()) {
			s.append("\nAttrezzi nella Stanza: ");
			for (Attrezzo a : this.getAttrezzi())
				s.append("\n " + a.toString()+" ");
		}
		else
			s.append("\nNessun Attrezzo nella Stanza");
		return s.toString();
	}


}
