package it.test1.HR.service;

import it.test1.HR.data.model.Country;
import it.test1.HR.data.response.GenericResponse;
import java.util.List;

public interface CountryService {

  Country getById(String id);

  public List<Country> getAll();

  //public Country save(Country country);

  GenericResponse saved(Country country);

  public GenericResponse update(Country country);

  public GenericResponse deleteById(String id);

  public void delete(Country country);

  public void deleteAll();

}
