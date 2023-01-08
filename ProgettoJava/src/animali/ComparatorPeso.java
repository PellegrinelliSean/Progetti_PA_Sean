package animali;

import java.util.Comparator;

public class ComparatorPeso implements Comparator<Animale> {

	@Override
	public int compare(Animale a1, Animale a2) {
		float peso1 = a1.peso;
		float peso2 = a2.peso;
		return Float.compare(peso1, peso2);
	}
}
