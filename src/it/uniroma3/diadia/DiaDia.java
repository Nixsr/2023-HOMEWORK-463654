package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";


	private Partita partita;
	private IO io;

	public DiaDia(IO io, Labirinto labirinto) {
		this.partita = new Partita(labirinto);
		this.io = io;
	}
	
	public DiaDia(IO io) {
		this.io = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione, this.io);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			this.io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			System.out.println("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}

	public static void main(String[] argc) {
		/* N.B. unica istanza di IOConsole
		di cui sia ammessa la creazione */
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","ovest")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
	}
}