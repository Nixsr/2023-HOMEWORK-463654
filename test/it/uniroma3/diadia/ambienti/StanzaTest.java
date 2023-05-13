package it.uniroma3.diadia.ambienti;



import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	private Stanza laboratorio;
	private Stanza biblioteca;
	private Stanza atrio;
	private Attrezzo pendolo1;
	private Attrezzo chiave;
	
	private Stanza stanzaConIlMassimoNumeroDiAttrezzi() {
		Stanza s = new Stanza("Magazzino");
		Attrezzo[] attrezzi = new Attrezzo[11];
		for(int i=0; i<attrezzi.length; i++) {
			attrezzi[i] = new Attrezzo("Martello "+i, 2);
			s.addAttrezzo(attrezzi[i]);
		}
		return s;
	}
	
	@BeforeEach
	public void setUp() throws Exception {
		this.atrio = new Stanza("Atrio");
		this.biblioteca = new Stanza("Biblioteca");
		this.laboratorio = new Stanza("Camera00");
		this.pendolo1 = new Attrezzo("Pendolo 1", 3);
		this.chiave = new Attrezzo("Chiave", 2);
	}
	
	@Test
	void testImpostaStanzaAdiacente_Esistente() {
		this.laboratorio.impostaStanzaAdiacente("Nord", this.biblioteca);
		assertSame(this.biblioteca, this.laboratorio.getStanzaAdiacente("Nord"));
	}
	
	@Test
	void testImpostaStanzaAdiacente_Inesistente() {
		assertNull(null, this.laboratorio.getStanzaAdiacente("Sud"));
	}
	
	@Test
	void testImpostaStanzaAdiacente_ParametroVuoto() {
		assertNull(null, this.laboratorio.getStanzaAdiacente(""));
	}
	
	@Test
	void testImpostaStanzaAdiacenteSize() {
		this.laboratorio.impostaStanzaAdiacente("nord", this.biblioteca);
		assertEquals(1, this.laboratorio.getStanzeAdiacenti().size());
		this.laboratorio.impostaStanzaAdiacente("est", this.atrio);
		assertEquals(2, this.laboratorio.getStanzeAdiacenti().size());
		this.laboratorio.impostaStanzaAdiacente("sud", this.biblioteca);
		assertEquals(3, this.laboratorio.getStanzeAdiacenti().size());
		this.laboratorio.impostaStanzaAdiacente("ovest", this.atrio);
		assertEquals(4, this.laboratorio.getStanzeAdiacenti().size());
		this.laboratorio.impostaStanzaAdiacente("nord-ovest", this.atrio);
		assertEquals(4, this.laboratorio.getStanzeAdiacenti().size());
	}

	@Test
	void testAddAttrezzo_Esistente() {
		this.laboratorio.addAttrezzo(this.pendolo1);
		assertSame(this.pendolo1, this.laboratorio.getAttrezzo("Pendolo 1"));
		
	}
	
	@Test
	void testAddAttrezzo_Inesistente() {
		assertNull(this.laboratorio.getAttrezzo("Pendolo"));
	}
	
	@Test
	void testAddAttrezzo_MassimaCapienza() {
		Stanza stanzaPiena = this.stanzaConIlMassimoNumeroDiAttrezzi();
		assertFalse(stanzaPiena.addAttrezzo(this.chiave));
	}
	

	@Test
	void testHasAttrezzo_Esistente() {
		this.biblioteca.addAttrezzo(this.chiave);
		assertTrue(this.biblioteca.hasAttrezzo("Chiave"));
	}
	
	@Test
	void testHasAttrezzo_Inesistente() {
		assertFalse(this.biblioteca.hasAttrezzo("Pendolo"));
	}
	
	@Test
	void testHasAttrezzo_ParametroVuoto() {
		assertFalse(this.biblioteca.hasAttrezzo(""));
	}

	@Test
	void testRemoveAttrezzo_Esistente() {
		this.biblioteca.addAttrezzo(this.chiave);
		assertSame(this.chiave, this.biblioteca.getAttrezzo("Chiave"));
		assertTrue(this.biblioteca.removeAttrezzo(this.chiave));
		assertFalse(this.biblioteca.hasAttrezzo("Chiave"));
	}
	
	@Test
	void testRemoveAttrezzo_Inesistente() {
		assertFalse(this.biblioteca.removeAttrezzo(this.chiave));
	}

}