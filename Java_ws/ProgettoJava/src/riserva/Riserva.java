package riserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import animali.*;
import cacciatori.Cacciatore;
import cacciatori.ComparatorPunti;

public final class Riserva {
	private static Riserva istanza; //unica istanza della classe (singleton)
	
	private List<Animale> animali;
	private List<Cacciatore> cacciatori;
	private List<Accessorio> accessori;
	
	//costruttore privato
	private Riserva() {
		animali = new ArrayList<Animale>();
		cacciatori = new ArrayList<Cacciatore>();
		accessori = new ArrayList<Accessorio>();
	}
	
	public static Riserva getIstanza() {
		if (istanza == null)
			istanza = new Riserva();
		return istanza;
	}
	
	//METODI
	
	//To String delle liste
	public String animaliToString() {
		String s = "";
		for(Animale a : animali)
			s += a.toString() + "\n";
		return s;
	}
	public String cacciatoriToString() {
		String s = "";
		for(Cacciatore c : cacciatori)
			s += c.toString() + "\n";
		return s;
	}
	public String accessoriToString() {
		String s = "";
		for(Accessorio a : accessori)
			s += a.toString() + "\n";
		return s;
	}
	
	//Aggiunta elementi alle liste
	public void addAnimali(Animale... as) {
		for(Animale a : as)
			if(!animali.contains(a))
				animali.add(a);
	}
	public void addCacciatori(Cacciatore... cs) {
		for(Cacciatore c: cs)
			if(!cacciatori.contains(c))
				cacciatori.add(c);
	}
	public void addAccessori(Accessorio... as) {
		for(Accessorio a: as)
			if(!accessori.contains(a))
				accessori.add(a);
	}
	
	//registra che il cacciatore idC ha ucciso l'animale idA
	public void uccidi(String idC, String idA) throws BadInputException, NonCacciabileException, GiaCacciatoException {
		
		Cacciatore cacciatore = null;
		Cacciabile preda = null;
		
		for(Cacciatore c : cacciatori) {
			if(c.getId().compareTo(idC) == 0) {
				cacciatore = c;
				break;
			}
		}
		
		for(Animale a : animali) {
			if(a.getId().compareTo(idA) == 0) {
				if(!(a instanceof Cacciabile)) throw new NonCacciabileException();
				preda = (Cacciabile)a;
				break;
			}
		}
		
		if(preda == null || cacciatore == null) 
			throw new BadInputException();
		
		preda.cacciato(cacciatore);
	}
	
	//Restituisce i tre cacciatori migliori in base ai punti
	public List<Cacciatore> cacciatoriMigliori() {
		return cacciatori.stream().sorted(new ComparatorPunti().reversed()).limit(3).toList();
	}
	
	//Restituisce una lista di animali disponibili per essere cacciati
	public List<Animale> animaliCacciabili() {
		return animali.stream()
				.filter(a -> a instanceof Cacciabile && a.isVivo())
				.filter(a -> !(a instanceof Quaglia && ((Quaglia)a).isMigrazione()))
				.toList();
	}
	
	//restituisce l'animale vivo più pesante
	public Optional<Animale> animalePiuPesante() {
		//se non c'è nessun animale
		if(animali.size() == 0) return Optional.empty();
		
		//il metodo max restituisce già un Optional<>
		var max = animali.stream().filter(a -> a.isVivo()).max(new ComparatorPeso());
		return max;
	}
}