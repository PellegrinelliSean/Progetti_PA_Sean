#include "Riserva.h"
#include <sstream>
#include <algorithm>

namespace riserva {

string Riserva::animaliToString() {
	string s = "";
	for(auto i = animali.begin(); i != animali.end(); ++i)
		s += (*i)->toString();
	return s;
}

string Riserva::cacciatoriToString() {
	string s = "";
	for(auto i = cacciatori.begin(); i != cacciatori.end(); ++i) {
		ostringstream oss;
		oss << *(*i) << "\n";
		s += oss.str();
	}
	return s;
}

void Riserva::addAnimale(shared_ptr<animali::Animale> animale) {
	bool found = (find(animali.begin(), animali.end(), animale) != animali.end());
	if(found) {
		cerr << "l'animale specificato è già stato inserito" << endl;
		return;
	}
	animali.push_back(animale);
}

void Riserva::addCacciatore(shared_ptr<cacciatori::Cacciatore> cacciatore) {
	bool found = (find(cacciatori.begin(), cacciatori.end(), cacciatore) != cacciatori.end());
	if(found) {
		cerr << "il cacciatore specificato è già stato inserito" << endl;
		return;
	}
	cacciatori.push_back(cacciatore);
}

void Riserva::uccidi(string idC, string idA) {
	shared_ptr<cacciatori::Cacciatore> cacciatore = nullptr;
	shared_ptr<animali::Animale> animale = nullptr;

	for(auto i = cacciatori.begin(); i != cacciatori.end(); ++i) {
		if((*i)->getId() == idC) {
			cacciatore = *i;
			break;
		}
	}

	for(auto i = animali.begin(); i != animali.end(); ++i) {
		if((*i)->getId() == idA) {
			animale = *i;
			break;
		}
	}

	if(cacciatore == nullptr || animale == nullptr) {
		cerr << "il cacciatore o l'animale specificato non esiste" << endl;
		return;
	}

	if(!animale->isVivo()) {
		cerr << "l'animale è già morto" << endl ;
		return;
	}

	//setta l'animale come morto e aggiunge i punti corrispondenti
	cacciatore->addPunti(animale->cacciato());
	//aggiunge l'animale come trofeo
	cacciatore->addTrofeo(animale);
}

//funzione esterna alla classe per confrontare i cacciatori
//essendo satic ha internal linkage
static bool comparatorByPunti(const shared_ptr<cacciatori::Cacciatore>& a, const shared_ptr<cacciatori::Cacciatore>& b) {
	return a->getPunti() > b->getPunti();
}

//Nota che questo metodo ordina anche la lista originale di cacciatori della riserva
list<shared_ptr<cacciatori::Cacciatore>> Riserva::cacciatoriMigliori() {
	cacciatori.sort(comparatorByPunti);
	list<shared_ptr<cacciatori::Cacciatore>> migliori;

	//Prendo i primi tre elementi della lista (o quelli che ci sono se <3)
	int j = 0;
	for(auto i = cacciatori.begin(); i != cacciatori.end(); ++i, ++j) {
		migliori.push_back(*i);
		if(j == 2) break;
	}

	return migliori;
}

} /* namespace riserva */
