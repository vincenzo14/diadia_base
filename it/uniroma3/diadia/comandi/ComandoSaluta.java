package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta implements Comando{

	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.giocatore.getNome() + ": Salve");
		if (partita.labirinto.getStanzaDiIngresso().getPersonaggio() != null)
			System.out.println(partita.labirinto.getStanzaDiIngresso().getPersonaggio().saluta());
		else System.out.println("Cri-Cri-Cri.... Nella stanza non ci sono Personaggi da Salutare");

	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return ("saluta");
	}

	@Override
	public String getParametro() {
		return null;
	}
}