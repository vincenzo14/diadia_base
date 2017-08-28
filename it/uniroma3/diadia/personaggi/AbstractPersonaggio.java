package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractPersonaggio {

	private String nome;
	private String presentazione;
	private boolean haSalutato;

	public AbstractPersonaggio(String nome, String presentazione) {

		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false;
	}

	public String saluta() {
		StringBuilder risposta = new StringBuilder(this.getNome() + ": Ciao, il mio nome è ");
		risposta.append(this.getNome() + ".");
		if (!haSalutato)
			risposta.append("\n" + this.getNome() + ": "  + this.presentazione);
		else
			risposta.append(" Ci siamo già presetanti!");
		this.haSalutato = true;
		return risposta.toString();
	}

	abstract public String agisci(Partita partita);

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the presentazione
	 */
	public String getPresentazione() {
		return presentazione;
	}

	/**
	 * @param presentazione the presentazione to set
	 */
	public void setPresentazione(String presentazione) {
		this.presentazione = presentazione;
	}

	/**
	 * @return the haSalutato
	 */
	public boolean isHaSalutato() {
		return haSalutato;
	}

	/**
	 * @param haSalutato the haSalutato to set
	 */
	public void setHaSalutato(boolean haSalutato) {
		this.haSalutato = haSalutato;
	}

	@Override
	public String toString() {
		return this.getNome();
	}



}
