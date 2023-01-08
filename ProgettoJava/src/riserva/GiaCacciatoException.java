package riserva;

@SuppressWarnings("serial")
public class GiaCacciatoException extends Exception {
	public GiaCacciatoException() {
		super("Attenzione, l'animale specificato è già stato cacciato!");
	}
}