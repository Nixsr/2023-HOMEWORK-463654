package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {

	FabbricaDiComandiFisarmonica factory;
	IO io;
	
	@BeforeEach
	void setUp() throws Exception {
		factory = new FabbricaDiComandiFisarmonica();
		this.io = new IOConsole();
	}

	@Test
	void testCostruisciComandoAiuto() {
		Comando comando = factory.costruisciComando("aiuto", this.io);
		assertEquals("aiuto", comando.getNome());
		assertEquals("", comando.getParametro());
	}
	
	@Test
	void testCostruisciComandoFine() {
		Comando comando = factory.costruisciComando("fine", this.io);
		assertEquals("fine", comando.getNome());
		assertEquals("", comando.getParametro());
	}
	
	@Test
	void testCostruisciComandoGuarda() {
		Comando comando = factory.costruisciComando("guarda", this.io);
		assertEquals("guarda", comando.getNome());
		assertEquals("", comando.getParametro());
	}
	
	@Test
	void testCostruisciComandoNonValido() {
		Comando comando = factory.costruisciComando("comando non valido", this.io);
		assertEquals("comando non valido", comando.getNome());
		assertEquals("", factory.costruisciComando("fine", this.io).getParametro());
	}
	
	@Test
	void testCostruisciComandoPosa() {
		Comando comando = factory.costruisciComando("posa martello", this.io);
		assertEquals("posa", comando.getNome());
		assertEquals("martello", comando.getParametro());
	}
	
	@Test
	void testCostruisciComandoPrendi() {
		Comando comando = factory.costruisciComando("prendi martello", this.io);
		assertEquals("prendi", comando.getNome());
		assertEquals("martello", comando.getParametro());
	}
	
	@Test
	void testCostruisciComandoVai() {
		Comando comando = factory.costruisciComando("vai nord", this.io);
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
}