package it.uniroma3.diadia.giocatore;

/**
 * Questa classe modella il giocatore della partita.
 *
 * @author  Vincenzo D'Amico
 * @see Partita
 * @version 1.0
 */

public class Giocatore {
	private String nome;
	private int cfu;
	private static int CFU_INIZIALI = 20;
	private static int ATTREZZI_MASSIMI = 10;
	public Borsa borsa;

	public Giocatore(){
		this.borsa = new Borsa(ATTREZZI_MASSIMI);
		this.cfu = CFU_INIZIALI;
		this.nome = "Enzuccio";
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " Giocatore : " + nome + " \n CFU = " + cfu + " \n " + borsa;
	}
	
	
}