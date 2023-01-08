package animali;

import cacciatori.Cacciatore;
import riserva.BadInputException;
import riserva.GiaCacciatoException;
import riserva.NonCacciabileException;

public class Quaglia extends Animale implements Cacciabile {
	//CAMPI
	protected boolean migrazione;
	
	//COSTRUTTORI
	public Quaglia(int eta, Genere sesso, float peso) throws BadInputException {
		super(eta, sesso, peso);
		this.migrazione = false;
	}
	public Quaglia(Genere sesso, float peso) throws BadInputException {
		this(0, sesso, peso);
	}
	
	//METODI
	@Override
	public void cacciato(Cacciatore c) throws GiaCacciatoException, NonCacciabileException {
		if(!this.isVivo()) throw new GiaCacciatoException();
		if(this.isMigrazione()) throw new NonCacciabileException();
		this.setVivo(false);
		c.addTrofeo(this);
		c.addPunti(2);
	}
	public boolean isMigrazione() {
		return migrazione;
	}
	public void setMigrazione(boolean migrazione) {
		this.migrazione = migrazione;
	}
	@Override
	public String toString() {
		return "Quaglia " + super.toString() + "\n   in migrazione = " + (migrazione ? "sì" : "no");
	}
}
