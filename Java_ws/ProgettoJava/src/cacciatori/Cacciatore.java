package cacciatori;

import java.util.ArrayList;
import java.util.List;
import animali.Cacciabile;

public final class Cacciatore implements Comparable<Cacciatore> {
	private static int count = 0; //campo statico per generare l'id

	//CAMPI
	final String id;
	String nome;
	int punti;
	List<Cacciabile> trofei;

	//COSTRUTTORE
	public Cacciatore(String nome) {
		this.id = "C" + (++count);
		this.nome = nome;
		this.punti = 0;
		this.trofei = new ArrayList<Cacciabile>();
	}
	
	//METODI
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPunti() {
		return punti;
	}
	public int addPunti(int p) {
		return this.punti += p;
	}
	//il trofeo non può essere modificato, lo faranno altri metodi
	public void addTrofeo(final Cacciabile trofeo) {
		trofei.add(trofeo);
	}
	@Override
	public String toString() {
		return "Cacciatore " + nome + "\n   id = " + id + "\n   punti = " + punti + "\n   numero trofei = " + trofei.size();
	}

	//ordinamento di default dipende dal solo id univoco
	@Override
	public int compareTo(Cacciatore o) {
		return this.id.compareTo(o.id);
	}
}