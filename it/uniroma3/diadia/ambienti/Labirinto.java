package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe ha la responsabilità della creazione del labirinto del gioco,
 * di memorizzare la stanza iniziale (entrata) e quella finale (uscita)
 *
 * @author  Vincenzo D'Amico
 * @see Stanza
 * @see Partita
 * @version 1.0
 */

public class Labirinto {
	private Stanza stanzaDiIngresso;
	private Stanza stanzaVincente;
			
	public Labirinto(){
		
		init();
		
		}

	/**
     * Crea tutte le stanze con le relative uscite e attrezzi, 
     * e infine imposta la stanza iniziale e finale
     */
	
public void init() {

	/** crea gli attrezzi */
	Attrezzo chiaveN1 = new Attrezzo("chiaveN1", 1);
	Attrezzo chiaveN3 = new Attrezzo("chiaveN3", 1);
	Attrezzo lampada = new Attrezzo("lampada",3);
	Attrezzo lanterna = new Attrezzo("lanterna",3);
	Attrezzo osso = new Attrezzo("osso",1);
	Attrezzo spada = new Attrezzo("spada",4);
	Attrezzo scudo = new Attrezzo("scudo",5);
	Attrezzo lancia = new Attrezzo("lancia",3);
	Attrezzo arco = new Attrezzo("arco",2);
	Attrezzo freccia = new Attrezzo("freccia",1);
	
	
	/** crea stanze del labirinto */
	Stanza atrio = new Stanza("Atrio");
	Stanza aulaN11 = new StanzaBuia("Aula N11", "lanterna");
	Stanza aulaN10 = new StanzaBloccata("Aula N10", "sud", "chiaveN1");
	Stanza laboratorio = new StanzaMagica("Laboratorio Campus");
	Stanza biblioteca = new Stanza("Biblioteca");
	Stanza aulaN1 = new Stanza("Aula N1");
	Stanza aulaN2 = new StanzaBloccata("Aula N2", "sud", "chiaveN3");
	Stanza aulaN3 = new Stanza("Aula N3");
	Stanza aulaN4 = new Stanza("Aula N4");
	Stanza aulaN5 = new Stanza("Aula N5");
	
	
	/** collega le stanze */
	atrio.impostaUscita("nord", biblioteca);
	atrio.impostaUscita("est", aulaN11);
	atrio.impostaUscita("sud", aulaN10);
	atrio.impostaUscita("ovest", laboratorio);
	aulaN11.impostaUscita("est", laboratorio);
	aulaN11.impostaUscita("ovest", atrio);
	aulaN10.impostaUscita("nord", atrio);
	aulaN10.impostaUscita("est", aulaN11);
	aulaN10.impostaUscita("ovest", laboratorio);
	aulaN10.impostaUscita("sud", aulaN1);
	laboratorio.impostaUscita("est", atrio);
	laboratorio.impostaUscita("ovest", aulaN11);
	biblioteca.impostaUscita("sud", atrio);
	aulaN1.impostaUscita("nord", aulaN10);
	aulaN1.impostaUscita("sud", aulaN2);
	aulaN2.impostaUscita("nord", aulaN1);
	aulaN2.impostaUscita("sud", aulaN3);
	aulaN2.impostaUscita("est", aulaN4);
	aulaN2.impostaUscita("ovest", aulaN5);
	aulaN3.impostaUscita("nord", aulaN2);
	aulaN4.impostaUscita("ovest", aulaN2);
	aulaN5.impostaUscita("est", aulaN2);
	
    /** pone gli attrezzi nelle stanze */
	aulaN10.addAttrezzo(lampada);
	aulaN11.addAttrezzo(lanterna);
	aulaN1.addAttrezzo(chiaveN3);
	atrio.addAttrezzo(osso);
	atrio.addAttrezzo(chiaveN1);
	aulaN11.addAttrezzo(arco);
	aulaN11.addAttrezzo(freccia);
	laboratorio.addAttrezzo(scudo);
	laboratorio.addAttrezzo(spada);
	biblioteca.addAttrezzo(lancia);

	/** il gioco comincia nell'atrio */
    this.stanzaDiIngresso = atrio;  
	this.stanzaVincente = biblioteca;
}

public Stanza getStanzaVincente() {
	return this.stanzaVincente;
}

public Stanza getStanzaDiIngresso() {
	return this.stanzaDiIngresso;
}

public void setStanzaDiIngresso(Stanza stanzaDiIngresso) {
	this.stanzaDiIngresso = stanzaDiIngresso;
}

public boolean coincidenti() {
	return this.getStanzaDiIngresso() == this.getStanzaVincente();
}

}
