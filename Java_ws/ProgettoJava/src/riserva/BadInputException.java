package riserva;

@SuppressWarnings("serial")
public class BadInputException extends Exception {
	public BadInputException() {
		super("Attenzione, un parametro inserito non è corretto!");
	}
}

