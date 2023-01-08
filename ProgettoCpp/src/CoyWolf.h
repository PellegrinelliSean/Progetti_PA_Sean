#ifndef COYWOLF_H_
#define COYWOLF_H_

#include "Lupo.h"
#include "Coyote.h"

namespace animali {

class CoyWolf : public Lupo, public Coyote {
public:
	CoyWolf(float peso, bool genere, string c, int n, double d, int eta = 0) :
		Animale(peso, genere, eta), Lupo(peso, genere, eta), Coyote(peso, genere, c, n, d, eta) { }
	virtual ~CoyWolf(){}
	int cacciato();
	string toString();
};

inline int CoyWolf::cacciato() {
	vivo = false;
	return 20;
}

inline string CoyWolf::toString() {
	return "CoyWolf " + Coyote::toString().erase(0, 7);
}

} /* namespace animali */

#endif /* COYWOLF_H_ */
