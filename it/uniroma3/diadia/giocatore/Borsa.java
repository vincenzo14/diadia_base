package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

/**
 * Questa classe modella la borsa del giocatore.
 *
 * @author  Vincenzo D'Amico
 * @see Giocatore
 * @version 1.0
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Set<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashSet<Attrezzo>();
		this.numeroAttrezzi = 0;
	}

	/**
	 * Colloca un attrezzo nella borsa se non si è raggiunto il peso massimo
	 * della borsa e se non si è superato il numero massimo di attrezzi da portare
	 * @param attrezzo l'attrezzo da collocare nella borsa.
	 */

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		numeroAttrezzi++;
		return this.attrezzi.add(attrezzo);
	}

	/**
	 * Restituisce il peso massimo della borsa.
	 * @return il peso massimo della borsa.
	 */

	public int getPesoMax() {
		return this.pesoMax;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella borsa.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella borsa.
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
	 * Restituice il peso totale degli attrezzi presenti nella borsa.
	 * @return il peso della borsa.
	 */
	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi)
			peso += a.getPeso();

		return peso;
	}

	/**
	 * Verifica se la borsa non ha attrezzi al suo interno.
	 * @return true se la borsa è vuota.
	 */

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
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
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				numeroAttrezzi--;
				return a;
			}
		}
		return null;
	}

	/**
	 * Metodo che restituisce il contenuto della borsa in un determinato ordine
	 * 
	 * @param c il comparator che serve per ordinare il contenuto della borsa
	 * @return il contenuto della borsa sottoforma di lista
	 */

	public List<Attrezzo> getContenutoPer(Comparator<Attrezzo> c) {
		List<Attrezzo> aTemp = new ArrayList<>();
		aTemp.addAll(this.attrezzi);
		Collections.sort(aTemp, c);
		return aTemp;
	}

	/**
	 * Metodo che restituisce il contenuto della borsa ordinata per peso
	 * 
	 * @return il contenuto della borsa sottoforma di lista
	 */

	public List<Attrezzo> getContentutoPerPeso(){
		ComparatoreAttrezziPerPeso cp = new ComparatoreAttrezziPerPeso();
		return this.getContenutoPer(cp);
	}

	/**
	 * Restituisce una rappresentazione lista dell'insieme
	 * degli attrezzi nella borsa ordinati per nome
	 * 
	 * @return la lista di Attrezzi Ordinata per nome  
	 */

	public List<Attrezzo> getContenutoOrdinatoPerNome() {
		ComparatoreAttrezziPerNome cn = new ComparatoreAttrezziPerNome();
		return this.getContenutoPer(cn);
	}

	/**
	 * restituisce una mappa che associa un intero (rappresentante un
	 * peso) con l’insieme (comunque non vuoto) degli attrezzi di tale
	 * peso: tutti gli attrezzi dell'insieme che figura come valore hanno lo
	 * stesso peso pari all'intero che figura come chiave
	 * 
	 * @return la mappa che associa gli Attrezzi al Peso
	 */

	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Set<Attrezzo> tmp;
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<Integer, Set<Attrezzo>>();

		for (Attrezzo a : this.attrezzi) {
			tmp = mappa.get(a.getPeso());
			if (tmp == null)
				tmp = new HashSet<Attrezzo>();
			tmp.add(a);
			mappa.put(a.getPeso(), tmp);
		}
		return mappa;
	}

	/**
	 * Restituisce l'insieme gli attrezzi nella borsa ordinati per 
	 * peso e quindi, a parità di peso, per nome
	 * 
	 * @return attrezzi nella borsa ordinati per peso
	 */

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		ComparatoreAttrezziPerPeso cp = new ComparatoreAttrezziPerPeso();
		SortedSet<Attrezzo> tmp = new TreeSet<Attrezzo>(cp);
		for (Attrezzo a : this.attrezzi) {
			tmp.add(a);
		}
		return tmp;
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
			s.append("Contenuto Borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo a : this.attrezzi)
				s.append("\n " + a.toString()+" ");
		}
		else
			s.append("Borsa Vuota");
		return s.toString();
	}
	/**
	 * @return the attrezzi
	 */
	public Set<Attrezzo> getAttrezzi() {
		return attrezzi;
	}
	/**
	 * @param attrezzi the attrezzi to set
	 */
	public void setAttrezzi(Set<Attrezzo> attrezzi) {
		this.attrezzi = attrezzi;
	}



}