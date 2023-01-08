#include "Animale.h"

namespace animali {

int Animale::count = 0; //inizializzazioe variabile statica

Animale::Animale(float peso, bool genere, int eta): id("A" + to_string(++count)), eta(eta), peso(peso), maschio(genere), vivo(true) { }

Animale::~Animale() { }

const string& Animale::getId() const { return id; }

int Animale::getEta() const { return eta; }

void Animale::invecchia() { eta++;  }

const bool Animale::isMaschio() const { return maschio; }

float Animale::getPeso() const { return peso; }

void Animale::setPeso(float p) { peso = p; }

bool Animale::isVivo() const { return vivo; }

void Animale::setVivo(bool vivo) { this->vivo = vivo; }

string Animale::toString() {
	string s =  id + "\n";
	s += "   mesi = " + to_string(eta) + "\n";
	s += "   peso = " + to_string(peso) + " kg\n";
	s += "   sesso = " + string(maschio? "maschio\n" : "femmina\n");
	s += "   vivo = " + string(vivo? "sì\n" : "no\n");
	return s;
}

} /* namespace animali */
