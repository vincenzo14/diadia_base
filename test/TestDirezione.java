package test;

import static org.junit.Assert.*;
import org.junit.Test;
import it.uniroma3.diadia.direzioni.Direzione;
import static it.uniroma3.diadia.direzioni.Direzione.*;

public class TestDirezione {

	@Test
	public void testGetDeclaringClass() {
		assertSame(Direzione.class, nord.getDeclaringClass());
		assertNotSame(Direzione.class, nord.getClass());
		assertNotSame(est.getClass(), nord.getClass());
	}

	@Test
	public void testGetOrdinal() {
		assertEquals(0, nord.ordinal());
		assertEquals(1, est.ordinal());
		assertEquals(2, sud.ordinal());
		assertEquals(3, ovest.ordinal());
	}

	@Test
	public void testTuttiSingleton() {
		assertSame(nord, Direzione.valueOf("nord"));
		final Direzione singleton = Direzione.valueOf("nord");
		assertSame(singleton, nord);
		assertNotSame(est, nord);
		System.out.println(nord);
	}

	@Test
	public void testCriterioDiEquivalenza() {
		assertEquals(nord, nord);
		assertNotEquals(nord, est);
		assertNotEquals(nord, sud);
	}

	@Test
	public void testCompareTo() {
		assertTrue(nord.compareTo(est)<0);
		assertTrue(est.compareTo(sud)<0);
		assertTrue(sud.compareTo(ovest)<0);
		assertTrue(ovest.compareTo(nord)>0);
	}

	@Test
	public void testToStringAndName() {
		assertEquals("nord", nord.toString());
		assertEquals("nord", nord.name());
	}
	
	@Test
	public void testValues() {
	final Direzione[] expected = { nord, est, sud, ovest } ;
	assertArrayEquals(expected , Direzione.values());
	}
}