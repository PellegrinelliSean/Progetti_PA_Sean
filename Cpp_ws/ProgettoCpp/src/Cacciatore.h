#ifndef CACCIATORE_H_
#define CACCIATORE_H_

#include <list>
#include <memory>
#include "Animale.h"

using namespace std;

namespace cacciatori {

class Cacciatore {
private:
	static int count; //conteggio delle istanze

	const string id;
	string nome;
	int punti;
	list<shared_ptr<animali::Animale>> trofei;

	friend ostream& operator<<(ostream& os, const Cacciatore& cacciatore);

public:
	Cacciatore(string n);

	const string& getId() const;

	const string& getNome() const;

	void setNome(const string& nome);

	int getPunti() const;

	void addPunti(int punti);

	void addTrofeo(shared_ptr<animali::Animale> trofeo);
};

} /* namespace cacciatori */

#endif /* CACCIATORE_H_ */
