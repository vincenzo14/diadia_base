package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * @author Vincenzo D'Amico
 * @see Attrezzo
 * @version 1.0
 */

public class Stanza {
	private String descrizione;
	private List<Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;

	private AbstractPersonaggio personaggio;

	/**
	 * Crea una stanza. Inizialmente non ci sono uscite.
	 * @param nome il nome della stanza
	 */
	public Stanza(String descrizione) {
		this.descrizione = descrizione;
		this.attrezzi = new ArrayList<>();
		this.stanzeAdiacenti = new HashMap<>();
	}

	/**
	 * Imposta le uscite della stanza. Ogni direzione porta ad un'altra stanza.
	 *
	 * @param direzione direzione in cui sara' posta la stanza.
	 * @param stanza stanza da collegare alla stanza corrente tramite l'uscita
	 * indicata in direzione.
	 */
	public void impostaUscita(String direzione, Stanza stanza) {
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza dell'uscita specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.descrizione;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (Attrezzo attrezzo : this.attrezzi)
			if (attrezzo.getNome().equals(nomeAttrezzo))
				a = attrezzo;
		return a;
	}

	/**
	 * Verifica se la stanza non ha attrezzi al suo interno.
	 * @return true se la stanza è vuota.
	 */

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	/**
	 * Colloca un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da collocare nella stanza.
	 *        Impostare a null per rappresentare l'assenza
	 *        di attrezzi nella stanza.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);
	}
	
	/**
	 * Colloca un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da collocare nella stanza.
	 *        Impostare a null per rappresentare l'assenza
	 *        di attrezzi nella stanza.
	 */
	public void aggiungiPersonaggio(AbstractPersonaggio personaggio) {
		this.setPersonaggio(personaggio);
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.getNome());
		s.append("\nContenuto Stanza ("+this.attrezzi.size()+" / 10) Attrezzi");
		s.append("\nUscite: ");
		for (String direzione : this.stanzeAdiacenti.keySet())
			if (direzione!=null)
				s.append(" " + direzione);
		if (this.getPersonaggio() != null) 
			s.append("\nPersonaggio della stanza: " + this.personaggio.toString());
		if (!this.isEmpty()) {
			s.append("\nAttrezzi nella Stanza: ");
			for (Attrezzo a : this.attrezzi)
				s.append("\n " + a.toString()+" ");
		}
		else
			s.append("\nNessun Attrezzo nella Stanza");
		return s.toString();
	}

	public String toStringAttrezziStanza() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			for (Attrezzo a : this.attrezzi)
				s.append("\n " + a.toString()+"\n");
		}
		return s.toString();

	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a;
			}
		}
		return null;
	}


	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}

	public int getContatoreAttrezziPosati() {
		return 0;
	}

	public int getSogliaMagica() {
		return 0;
	}

	/**
	 * @return the attrezzi
	 */
	public List<Attrezzo> getAttrezzi() {
		return attrezzi;
	}

	/**
	 * @param attrezzi the attrezzi to set
	 */
	public void setAttrezzi(List<Attrezzo> attrezzi) {
		this.attrezzi = attrezzi;
	}

	/**
	 * @return the stanzeAdiacenti
	 */
	public Map<String, Stanza> getStanzeAdiacenti() {
		return stanzeAdiacenti;
	}

	/**
	 * @param stanzeAdiacenti the stanzeAdiacenti to set
	 */
	public void setStanzeAdiacenti(Map<String, Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the personaggio
	 */
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}

	/**
	 * @param personaggio the personaggio to set
	 */
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}



}