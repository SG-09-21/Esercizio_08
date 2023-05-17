package it.corso.service;

import java.util.List;

import it.corso.model.Bilancio;

public interface BilancioService {
	void registraMovimento(Bilancio bilancio);
	Bilancio getMovimentoById(int id);
	List<Bilancio> getMovimenti();
	void cancellaMovimento(Bilancio bilancio);
	double estrattoConto(List<Bilancio> bilancio);
}
