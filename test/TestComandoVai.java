package test;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.*;

public class TestComandoVai {
	
	FabbricaDiComandi fabbrica = new FabbricaDiComandiFisarmonica();
	FabbricaDiComandi fabbricaR = new FabbricaDiComandiFisarmonica();
	
		Comando comandoVaiNord = fabbrica.costruisciComando("vai nord");
		Comando comandoVaiSud = fabbrica.costruisciComando("vai sud");
		Comando comandoVaiEst = fabbrica.costruisciComando("vai est");
		Comando comandoVaiOvest = fabbrica.costruisciComando("vai ovest");
		
		Comando comandoVaiNordR = fabbricaR.costruisciComando("vai nord");
		Comando comandoVaiSudR = fabbricaR.costruisciComando("vai sud");
		Comando comandoVaiEstR = fabbricaR.costruisciComando("vai est");
		Comando comandoVaiOvestR = fabbricaR.costruisciComando("vai ovest");
	
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
	
	@Test
	public void testParametroComandoVaiNord() {
		assertEquals(("nord"), comandoVaiNord.getParametro());
	}
	
	@Test
	public void testParametroComandoVaiSud() {
		assertEquals(("sud"), comandoVaiSud.getParametro());
	}
	
	@Test
	public void testParametroComandoVaiEst() {
		assertEquals(("est"), comandoVaiEst.getParametro());
	}
	
	@Test
	public void testParametroComandoVaiOvest() {
		assertEquals(("ovest"), comandoVaiOvest.getParametro().toString());
	}
	
	@Test
	public void testFunzionamentoComandoVaiSud() {
		Partita partita = new Partita();	
		System.out.print("Ci dovremmo trovare nell'");
		comandoVaiSud.esegui(partita);
		assertEquals("Aula N10", partita.labirinto.getStanzaDiIngresso().getNome());
	}
	
	@Test
	public void testFunzionamentoComandoVaiSudRiflessiva() {
		Partita partita = new Partita();	
		System.out.print("Ci dovremmo trovare nell'");
		comandoVaiSudR.esegui(partita);
		assertEquals("Aula N10", partita.labirinto.getStanzaDiIngresso().getNome());
	}

}
