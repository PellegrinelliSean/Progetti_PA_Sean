#ifndef LUPO_H_
#define LUPO_H_

#include "Animale.h"

namespace animali {

class Lupo : virtual public Animale {
public:
	Lupo(float peso, bool genere, int eta = 0): Animale(peso, genere, eta) { }
	virtual ~Lupo(){}
	void ulula();
	int cacciato();
	string toString();
};

//metodo dummy utile solo a caratterizzare un lupo da un generico animale
inline void Lupo::ulula() {
	cout << "auuuuhhh!" << endl;
}

inline int Lupo::cacciato() {
	vivo = false;
	return 10;
}

inline string Lupo::toString() {
	return "Lupo " + Animale::toString();
}


} /* namespace animali */

#endif /* LUPO_H_ */
