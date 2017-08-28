package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe StanzaProtected - una stanza in un gioco di ruolo.
 * 
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * Identica alla classe Stanza ma con le variabili protette anzichè private
 * 
 * @author Vincenzo D'Amico
 * @see Attrezzo
 * @version 1.0
 */

public class StanzaProtected {
	
	private static final int NUMERO_MASSIMO_DIREZIONI = 4;
	private String nome;
	protected Attrezzo[] attrezzi;
	protected int numeroAttrezzi;
	protected Stanza[] stanzeConfinanti;
	protected int numeroDirezioni;
	protected String[] direzioni;
	
	private AbstractPersonaggio personaggio;
	
		/**
		 * Crea una stanza. Inizialmente non ci sono uscite.
		 * @param nome il nome della stanza
		 */
		public StanzaProtected(String nome) {
			this.nome = nome;
			this.numeroDirezioni = 0;
			this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
			this.stanzeConfinanti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
			this.attrezzi = new Attrezzo[10];
			this.numeroAttrezzi = 0;
		}

		/**
		 * Imposta le uscite della stanza. Ogni direzione porta ad un'altra stanza.
		 *
		 * @param direzione direzione in cui sara' posta la stanza.
		 * @param stanza stanza da collegare alla stanza corrente tramite l'uscita
		 * indicata in direzione.
		 */
		public void impostaUscita(String direzione, Stanza stanza) {
			boolean aggiornato = false;
			for(int i=0; i<this.direzioni.length; i++)
				if (direzione.equals(this.direzioni[i])) {
					this.stanzeConfinanti[i] = stanza;
					aggiornato = true;
				}
			if (!aggiornato)
				if (this.numeroDirezioni < NUMERO_MASSIMO_DIREZIONI) {
					this.direzioni[numeroDirezioni] = direzione;
					this.stanzeConfinanti[numeroDirezioni] = stanza;
					this.numeroDirezioni++;
				}
		}

		/**
		 * Restituisce la stanza dell'uscita specificata
		 * @param direzione
		 */
		public Stanza getStanzaAdiacente(String direzione) {
			Stanza stanza = null;
			for(int i=0; i<this.numeroDirezioni; i++)
				if (this.direzioni[i].equals(direzione))
					stanza = this.stanzeConfinanti[i];
			return stanza;
		}

		/**
		 * Restituisce la nome della stanza.
		 * @return il nome della stanza
		 */
		public String getNome() {
			return this.nome;
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
			for (int i= 0; i<this.numeroAttrezzi; i++)
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];
			return a;
		}

		/**
		 * Verifica se la stanza non ha attrezzi al suo interno.
		 * @return true se la stanza è vuota.
		 */

		public boolean isEmpty() {
			return this.numeroAttrezzi == 0 || this.attrezzi == null;
		}

		/**
		 * Colloca un attrezzo nella stanza.
		 * @param attrezzo l'attrezzo da collocare nella stanza.
		 *        Impostare a null per rappresentare l'assenza
		 *        di attrezzi nella stanza.
		 */
		public boolean addAttrezzo(Attrezzo attrezzo) {
			if (this.numeroAttrezzi==10)
				return false;
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}

		/**
		 * Restituisce una rappresentazione stringa di questa stanza,
		 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
		 * @return la rappresentazione stringa
		 */
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(this.getNome());
			s.append("\nContenuto Stanza ("+this.numeroAttrezzi+" / 10) Attrezzi");
			s.append("\nUscite: ");
			for (String direzione : this.direzioni)
				if (direzione!=null)
					s.append(" " + direzione);
			if (this.personaggio != null) 
				s.append("\nPersonaggio della stanza: " + this.personaggio.toString());
			if (!this.isEmpty()) {
				s.append("\nAttrezzi nella Stanza: ");
				for (int i= 0; i<this.numeroAttrezzi; i++)
					s.append("\n" + attrezzi[i].toString()+" ");
			}
			else
				s.append("\nNessun Attrezzo nella Stanza");
			return s.toString();
		}
		
		public String toStringAttrezziStanza() {
			StringBuilder s = new StringBuilder();
			if (!this.isEmpty()) {
				for (int i= 0; i<this.numeroAttrezzi; i++)
					s.append(attrezzi[i].toString()+"\n");
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
			boolean trovato = false;
			for (int i=0; i<this.numeroAttrezzi && !trovato; i++){
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo)){
					a = this.attrezzi[i];
					this.attrezzi[i] = this.attrezzi[numeroAttrezzi-1];
					this.attrezzi[numeroAttrezzi-1] = null; 
					this.numeroAttrezzi--;
					trovato = true;
				}
			}
			return a;
		}


		public String[] getDirezioni() {
			String[] direzioni = new String[this.numeroDirezioni];
			for(int i=0; i<this.numeroDirezioni; i++)
				direzioni[i] = this.direzioni[i];
			return direzioni;
		}

		public int getContatoreAttrezziPosati() {
			return 0;
		}

		public int getSogliaMagica() {
			return 0;
		}

	}