package test;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.comandi.*;

public class TestComandoVai {
	
	FabbricaDiComandi fabbrica = new FabbricaDiComandiFisarmonica();
	
		Comando comandoVaiNord = fabbrica.costruisciComando("vai nord");
		Comando comandoVaiSud = fabbrica.costruisciComando("vai sud");
		Comando comandoVaiEst = fabbrica.costruisciComando("vai est");
		Comando comandoVaiOvest = fabbrica.costruisciComando("vai ovest");
	
	@Test
	public void testNomeComandoVaiNord() {
		assertEquals(("vai"), comandoVaiNord.getNome());
	}
	
	@Test
	public void testNomeComandoVaiSud() {
		assertEquals(("vai"), comandoVaiSud.getNome());
	}
	
	@Test
	public void testNomeComandoVaiEst() {
		assertEquals(("vai"), comandoVaiEst.getNome());
	}
	
	@Test
	public void testNomeComandoVaiOvest() {
		assertEquals(("vai"), comandoVaiOvest.getNome());
	}
}
