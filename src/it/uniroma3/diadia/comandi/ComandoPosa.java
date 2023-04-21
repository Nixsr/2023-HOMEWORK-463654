package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {

	private String attrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(this.attrezzo));
		partita.getGiocatore().getBorsa().removeAttrezzo(this.attrezzo);

	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}

}
