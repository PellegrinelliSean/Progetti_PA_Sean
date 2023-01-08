#ifndef RISERVA_H_
#define RISERVA_H_

#include "Cacciatore.h"
#include "Animale.h"

namespace riserva {

class Riserva {
private:
	list<shared_ptr<animali::Animale>> animali;
	list<shared_ptr<cacciatori::Cacciatore>> cacciatori;

public:
	string animaliToString();
	string cacciatoriToString();

	void addAnimale(shared_ptr<animali::Animale> animale);
	void addCacciatore(shared_ptr<cacciatori::Cacciatore> cacciatore);

	void uccidi(string idC, string idA);

	list<shared_ptr<cacciatori::Cacciatore>> cacciatoriMigliori();
};

} /* namespace riserva */

#endif /* RISERVA_H_ */
