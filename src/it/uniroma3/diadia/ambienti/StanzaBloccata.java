package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza {

	private String attrezzoSbloccante;
	private String direzioneBloccata;

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.attrezzoSbloccante = attrezzoSbloccante;
		this.direzioneBloccata = direzioneBloccata;
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata solo se si ha l'attrezzo sbloccante 
	 * altrimenti si rimane nella stanza corrente
	 * @param direzione
	 */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.direzioneBloccata) && !super.hasAttrezzo(attrezzoSbloccante))
			return this;
		return super.getStanzaAdiacente(direzione);
	}


	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	@Override
	public String getDescrizione() {
		return this.toString();
	}

	@Override
	public String toString() {
		if(super.hasAttrezzo(this.attrezzoSbloccante)) {
			StringBuilder risultato = new StringBuilder();
			risultato.append(super.getNome());
			risultato.append("\nUscite: ");
			risultato.append(super.getStanzeAdiacenti().keySet().toString());
			risultato.append("\nAttrezzi nella stanza: ");
			risultato.append(super.getAttrezzi().toString());
			return risultato.toString();
		}
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\nUscite: ");
		if(super.hasAttrezzo(this.attrezzoSbloccante)) {
			risultato.append(super.getStanzeAdiacenti().keySet().toString());
		}else {
			risultato.append("[]");
		}
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(super.getAttrezzi().toString());
		risultato.append("\nti serve "+ this.attrezzoSbloccante +" per aprire la porta nella direzione "+ this.direzioneBloccata);
		return risultato.toString();
	}
}