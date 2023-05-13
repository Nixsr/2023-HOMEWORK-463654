package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa{

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoCorrente;

	public Borsa() {
		this.attrezzi = new HashMap<>();
		this.pesoCorrente = 0;
		this.attrezzi = new HashMap<>();
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
		this.numeroAttrezzi = 0;
		this.pesoCorrente = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		/**if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
		**/
		if(this.getPeso() + attrezzo.getPeso() <= this.getPesoMax()) {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			this.pesoCorrente += attrezzo.getPeso();
			return true;
		}
		return false;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		/**Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
		**/
		return this.attrezzi.get(nomeAttrezzo);
	}
	
	public int getPeso() {
		return pesoCorrente;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		/**Attrezzo a = null;
		if(this.hasAttrezzo(nomeAttrezzo)) {
			for(int i=0; i<this.attrezzi.length; i++) {
				if(this.attrezzi[i] != null && this.attrezzi[i] == this.getAttrezzo(nomeAttrezzo)){
					a = this.attrezzi[i];
					this.attrezzi[i] = null;
				}

			}
		}
		return a;
		**/
		return this.attrezzi.remove(nomeAttrezzo);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.attrezzi.toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> listaDiAttrezziPerPeso = new ArrayList(this.attrezzi.values());
		Collections.sort(listaDiAttrezziPerPeso, new ComparatoreAttrezziPerPeso());
		return listaDiAttrezziPerPeso;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<>(this.attrezzi.values());
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mappaAttrezziRaggruppatiPerPeso = new HashMap<>();
		for(Attrezzo a : this.attrezzi.values()) {
			Set<Attrezzo> insiemeAttrezziPerPeso = mappaAttrezziRaggruppatiPerPeso.get(a.getPeso());
			if(insiemeAttrezziPerPeso ==  null) {
				insiemeAttrezziPerPeso = new HashSet<>();
				mappaAttrezziRaggruppatiPerPeso.put(a.getPeso(), insiemeAttrezziPerPeso);
			}
			insiemeAttrezziPerPeso.add(a);
		}
		return mappaAttrezziRaggruppatiPerPeso;
	}

	public Map<String, Attrezzo> getAttrezzi() {
		return attrezzi;
	}

	public void setAttrezzi(Map<String, Attrezzo> attrezzi) {
		this.attrezzi = attrezzi;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> insiemeOrdinatoPerPeso = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		insiemeOrdinatoPerPeso.addAll(this.getAttrezzi().values());
		return insiemeOrdinatoPerPeso;
	}
}