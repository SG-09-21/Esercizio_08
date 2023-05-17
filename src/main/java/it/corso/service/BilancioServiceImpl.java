package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.BilancioDao;
import it.corso.model.Bilancio;

@Service
public class BilancioServiceImpl implements BilancioService {

	@Autowired
	BilancioDao bilancioDao;
	
	
	@Override
	public void registraMovimento(Bilancio bilancio) {
		bilancioDao.save(bilancio);
	}

	@Override
	public Bilancio getMovimentoById(int id) {
		Optional<Bilancio> optional = bilancioDao.findById(id);
		if(optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public List<Bilancio> getMovimenti() {
		return (List<Bilancio>) bilancioDao.findAll();
	}

	@Override
	public void cancellaMovimento(Bilancio bilancio) {
		bilancioDao.delete(bilancio);
	}

	@Override
	public double estrattoConto(List<Bilancio> bilancio) {
	    double saldo = 0.0;
	    for (Bilancio operazione : bilancio) {
	        if (operazione.getTipologia().equalsIgnoreCase("deposito")) {
	            saldo += operazione.getImporto();
	        } else if (operazione.getTipologia().equalsIgnoreCase("prelievo")) {
	            saldo -= operazione.getImporto();
	        }
	    }
	    return saldo;
	}


}
