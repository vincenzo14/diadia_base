package diadia;

/**
 * Questa classe ha la responsabilità della creazione del labirinto del gioco
 *
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @see Partita
 * @version 0.1
 */

public class Labirinto {
	private Stanza stanzaDiIngresso;
	private Stanza stanzaVincente;
			
	public Labirinto(){
		
		init();
		
		}

	/**
     * Crea tutte le stanze e le porte di collegamento
     */
	
public void init() {

	/* crea gli attrezzi */
	Attrezzo lanterna = new Attrezzo("lanterna",3);
	Attrezzo osso = new Attrezzo("osso",1);
	
	/* crea stanze del labirinto */
	Stanza atrio = new Stanza("Atrio");
	Stanza aulaN11 = new Stanza("Aula N11");
	Stanza aulaN10 = new Stanza("Aula N10");
	Stanza laboratorio = new Stanza("Laboratorio Campus");
	Stanza biblioteca = new Stanza("Biblioteca");
	
	/* collega le stanze */
	atrio.impostaUscita("nord", biblioteca);
	atrio.impostaUscita("est", aulaN11);
	atrio.impostaUscita("sud", aulaN10);
	atrio.impostaUscita("ovest", laboratorio);
	aulaN11.impostaUscita("est", laboratorio);
	aulaN11.impostaUscita("ovest", atrio);
	aulaN10.impostaUscita("nord", atrio);
	aulaN10.impostaUscita("est", aulaN11);
	aulaN10.impostaUscita("ovest", laboratorio);
	laboratorio.impostaUscita("est", atrio);
	laboratorio.impostaUscita("ovest", aulaN11);
	biblioteca.impostaUscita("sud", atrio);

    /* pone gli attrezzi nelle stanze */
	aulaN10.addAttrezzo(lanterna);
	atrio.addAttrezzo(osso);

	// il gioco comincia nell'atrio
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
