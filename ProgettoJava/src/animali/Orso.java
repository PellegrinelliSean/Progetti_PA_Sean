package animali;

import riserva.BadInputException;

public class Orso extends Animale {
	//CAMPI
	protected boolean letargo;
	protected int pericolosita; //da 1 a 10
	
	//COSTRUTTORE
	public Orso(int eta, Genere sesso, float peso, int pericolosita) throws BadInputException {
		super(eta, sesso, peso);
		this.letargo = false;
		if(pericolosita < 1 || pericolosita > 10) throw new BadInputException();
		this.pericolosita = pericolosita;
	}
	
	public Orso(Genere sesso, float peso, int pericolosita) throws BadInputException {
		this(0, sesso, peso, pericolosita);
	}
	
	//METODI
	public boolean isLetargo() {
		return letargo;
	}
	public void setLetargo(boolean letargo) {
		this.letargo = letargo;
	}
	public int getPericolosita() {
		return pericolosita;
	}
	public void setPericolosita(int pericolosita) {
		this.pericolosita = pericolosita;
	}
	@Override
	public String toString() {
		return "Orso " + super.toString() + "\n   pericolosità = " + pericolosita + "\n   in letargo = " + (letargo ? "sì" : "no");
	}
}
