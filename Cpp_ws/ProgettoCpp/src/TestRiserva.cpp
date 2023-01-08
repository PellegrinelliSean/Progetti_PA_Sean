#include "Riserva.h"
#include "CoyWolf.h"

int main() {
	riserva::Riserva r;

	shared_ptr<cacciatori::Cacciatore> c1(new cacciatori::Cacciatore("Mario"));
	shared_ptr<cacciatori::Cacciatore> c2(new cacciatori::Cacciatore("Claudio"));
	shared_ptr<cacciatori::Cacciatore> c3(new cacciatori::Cacciatore("Laura"));
	shared_ptr<cacciatori::Cacciatore> c4(new cacciatori::Cacciatore("Ginevra"));

	r.addCacciatore(c1);
	r.addCacciatore(c2);
	r.addCacciatore(c3);
	r.addCacciatore(c4);

	cout << "Prova overload << di un Cacciatore" << endl;
	cout << *c2 << endl; //si può fare solo su cacciatore che fa overload di << (sugli animali no)

	shared_ptr<animali::Lupo> a1(new animali::Lupo(28.4f, true, 12));
	shared_ptr<animali::CoyWolf> a2(new animali::CoyWolf(18.0f, false, "38.57, -79.79", 2, 20, 44));
	shared_ptr<animali::Coyote> a3(new animali::Coyote(12.0f, true, "38.50, -79.71", 1, 11, 4));
	cout << "Prova ululato di un CoyWolf" << endl;
	a2->ulula();
	cout << endl;
	r.addAnimale(a1);
	r.addAnimale(a1);
	r.addAnimale(a2);//Segnala errore
	r.addAnimale(a3);

	//Prima stampa animali (prima della caccia)
	cout << "Stampa lista animali prima della caccia" << endl;
	cout << r.animaliToString() << endl;

	r.uccidi("C1", "A1");
	r.uccidi("C2", "A2");
	r.uccidi("C2", "A2");//Segnala errore
	r.uccidi("C3", "A3");

	//Seconda stampa animali (dopo la caccia)
	cout << "Stampa lista animali dopo la caccia" << endl;
	cout << r.animaliToString() << endl;

	//Stampa
	cout << "Stampa lista cacciatori dopo la caccia" << endl;
	cout << r.cacciatoriToString() << endl;

	list<shared_ptr<cacciatori::Cacciatore>> migliori = r.cacciatoriMigliori();
	cout << "TRE MIGLIORI CACCIATORI" << endl;
	for(auto i = migliori.begin(); i != migliori.end(); ++i) {
		cout << **i << endl;
	}

	return 0;
}
