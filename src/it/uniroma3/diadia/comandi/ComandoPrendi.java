package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPrendi implements Comando {

	private String attrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		if(this.attrezzo!=null) {
			partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(this.attrezzo));
			partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(this.attrezzo));
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "prendi";
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
