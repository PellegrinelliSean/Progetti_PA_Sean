#ifndef COYOTE_H_
#define COYOTE_H_

#include "Animale.h"

namespace animali {

struct Tana {
	string coordinate;
	int nIngressi;
	double dimensione; //in m^2
	Tana(string c, int n, double d) {
		coordinate = c;
		nIngressi = n;
		dimensione = d;
	}
};

class Coyote : virtual public Animale {
protected:
	Tana* tana;
public:
	Coyote(float peso, bool genere, string c, int n, double d, int eta = 0): Animale(peso, genere, eta) {
		tana = new Tana(c, n, d);
	}
	virtual ~Coyote(){ delete tana; }
	int cacciato();
	string toString();
};

inline int Coyote::cacciato() {
	vivo = false;
	return 5;
}

inline string Coyote::toString() {
	return "Coyote " + Animale::toString() + "   Posizione tana (in gradi decimali) = " + tana->coordinate + "\n";
}


} /* namespace animali */



#endif /* COYOTE_H_ */
