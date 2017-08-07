package it.uniroma3.diadia.attrezzi;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author Vincenzo D'Amico
 * @see Stanza
 * @version 1.0
 *
 */
public class Attrezzo {
	private String nome;
	private StringBuilder nomeInvertito;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	public Attrezzo(StringBuilder nomeInvertito, int pesoX2) {
		this.peso = pesoX2;
		this.nomeInvertito = nomeInvertito;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}
	
	/**
	 * Restituisce il nome invertito dell'attrezzo
	 * @return il nome invertito dell'attrezzo
	 */
	public StringBuilder getNomeInvertito() {
		return nomeInvertito;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";

	}

}