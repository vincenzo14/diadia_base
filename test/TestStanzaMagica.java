package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaMagica {

	private Stanza mensa = new StanzaMagica("Mensa");

	private Attrezzo spada = new Attrezzo("Spada", 2);
	private Attrezzo scudo = new Attrezzo("Scudo", 4);
	private Attrezzo lancia = new Attrezzo("Lancia", 3);
	private Attrezzo arco = new Attrezzo("Arco", 2);
	private Attrezzo freccia = new Attrezzo("Freccia", 2);

	@Test
	public void alfatest() {
		System.out.println(mensa.getDescrizione());
		System.out.println("Poso lo SCUDO nella Stanza");
		mensa.addAttrezzo(scudo);
		System.out.println("Poso l'ARCO nella Stanza");
		mensa.addAttrezzo(arco);
		System.out.println("Poso lo FRECCIA nella Stanza");
		mensa.addAttrezzo(freccia);
		System.out.println(mensa.getDescrizione());
		System.out.println("Poso la LANCIA nella Stanza");
		System.out.println("Ora la Stanza diventerà 'MAGICA' \n");
		mensa.addAttrezzo(lancia);
		System.out.println("Poso la SPADA nella Stanza Magica");
		mensa.addAttrezzo(spada);
		System.out.println(mensa.getDescrizione());
		
	}

	@Test
	public void TestControlloContatoreAttrezziPosatiNessuno() {
		assertEquals(0, mensa.getContatoreAttrezziPosati());
	}
	
	@Test
	public void TestControlloContatoreAttrezziPosatiCinque() {
		mensa.addAttrezzo(scudo);
		mensa.addAttrezzo(arco);
		mensa.addAttrezzo(freccia);
		mensa.addAttrezzo(lancia);
		mensa.addAttrezzo(spada);
		assertEquals(5, mensa.getContatoreAttrezziPosati());
	}
		
	@Test
	public void TestControlloSogliaMagica() {
		assertEquals(3, mensa.getSogliaMagica());
	}
	
	@Test
	public void TestControlloNomeInvertito() {
		System.out.println("Informazioni dell'Attrezzo LANCIA: " + lancia.toString());

		StringBuilder nomeDiControllo = new StringBuilder(lancia.getNome());
		String nomeDaVerificare = nomeDiControllo.reverse().toString();		
		mensa.addAttrezzo(scudo);
		mensa.addAttrezzo(arco);
		mensa.addAttrezzo(freccia);
		System.out.println("Ora la Stanza diventerà 'MAGICA' \n");
		mensa.addAttrezzo(lancia);
		assertFalse(lancia.getNome().equals(mensa.getAttrezzo("aicnaL").getNome()));
		assertEquals(nomeDaVerificare, mensa.getAttrezzo(nomeDaVerificare).getNome());
	}

	@Test
	public void TestControlloPesoRaddoppiato() {
		mensa.addAttrezzo(scudo);
		mensa.addAttrezzo(arco);
		mensa.addAttrezzo(freccia);
		mensa.addAttrezzo(lancia);
		assertEquals(6, mensa.getAttrezzo("aicnaL").getPeso());
	}

}
