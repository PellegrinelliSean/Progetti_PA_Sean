package riserva;

@SuppressWarnings("serial")
public class NonCacciabileException extends Exception  {
	public NonCacciabileException() {
		super("Attenzione, l'animale specificato non pu� essere cacciato!");
	}
}