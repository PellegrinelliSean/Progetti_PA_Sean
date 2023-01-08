package riserva;

public record Accessorio(String nome, float prezzo) {
	@Override
	public String toString() {
		return nome + " " + prezzo + "€";
	}
}
