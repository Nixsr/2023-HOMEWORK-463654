package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest2 {
	public static void main(String[] args) {
		Stanza bar = new Stanza("bar");
		Stanza mensa = new Stanza("mensa");
		
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);
		
		Attrezzo tazzina = new Attrezzo("tazzina", 0);
		Attrezzo piatto = new Attrezzo("piatto", 1);
		
		bar.addAttrezzo(tazzina);
		mensa.addAttrezzo(piatto);
		
		System.out.println(bar.getStanzaAdiacente("nord").getAttrezzo("piatto"));
		System.out.println(mensa.getStanzaAdiacente("sud").getAttrezzo("tazzina"));
		
	}
}
