package diadia;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes)
 * @see Attrezzo
 * @version 0.1
*/

public class Stanza {
	private static final int NUMERO_MASSIMO_DIREZIONI = 4;
	private String nome;
    private Attrezzo attrezzo;
	private Stanza[] stanzeConfinanti;
	private int numeroDirezioni;
    private String[] direzioni;

    /**
     * Crea una stanza. Inizialmente non ci sono uscite.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroDirezioni = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeConfinanti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
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
	public Stanza getUscita(String direzione) {
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
     * Restituisce l'attrezzo presente nella stanza.
     * @return l'attrezzo presente nella stanza.
     * 		   null se non ci sono attrezzi.
     */
    public Attrezzo getAttrezzo() {
        return this.attrezzo;
    }

    /**
     * Colloca un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da collocare nella stanza.
     *        Impostare a null per rappresentare l'assenza
     *        di attrezzi nella stanza.
     */
    public void addAttrezzo(Attrezzo attrezzo) {
        this.attrezzo = attrezzo;
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	String s = new String();
    	s += this.nome;
    	s += "\nUscite: ";
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			s += " " + direzione;
    	if (attrezzo!=null){
        	s += "\nAttrezzi nella stanza: ";
        	s += attrezzo.toString()+" ";
        		}
    	return s;
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean attrezzoPresente;
		if (this.attrezzo.getNome().equals(nomeAttrezzo))
			attrezzoPresente = true;
		else
			attrezzoPresente = false;
		return attrezzoPresente;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if (attrezzo.getNome().equals(nomeAttrezzo))
			return attrezzo;
		else
			return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null){
			this.attrezzo = null;
			return true;
		}
		else
			return false;
	}


	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroDirezioni];
	    for(int i=0; i<this.numeroDirezioni; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }

}