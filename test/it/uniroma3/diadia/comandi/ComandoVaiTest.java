package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private Stanza laboratorio;
	private Stanza segreteria;
	private Comando comandoVai;
	private Partita partita;
	private List<String> comandi;
	private Labirinto labirinto;
	private IO ioSimulator;

	@Before
	public void setUp() throws Exception {
		this.ioSimulator = new IOConsole();
		this.laboratorio = new Stanza("Laboratorio");
		this.segreteria = new Stanza("Segreteria");
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIO(ioSimulator);
		this.comandi = new ArrayList<>();
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Segreteria", "ovest")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		this.partita = new Partita(this.labirinto);
	}

	@Test
	public void testComandoVaiSenzaDirezione() {
		this.partita.setStanzaCorrente(this.laboratorio);
		this.comandoVai.esegui(this.partita);
		assertEquals(this.laboratorio, this.partita.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneNonEsistente() {
		this.partita.setStanzaCorrente(this.laboratorio);
		this.laboratorio.impostaStanzaAdiacente("ovest", this.segreteria);
		this.comandoVai.setParametro("est");
		this.comandoVai.esegui(this.partita);
		assertEquals(this.laboratorio, this.partita.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		this.partita.setStanzaCorrente(this.laboratorio);
		this.laboratorio.impostaStanzaAdiacente("ovest", this.segreteria);
		this.comandoVai.setParametro("ovest");
		this.comandoVai.esegui(this.partita);
		assertEquals(this.segreteria, this.partita.getStanzaCorrente());
	}

	@Test
	public void testPartitaConComandoVai() {
		this.comandi.add("vai nord");
		this.comandi.add("fine");
		IOSimulator ioSimulator = new IOSimulator(this.comandi);
		new DiaDia(ioSimulator, this.labirinto).gioca();
		assertTrue(ioSimulator.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, ioSimulator.nextMessaggio());
		assertTrue(ioSimulator.hasNextMessaggio());
		assertEquals("Biblioteca", ioSimulator.nextMessaggio());
		assertTrue(ioSimulator.hasNextMessaggio());
		assertEquals("Hai vinto!", ioSimulator.nextMessaggio());
	}
	
}