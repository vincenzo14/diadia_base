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
	 * @return stanza vicina con più attrezzi 
	 */

	public Stanza trovaStanzaConPiùAttrezzi(Partita partita) {
		Stanza stanzaAdiacenteConPiùAttrezzi = new Stanza("tmp");
		for (Stanza stanzaAdiacente : partita.labirinto.getStanzaDiIngresso().getStanzeAdiacenti().values()) 
			stanzaAdiacenteConPiùAttrezzi = stanzaAdiacente;

		for (Stanza stanzaAdiacente : partita.labirinto.getStanzaDiIngresso().getStanzeAdiacenti().values()) {
			if (stanzaAdiacente.getAttrezzi().size() >= stanzaAdiacenteConPiùAttrezzi.getAttrezzi().size())
				stanzaAdiacenteConPiùAttrezzi = stanzaAdiacente;
		}
		return stanzaAdiacenteConPiùAttrezzi;
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
			System.out.println(this.getNome()+ ": Dato che non sei stato cortese con me Userò la mia magia per Ostacolarti");
		} else {
			partita.labirinto.setStanzaDiIngresso(trovaStanzaConPiùAttrezzi(partita));
			stanzaDiArrivo = partita.labirinto.getStanzaDiIngresso().toString();
			System.out.println(this.getNome()+ ": Dato che sei stato molto cortese con me Userò la mia magia per Aiutarti");
		}
		return stanzaDiArrivo;
	}

}
