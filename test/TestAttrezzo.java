package test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestAttrezzo {

	public static void main(String[] args) {
		
		Attrezzo scudo = new Attrezzo("Scudo", 10);
		Attrezzo cacciavite = new Attrezzo("Cacciavite", 3);
		
		System.out.println("Descrizione dei due Attrezzi: " + scudo.toString() + " " + cacciavite.toString());
		
		int somma = scudo.getPeso() + cacciavite.getPeso();
		
		System.out.println("La somma dei due attrezzi �: " + somma);
		
		String pesante = new String();
		
		if (scudo.getPeso()>cacciavite.getPeso()){ 
			
			pesante = scudo.getNome();
		}
		else {
			pesante = cacciavite.getNome();
		}
		
		System.out.println("L'attrezzo pi� pesante �: " + pesante);
		
		
		
		
	}

}
