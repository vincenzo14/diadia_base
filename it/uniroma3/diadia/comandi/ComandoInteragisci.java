package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci implements Comando {

	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?...";
	private String messaggio;

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.labirinto.getStanzaDiIngresso().getPersonaggio();
		if (personaggio != null) {
			this.messaggio = personaggio.agisci(partita);
			System.out.println(this.messaggio);
			if (personaggio.getClass().getName().equals("it.uniroma3.diadia.personaggi.Cane")) {
				System.out.println(partita.giocatore.getNome() + ": AAAAAAAAAAAHHHH!!!!");
				System.out.println("(il cane ti ha appena morso levandoti 1 cfu)");
			}
		} else System.out.println(MESSAGGIO_CON_CHI);
	}

	/**
	 * @return the messaggio
	 */
	public String getMessaggio() {
		return messaggio;
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
