package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class Strega extends AbstractPersonaggio{

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	/**
	 * Ritorna la stanza adiacente che contiene il maggior numero di attrezzi
	 * 
	 * @param partita
	 * 
	 * @return stanza vicina con pi� attrezzi 
	 */

	public Stanza trovaStanzaConPi�Attrezzi(Partita partita) {
		Stanza stanzaAdiacenteConPi�Attrezzi = new Stanza("tmp");
		for (Stanza stanzaAdiacente : partita.labirinto.getStanzaDiIngresso().getStanzeAdiacenti().values()) 
			stanzaAdiacenteConPi�Attrezzi = stanzaAdiacente;

		for (Stanza stanzaAdiacente : partita.labirinto.getStanzaDiIngresso().getStanzeAdiacenti().values()) {
			if (stanzaAdiacente.getAttrezzi().size() >= stanzaAdiacenteConPi�Attrezzi.getAttrezzi().size())
				stanzaAdiacenteConPi�Attrezzi = stanzaAdiacente;
		}
		return stanzaAdiacenteConPi�Attrezzi;
	}

	/**
	 * Ritorna la stanza adiacente che contiene il minor numero di attrezzi
	 * 
	 * @param partita
	 * 
	 * @return stanza vicina con meno attrezzi 
	 */

	public Stanza trovaStanzaConMenoAttrezzi(Partita partita) {
		Stanza stanzaAdiacenteConMenoAttrezzi = new Stanza("tmp");
		for (Stanza stanzaAdiacente : partita.labirinto.getStanzaDiIngresso().getStanzeAdiacenti().values()) 
			stanzaAdiacenteConMenoAttrezzi = stanzaAdiacente;

		for (Stanza stanzaAdiacente : partita.labirinto.getStanzaDiIngresso().getStanzeAdiacenti().values()) {
			if (stanzaAdiacente.getAttrezzi().size() <= stanzaAdiacenteConMenoAttrezzi.getAttrezzi().size())
				stanzaAdiacenteConMenoAttrezzi = stanzaAdiacente;
		}
		return stanzaAdiacenteConMenoAttrezzi;
	}

	@Override
	public String agisci(Partita partita) {
		String stanzaDiArrivo = null;
		if (!this.isHaSalutato()){
			partita.labirinto.setStanzaDiIngresso(trovaStanzaConMenoAttrezzi(partita));
			stanzaDiArrivo = partita.labirinto.getStanzaDiIngresso().toString();
			System.out.println(this.getNome()+ ": Dato che non sei stato cortese con me User� la mia magia per Ostacolarti");
		} else {
			partita.labirinto.setStanzaDiIngresso(trovaStanzaConPi�Attrezzi(partita));
			stanzaDiArrivo = partita.labirinto.getStanzaDiIngresso().toString();
			System.out.println(this.getNome()+ ": Dato che sei stato molto cortese con me User� la mia magia per Aiutarti");
		}
		return stanzaDiArrivo;
	}

}
