package it.uniroma3.diadia;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	
	private Partita partita;
	private Stanza stanza1;

	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		this.stanza1 = new Stanza("laboratorio");
	}

	@Test
	void testSetStanzaCorrente_Esistente() {
		this.partita.setStanzaCorrente(stanza1);
		assertSame(this.stanza1, this.partita.getStanzaCorrente());
	}
	
	@Test
	void testSetStanzaCorrente_StessaStanza() {
		this.partita.setStanzaCorrente(stanza1);
		assertSame(stanza1, this.partita.getStanzaCorrente());
		this.partita.setStanzaCorrente(stanza1);
		assertSame(stanza1, this.partita.getStanzaCorrente());
	}

	@Test
	void testIsFinita_TrueFalse() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testIsFinita_StanzaVincente() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}

	@Test
	void testIsFinita_Cfu() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}

}
