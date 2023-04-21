package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {

	private String attrezzoIlluminante;
	
	public StanzaBuia(String nome, String attrezzoIlluminante) {
		super(nome);
		this.attrezzoIlluminante = attrezzoIlluminante;
	}
	
	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}
	
	public String toString() {
		if(super.hasAttrezzo(this.attrezzoIlluminante)) {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\nUscite: ");
		for (String direzione : super.getDirezioni())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null) {
				risultato.append(attrezzo.toString()+" ");	
			}
		}
		return risultato.toString();
		}
		return "quì c'è un buio pesto";
	}
}
