package it.uniroma3.diadia.ambienti;

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
		StringBuilder risultato = new StringBuilder();
		if(super.hasAttrezzo(this.attrezzoIlluminante)) {
			risultato.append(super.getNome());
			risultato.append("\nUscite: ");
			risultato.append(super.getStanzeAdiacenti().keySet().toString());
			risultato.append("\nAttrezzi nella stanza: ");
			risultato.append(super.getAttrezzi().toString());
			return risultato.toString();
		}
		return "quì c'è un buio pesto";
	}
}
