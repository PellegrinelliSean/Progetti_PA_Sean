package test;

import animali.*;
import cacciatori.Cacciatore;
import riserva.Accessorio;
import riserva.BadInputException;
import riserva.GiaCacciatoException;
import riserva.NonCacciabileException;
import riserva.Riserva;

public class TestRiserva {

	public static void main(String[] args) throws BadInputException, NonCacciabileException, GiaCacciatoException {
		Riserva r = Riserva.getIstanza();
		
		Accessorio a1 = new Accessorio("fucile", 100f);
		Accessorio a2 = new Accessorio("giacca", 25.99f);
		r.addAccessori(a1, a2);
		System.out.println("STAMPA LISTA ACCESSORI\n" + r.accessoriToString());
		
		Cacciatore ca1 = new Cacciatore("Mario");
		Cacciatore ca2 = new Cacciatore("Luigi");
		Cacciatore ca3 = new Cacciatore("Marco");
		Cacciatore ca4 = new Cacciatore("Piero");
		
		Orso o1 = new Orso(26, Genere.FEMMINA, 100, 3);
		Orso o2 = new Orso(18, Genere.MASCHIO, 120, 5);
		
		Cervo c1 = new Cervo(14, Genere.MASCHIO, 80, 2);
		Cervo c2 = new Cervo(12, Genere.FEMMINA, 70, 0);
		Cervo c3 = new Cervo(Genere.MASCHIO, 4, 0);
		
		Quaglia q1 = new Quaglia(4, Genere.MASCHIO, 2);
		Quaglia q2 = new Quaglia(3, Genere.MASCHIO, 3);
		//q2.isMigrazione(); //se attivo poi uccide una quaglia che non c'è
		
		r.addAnimali(o1, o2, c1, c2, c3, q1, q2);
		r.addCacciatori(ca1, ca2, ca3, ca4);
		
		System.out.println("STAMPA LISTA ANIMALI\n" + r.animaliToString());
		System.out.println("STAMPA LISTA CACCIATORI\n" + r.cacciatoriToString());
		
		System.out.println("STAMPA LISTA ANIMALI DISPONIBILI AD ESSERE CACCIATI\n" + r.animaliCacciabili());
		
		System.out.println("\nSTAMPA ANIMALE PIù PESANTE");
		var ap = r.animalePiuPesante();
		if(ap.isPresent())
			System.out.println(ap.get());
		
		r.uccidi("C1", "A3");
		//r.uccidi("C1", "A3"); //uccidi un animale già morto
		r.uccidi("C1", "A4");
		r.uccidi("C1", "A6");
		r.uccidi("C2", "A7");
		r.uccidi("C3", "A5");
		//r.uccidi("C1", "A1"); //uccidi un orso
		
		System.out.println("\nSTAMPA LISTA ANIMALI\n" +r.animaliToString());
		System.out.println("STAMPA LISTA CACCIATORI\n" +r.cacciatoriToString());
		
		System.out.println("STAMPA LISTA CACCIATORI MIGLIORI\n" +r.cacciatoriMigliori());
	}
}