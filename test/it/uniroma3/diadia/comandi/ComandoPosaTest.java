package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Giocatore;

class ComandoPosaTest {

	Partita partita;
	Giocatore giocatore;
	Stanza stanza;
	Attrezzo attrezzo;
	ComandoPosa comando;
	
	@BeforeEach
	void setUp() throws Exception {
	this.partita = new Partita();
	this.giocatore = new Giocatore();
	this.stanza = new Stanza("Stanza Di Prova");
	this.attrezzo = new Attrezzo("Martello", 2);
	this.comando = new ComandoPosa();
	this.comando.setParametro(attrezzo.getNome());
	
	this.partita.setStanzaCorrente(stanza);
	this.partita.setGiocatore(giocatore);
	this.giocatore.getBorsa().addAttrezzo(attrezzo);
	}

	@Test
	void testEseguiOggettoEsistente() {
		this.comando.esegui(this.partita);
		assertSame(this.attrezzo, this.stanza.getAttrezzo(this.attrezzo.getNome()));
	}
}