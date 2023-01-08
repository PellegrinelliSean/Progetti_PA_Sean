#ifndef ANIMALE_H_
#define ANIMALE_H_

#include <iostream>
#include <string>

using namespace std;

namespace animali {

class Animale {
private:
	static int count; //conteggio delle istanze

protected:
	const string id;
	int eta; //età dell'animale in mesi
	float peso;
	const bool maschio; //1 se è maschio 0 se è femmina
	bool vivo;

public:
	Animale(float peso, bool genere, int eta = 0);
	virtual ~Animale();

	const string& getId() const;

	int getEta() const;

	void invecchia();

	const bool isMaschio() const;

	float getPeso() const;

	void setPeso(float p);

	bool isVivo() const;

	void setVivo(bool vivo);

	virtual string toString();

	//setta l'animale come morto e restituisce il punteggio
	//da assegnare al cacciatore
	virtual int cacciato() = 0;
};

} /* namespace animali */

#endif /* ANIMALE_H_ */
