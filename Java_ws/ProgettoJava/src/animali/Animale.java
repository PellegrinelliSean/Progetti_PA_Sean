package animali;

import riserva.BadInputException;

public abstract class Animale implements Comparable<Animale> {
	private static int count = 0; //campo statico per generare l'id
	
	//CAMPI
	protected final String id;
	protected int eta; //età dell'animale in mesi
	protected float peso;
	protected final Genere sesso;
	protected boolean vivo;

	//COSTRUTTORI
	public Animale(int eta, Genere sesso, float peso) throws BadInputException {
		this.id = "A" + (++count);
		if(eta < 0 || peso <= 0) throw new BadInputException();
		this.eta = eta;
		this.peso = peso;
		this.sesso = sesso;
		this.vivo = true;
	}
	
	public Animale(Genere sesso, float peso) throws BadInputException {
		this(0, sesso, peso);
	}

	//METODI
	public int getEta() {
		return eta;
	}
	public String getId() {
		return id;
	}
	public float getPeso() {
		return peso;
	}
	public Genere getSesso() {
		return sesso;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setPeso(float p) {
		this.peso = p;
	}
	public void invecchia() {
		this.eta++;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	@Override
	public String toString() {
		return id + "\n   mesi = " + eta + "\n   peso = " + peso  + " kg" + "\n   sesso = " + sesso + "\n   vivo = " + (vivo ? "sì" : "no");
	}
	//ordinamento di default dipende dal solo id univoco
	@Override
	public int compareTo(Animale a) {
		return this.id.compareTo(a.id);
	}
}
