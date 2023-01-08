package cacciatori;

import java.util.Comparator;

public class ComparatorPunti implements Comparator<Cacciatore> {

	@Override
	public int compare(Cacciatore o1, Cacciatore o2) {
		return o1.punti - o2.punti;
	}
}
