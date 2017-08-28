package it.uniroma3.diadia.direzioni;

import static it.uniroma3.diadia.direzioni.Direzione.*;

public class DirezioneDiComando {

	private Direzione direzione;

	public DirezioneDiComando() {}

	public Direzione OttieniDirezione(String parametro) {
		if (parametro != null) {
			if (parametro.toString().equals("nord"))
				direzione = nord;
			if (parametro.toString().equals("sud"))
				direzione = sud;
			if (parametro.toString().equals("ovest"))
				direzione = ovest;
			if (parametro.toString().equals("est"))
				direzione = est;
		}
		return direzione;
	}

}
