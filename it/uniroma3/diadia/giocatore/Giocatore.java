package it.uniroma3.diadia.giocatore;

/**
 * Questa classe modella il giocatore della partita.
 *
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes)
 * @see Partita
 * @version 0.1
 */

public class Giocatore {
	private int cfu;
	private static int CFU_INIZIALI = 20;
	public Borsa borsa;

	public Giocatore(){
		this.borsa = new Borsa(10);
		this.cfu = CFU_INIZIALI;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
}