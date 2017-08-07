package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaMagicaProtected - una stanza in un gioco di ruolo.
 * 
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * Uguale alla stanzaMagica solo con le variabili non private
 * 
 * @author Vincenzo D'Amico
 * @see Attrezzo
 * @version 1.0
 */

public class StanzaMagicaProtected extends StanzaProtected{

	final static private int SOGLIA_MAGICA_DEFAULT = 3; 
	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);		
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;		
	}

	/**
	 * Modifica magicamente un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da modificare e aggiungere nella stanza.
	 *        Impostare a null per rappresentare l'assenza
	 *        di attrezzi nella stanza.
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo){
		int pesoX2 = attrezzo.getPeso()*2;
		StringBuilder nomeDaInvertire = new StringBuilder(attrezzo.getNome());
		String nomeInvertito = nomeDaInvertire.reverse().toString();
		attrezzo = new Attrezzo(nomeInvertito, pesoX2);
		return attrezzo;
	}

	/**
	 * Colloca un attrezzo modificato magicamente nella stanza.
	 * @param attrezzo l'attrezzo da collocare nella stanza.
	 *        Impostare a null per rappresentare l'assenza
	 *        di attrezzi nella stanza.
	 */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}

	/**
	 * @return the contatoreAttrezziPosati
	 */
	@Override
	public int getContatoreAttrezziPosati() {
		return contatoreAttrezziPosati;
	}

	/**
	 * @param contatoreAttrezziPosati the contatoreAttrezziPosati to set
	 */
	public void setContatoreAttrezziPosati(int contatoreAttrezziPosati) {
		this.contatoreAttrezziPosati = contatoreAttrezziPosati;
	}

	/**
	 * @return the sogliaMagica
	 */
	@Override
	public int getSogliaMagica() {
		return sogliaMagica;
	}

	/**
	 * @param sogliaMagica the sogliaMagica to set
	 */
	public void setSogliaMagica(int sogliaMagica) {
		this.sogliaMagica = sogliaMagica;
	}

	/**
	 * @return the sogliaMagicaDefault
	 */
	public static int getSogliaMagicaDefault() {
		return SOGLIA_MAGICA_DEFAULT;
	}
}