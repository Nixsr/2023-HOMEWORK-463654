package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Grazie di aver giocato!");

	}

	@Override
	public void setParametro(String parametro) {
		return;
	}

	@Override
	public String getNome() {
		return "fine";
	}

	@Override
	public String getParametro() {
		return "";
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
