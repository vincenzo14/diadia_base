package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella la borsa del giocatore.
 *
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes)
 * @see Giocatore
 * @version 0.1
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}

	/**
	 * Colloca un attrezzo nella borsa se non si è raggiunto il peso massimo
	 * della borsa e se non si è superato il numero massimo di attrezzi da portare
	 * @param attrezzo l'attrezzo da collocare nella borsa.
	 */

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * Restituisce il peso massimo della borsa.
	 * @return il peso massimo della borsa.
	 */
	
	public int getPesoMax() {
		return pesoMax;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella borsa.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella borsa.
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
	 * Restituice il peso totale degli attrezzi presenti nella borsa.
	 * @return il peso della borsa.
	 */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}

	/**
	 * Verifica se la borsa non ha attrezzi al suo interno.
	 * @return true se la borsa è vuota.
	 */

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0 || this.attrezzi == null;
	}

	/**
	 * Verifica tramite nome dell'attrezzo se esiste
	 * all'interno della borsa.
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo esiste.
	 */

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/**
	 * Rimuove l'attrezzo dalla borsa.
	 * @param nomeAttrezzo
	 * @return l'attrezzo appena rimosso.
	 */

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i=0; i<this.numeroAttrezzi ;i++){
			if (this.attrezzi[i]!=null){
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo)){
					a = new Attrezzo(this.attrezzi[i].getNome(), this.attrezzi[i].getPeso());
					this.attrezzi[i]=null;
					this.numeroAttrezzi--;
				}
			}
		}
		return a;
	}

	/**
	 * Restituisce una rappresentazione stringa della borsa,
	 * stampadone il contenuto, gli attrezzi e relativi pesi.
	 * 
	 * Borsa vuota se non ci sono attrezzi.
	 * 
	 * @return la rappresentazione stringa
	 */

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa: ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append("\n" + attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}