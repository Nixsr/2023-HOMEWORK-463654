package it.uniroma3.diadia.giocatore;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo osso;
	private Attrezzo lanterna;
	private Attrezzo chiave;
	private Attrezzo orologio;
	private Attrezzo pendolo;

	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa();
		this.osso = new Attrezzo("Osso", 3);
		this.lanterna = new Attrezzo("Lanterna", 2);
		this.chiave = new Attrezzo("Chiave", 1);
		this.orologio = new Attrezzo("Orologio", 0);
		this.pendolo = new Attrezzo("Pendolo", 3);
		this.borsa.addAttrezzo(osso);
		this.borsa.addAttrezzo(lanterna);
		this.borsa.addAttrezzo(chiave);
		this.borsa.addAttrezzo(orologio);
		this.borsa.addAttrezzo(pendolo);
	}

	@Test
	void testGetContenutoOrdinatoPerPeso() {
		List<Attrezzo> listaOrdinataPerPeso = this.borsa.getContenutoOrdinatoPerPeso();
		assertSame(this.orologio, listaOrdinataPerPeso.get(0));
		assertSame(this.osso, listaOrdinataPerPeso.get(3));
	}
	
	@Test
	void testGetContenutoOrdinatoPerNome() {
		Iterator<Attrezzo> it = this.borsa.getContenutoOrdinatoPerNome().iterator();
			assertSame(this.chiave, it.next());
			assertSame(this.lanterna, it.next());
	}
	
	@Test
	void testGetContenutoRaggruppatoPerPeso() {
		assertEquals(2, this.borsa.getContenutoRaggruppatoPerPeso().get(3).size());
	}
	
	@Test
	void testGetSortedSetOrdinatoPerPeso() {
		Iterator<Attrezzo> it = this.borsa.getSortedSetOrdinatoPerPeso().iterator();
		assertSame(this.orologio, it.next());
		assertSame(this.chiave, it.next());
		assertSame(this.lanterna, it.next());
		assertSame(this.osso, it.next());
		assertSame(this.pendolo, it.next());
	}
}