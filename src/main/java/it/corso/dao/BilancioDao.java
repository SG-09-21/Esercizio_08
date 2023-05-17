package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Bilancio;

public interface BilancioDao extends CrudRepository<Bilancio, Integer>{

}
