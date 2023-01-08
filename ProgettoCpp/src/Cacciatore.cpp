#include "Cacciatore.h"

namespace cacciatori {

int Cacciatore::count = 0; //inizializzazione variabile statica

Cacciatore::Cacciatore(string n): id("C" + to_string(++count)), nome(n), punti(0)  { }

const string& Cacciatore::getId() const {
	return id;
}

const string& Cacciatore::getNome() const {
	return nome;
}

void Cacciatore::setNome(const string& nome) {
	this->nome = nome;
}

int Cacciatore::getPunti() const {
	return punti;
}

void Cacciatore::addPunti(int p) {
	this->punti += p;
}

void Cacciatore::addTrofeo(shared_ptr<animali::Animale> trofeo) {
	this->trofei.push_back(trofeo);
}

//overload dell'operatore <<
ostream& operator<<(ostream& out, const Cacciatore& cacciatore) {
	out << "Cacciatore " << cacciatore.nome << endl;
	out << "   id = " << cacciatore.id << endl;
	out << "   punti = " << cacciatore.punti << endl;
	out << "   numero trofei = " << cacciatore.trofei.size() << endl;
	return out;
}

} /* namespace cacciatori */
