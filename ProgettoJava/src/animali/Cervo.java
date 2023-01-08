package animali;

import cacciatori.Cacciatore;
import riserva.BadInputException;
import riserva.GiaCacciatoException;

public class Cervo extends Animale implements Cacciabile {
	//CAMPI
	protected float pesoPalco;
	
	//COSTRUTTORI
	public Cervo(int eta, Genere sesso, float peso, float pesoPalco) throws BadInputException {
		super(eta, sesso, peso);
		if(pesoPalco < 0) throw new BadInputException();
		this.pesoPalco = pesoPalco;
	}
	public Cervo(Genere sesso, float peso, float pesoPalco) throws BadInputException {
		this(0, sesso, peso, pesoPalco);
	}
	
	//METODI
	@Override
	public void cacciato(Cacciatore c) throws GiaCacciatoException {
		if(!this.isVivo()) throw new GiaCacciatoException();
		this.setVivo(false);
		c.addTrofeo(this);
		c.addPunti(10);
	}
	public float getPesoPalco() {
		return pesoPalco;
	}
	public void setPesoPalco(float pesoPalco) {
		this.pesoPalco = pesoPalco;
	}
	@Override
	public String toString() {
		return "Cervo " + super.toString() + "\n   peso palco = " + pesoPalco + " kg";
	}
}
