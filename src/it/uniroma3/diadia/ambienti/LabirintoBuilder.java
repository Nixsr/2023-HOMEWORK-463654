package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	
	private Labirinto labirinto;
	private Stanza ultimaStanzaInserita;
	private Map<String,Stanza> stanze;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.stanze = new HashMap<String, Stanza>();
	}

	public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
		Stanza iniziale = new Stanza(nomeStanzaIniziale);
		this.labirinto.setStanzaIniziale(iniziale);
		this.inserisciUltimaStanzaEAggiorna(iniziale);
		return this;
	}

	public LabirintoBuilder addStanzaFinale(String nomeStanzaFinale) {
		Stanza finale = new Stanza(nomeStanzaFinale);
		this.labirinto.setStanzaFinale(finale);
		this.inserisciUltimaStanzaEAggiorna(finale);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String partenza, String adiacente, String direzione) {
		Stanza stanzaIniziale = this.stanze.get(partenza);
		Stanza stanzaAdiacente = this.stanze.get(adiacente);
		stanzaIniziale.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo a= new Attrezzo(nome, peso);
		this.ultimaStanzaInserita.addAttrezzo(a);
		return this;
	}

	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		this.inserisciUltimaStanzaEAggiorna(stanza);
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza stanza = new StanzaMagica(nome);
		this.inserisciUltimaStanzaEAggiorna(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
		Stanza stanza = new StanzaMagica(nome, soglia);
		this.inserisciUltimaStanzaEAggiorna(stanza);
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoIlluminante) {
		Stanza stanza = new StanzaBuia(nome,attrezzoIlluminante);
		this.inserisciUltimaStanzaEAggiorna(stanza);
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
		this.inserisciUltimaStanzaEAggiorna(stanza);
		return this;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	private void inserisciUltimaStanzaEAggiorna(Stanza stanza) {
		this.ultimaStanzaInserita = stanza;
		this.stanze.put(stanza.getNome(), stanza);
	}

	public Map<String, Stanza> getListaStanze() {
		return this.stanze;
	}

	public void setStanze(Map<String, Stanza> stanze) {
		this.stanze = stanze;
	}
}