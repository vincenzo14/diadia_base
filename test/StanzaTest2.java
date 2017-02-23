package test;
import diadia.Stanza;
import diadia.Attrezzo;

public class StanzaTest2 {

	public static void main(String[] args) {
		
		Stanza bar = new Stanza("Bar");
		Stanza mensa = new Stanza("Mensa");
		
		Attrezzo tazzina = new Attrezzo("Tazzina", 3);
		Attrezzo piatto = new Attrezzo("Piatto", 5);
		
		bar.impostaUscita("nord", mensa);
		mensa.impostaUscita("sud", bar);
		
		bar.addAttrezzo(tazzina);
		mensa.addAttrezzo(piatto);
		
		System.out.println(mensa.getDescrizione());
		System.out.println(bar.getDescrizione());
				
		System.out.println("Nome e peso dell'Attrezzo dietro la porta nord del Bar: \n" + bar.getUscita("nord").getAttrezzo());
		System.out.println("Nome e peso dell'Attrezzo dietro la porta sud dela Mensa: \n" + mensa.getUscita("sud").getAttrezzo());
		
	}

}
