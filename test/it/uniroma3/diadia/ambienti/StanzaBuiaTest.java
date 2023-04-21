package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	StanzaBuia stanza;
	Attrezzo lanterna;

	@BeforeEach
	void setUp() throws Exception {
		this.lanterna = new Attrezzo("lanterna", 3);
		this.stanza = new StanzaBuia("magazzino", lanterna.getNome());
	}

	@Test
	void testGetDescrizioneSenzaAttrezzoIlluminante() {
		assertEquals("quì c'è un buio pesto", this.stanza.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneConAttrezzoIlluminante() {
		this.stanza.addAttrezzo(lanterna);
		assertNotEquals("qui c'è un buio pesto", this.stanza.getDescrizione());
	}
}
