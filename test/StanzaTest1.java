package test;

import it.uniroma3.diadia.ambienti.Stanza;
import static it.uniroma3.diadia.direzioni.Direzione.*;

public class StanzaTest1 {

	public static void main(String[] args) {

		Stanza bar = new Stanza("Bar");
		Stanza mensa = new Stanza("Mensa");

		bar.impostaUscita(nord, mensa);

		mensa.impostaUscita(sud, bar);

		System.out.println("Descrizione stanza dietro la porta nord del Bar: \n" + bar.getStanzaAdiacente(nord).getDescrizione());

		System.out.println("Descrizione stanza dietro la porta sud della Mensa: \n" + mensa.getStanzaAdiacente(sud).getDescrizione());
		
		}

}
