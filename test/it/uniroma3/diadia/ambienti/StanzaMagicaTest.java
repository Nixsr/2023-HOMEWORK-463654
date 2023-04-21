package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class StanzaMagicaTest {
	
	StanzaMagica stanza;
	Borsa borsa;
	Attrezzo attrezzo1;
	Attrezzo attrezzo2;
	Attrezzo attrezzo3;
	Attrezzo attrezzo4;

	@BeforeEach
	void setUp() throws Exception {
		this.stanza = new StanzaMagica("Stanza Speciale");
		this.borsa = new Borsa();
		this.attrezzo1 = new Attrezzo("martello", 1);
		this.attrezzo2 = new Attrezzo("bilancia", 3);
		this.attrezzo3 = new Attrezzo("pendolo", 2);
		this.attrezzo4 = new Attrezzo("chiave", 2);
		this.stanza.addAttrezzo(attrezzo1);
		this.stanza.addAttrezzo(attrezzo2);
		this.stanza.addAttrezzo(attrezzo3);
		this.stanza.addAttrezzo(attrezzo4);
	}

	@Test
	void testAddAttrezzo() {
		assertEquals("evaihc" , this.stanza.getAttrezzo("evaihc").getNome());
		assertEquals(4 , this.stanza.getAttrezzo("evaihc").getPeso());
	}
}
