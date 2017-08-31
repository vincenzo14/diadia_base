package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.direzioni.DirezioneDiComando;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String parametro = null;
		String nomeComando = null;
		DirezioneDiComando d = new DirezioneDiComando();
		Comando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando

		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro

		try {
			String nomeClasse = "it.uniroma3.diadia.comandi.Comando";
			nomeClasse += ( Character.toUpperCase(nomeComando.charAt(0)));
			nomeClasse += ( nomeComando.substring(1));
			comando = (Comando)Class.forName(nomeClasse.toString()).newInstance();
			comando.setParametro(parametro);
			comando.setDirezione(d.OttieniDirezione(parametro));
		} catch (Exception e) {
			comando = new ComandoNonValido();
		}
		return comando;
	}
}