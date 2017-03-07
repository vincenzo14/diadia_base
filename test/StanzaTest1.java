package test;

import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaTest1 {

	public static void main(String[] args) {

		Stanza bar = new Stanza("Bar");
		Stanza mensa = new Stanza("Mensa");

		bar.impostaUscita("nord", mensa);

		mensa.impostaUscita("sud", bar);

		System.out.println("Descrizione stanza dietro la porta nord del bar: \n" + bar.getUscita("nord").getDescrizione());

		System.out.println("Descrizione stanza dietro la porta sud della mensa: \n" + mensa.getUscita("sud").getDescrizione());
		
		}

}
