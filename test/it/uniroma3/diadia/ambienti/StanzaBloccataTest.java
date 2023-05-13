package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacente;
	private Attrezzo attrezzoSbloccante;

	@BeforeEach
	void setUp() throws Exception {
		this.attrezzoSbloccante = new Attrezzo("chiave", 1);
		this.stanzaAdiacente = new Stanza("cassaforte");
		this.stanzaBloccata = new StanzaBloccata("archivio", "nord", this.attrezzoSbloccante.getNome());
		this.stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
	}

	@Test
	void testGetStanzaAdiacenteSenzaAttrezzoSbloccante() {
		assertEquals(this.stanzaBloccata.getNome(), this.stanzaBloccata.getStanzaAdiacente("nord").getNome());
	}
	
	@Test
	void testGetStanzaAdiacenteConAttrezzoSbloccante() {
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertSame(this.stanzaAdiacente, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetDescrizioneSenzaAttrezzoSbloccante() {
		assertEquals("archivio\nUscite: []\nAttrezzi nella stanza: []\nti serve "+ this.attrezzoSbloccante.getNome() + " per aprire la porta nella direzione nord", this.stanzaBloccata.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneConAttrezzoSbloccante() {
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals("archivio\nUscite: [nord]\nAttrezzi nella stanza: ["+this.attrezzoSbloccante+"]", this.stanzaBloccata.getDescrizione());
	}
}
