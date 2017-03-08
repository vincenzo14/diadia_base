package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 *  Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 *  Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 *  Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class DiaDia {
	private Partita partita;
	private static final String MESSAGGIO_BENVENUTO = 
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
					"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
					"I locali sono popolati da strani personaggi, " +
					"alcuni amici, altri... chissa!\n"+
					"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
					"puoi metterli nella borsa, usarli, posarli quando ti sembrano inutili\n" +
					"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
					"Per conoscere le istruzioni usa il comando 'aiuto'.";
	private static String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome()==null)
			System.out.println("Inserisci un comando");
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} 

		return false;

	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.labirinto.getStanzaDiIngresso().getUscita(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.labirinto.setStanzaDiIngresso(prossimaStanza);
			int cfu = this.partita.giocatore.getCfu();
			this.partita.giocatore.setCfu(cfu--);
		}
		System.out.println(partita.labirinto.getStanzaDiIngresso().getNome());
	}

	/**
	 * Comando "Prendi".
	 */

	private void prendi(String nomeAttrezzo) {
		if (this.partita.labirinto.getStanzaDiIngresso().hasAttrezzo(nomeAttrezzo))
			if (this.partita.giocatore.borsa.addAttrezzo(partita.labirinto.getStanzaDiIngresso().getAttrezzo(nomeAttrezzo))){
				this.partita.labirinto.getStanzaDiIngresso().removeAttrezzo(nomeAttrezzo);
				System.out.println("Hai preso l'Attrezzo: "+ nomeAttrezzo);

			}
			else {
				System.out.println("Borsa piena liberati prima di Attrezzi inutuli");
			}
		else {
			System.out.println("Attrezzo non presente nella Stanza");
		}
		System.out.println(partita.labirinto.getStanzaDiIngresso().getDescrizione());	 
		System.out.println(partita.giocatore.borsa.toString());
	}


	/**
	 * Comando "Posa".
	 */

	private void posa(String nomeAttrezzo) {
		if (this.partita.giocatore.borsa.hasAttrezzo(nomeAttrezzo)){
			Attrezzo a = this.partita.giocatore.borsa.removeAttrezzo(nomeAttrezzo);
			this.partita.labirinto.getStanzaDiIngresso().addAttrezzo(a);
			System.out.println("Hai posato l'Attrezzo: " + a.getNome() + " Peso: "+ a.getPeso()+" Kg");
		}
		else {
			System.out.println("Attrezzo non presente nella Borsa");
		}
		System.out.println(partita.labirinto.getStanzaDiIngresso().getDescrizione());	
		System.out.println(partita.giocatore.borsa.toString());
	}



	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}