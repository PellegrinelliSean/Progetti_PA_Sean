package animali;

import cacciatori.Cacciatore;
import riserva.GiaCacciatoException;
import riserva.NonCacciabileException;

public interface Cacciabile {
	public void cacciato(Cacciatore c) throws GiaCacciatoException, NonCacciabileException;
}