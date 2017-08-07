package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBloccata - una stanza in un gioco di ruolo.
 * 
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * Nella Stanza Bloccata se al suo interno non � presente 
 * un Attrezzo che permette di aprire la porta nella direzione
 * indicate non si potr� accedere alla stanza successiva
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
		Stanza stanza = this;
		for(int i=0; i<this.getNumeroDirezioni(); i++) {
			if (this.getDirezioni()[i].equals(direzione))
				if (!this.getDirezioni()[i].equals(this.direzione)) {
					stanza = this.getStanzeConfinanti()[i];
				}
				else if (this.hasAttrezzo(attrezzoAprente)) {
					if (this.getDirezioni()[i].equals(direzione))
						stanza = this.getStanzeConfinanti()[i];
				}
		}
		if (direzione.equals(this.direzione) && (!this.hasAttrezzo(attrezzoAprente))) 
			System.out.println("La Stanza " + stanza.getNome() + " � Bloccata a " + this.direzione.toUpperCase() + "! \nCerca un Attrezzo per Aprirla"); 

		return stanza;
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
		s.append("\nContenuto Stanza ("+getNumeroAttrezzi()+" / 10) Attrezzi");
		s.append("\nUscite: ");
		for (String direzione : getDirezioni()){
			if (direzione!=null)
				s.append(" " + direzione);
		}
		if (this.hasAttrezzo(attrezzoAprente))
			s.append("\nLa stanza a " + direzione + " � Sbloccata");
		else if (direzione.equals(this.direzione))
			s.append("\nLa stanza a " + direzione + " � Bloccata");
		if (!this.isEmpty()) {
			s.append("\nAttrezzi nella Stanza: ");
			for (int i= 0; i<getNumeroAttrezzi(); i++)
				s.append("\n" + getAttrezzi()[i].toString()+" ");
		}
		else
			s.append("\nNessun Attrezzo nella Stanza");
		return s.toString();
	}


}