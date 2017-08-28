package it.uniroma3.diadia.comandi;

import java.util.Scanner;
import it.uniroma3.diadia.direzioni.DirezioneDiComando;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		DirezioneDiComando d = new DirezioneDiComando();
		Comando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando

		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro

		if (nomeComando==null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else if (nomeComando.equals("saluta"))
			comando = new ComandoSaluta();
		else if (nomeComando.equals("interagisci"))
			comando = new ComandoInteragisci();
		else comando = new ComandoNonValido();
		comando.setParametro(parametro);
		comando.setDirezione(d.OttieniDirezione(parametro));
		return comando;

	}
}