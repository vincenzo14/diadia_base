package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Cane extends AbstractPersonaggio{

	private final String MESSAGGIO_MORSO = getNome() + ": Wof-Wof-Wof-GNAAAMMMHH!!!";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		partita.giocatore.setCfu(partita.giocatore.getCfu()-1);
		msg = MESSAGGIO_MORSO;
		return msg;		
	}

}
