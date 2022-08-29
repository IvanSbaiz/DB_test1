package it.test1.HR.service.impl;

import it.test1.HR.data.model.Country;
import it.test1.HR.data.model.Region;
import it.test1.HR.data.response.GenericResponse;
import it.test1.HR.repository.CountryRepository;
import it.test1.HR.repository.LocationRepository;
import it.test1.HR.repository.RegionRepository;
import it.test1.HR.service.CountryService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CountryImpl implements CountryService {

  private CountryRepository countryRepository;
  private LocationRepository locationRepository;
  private RegionRepository regionRepository;

  public CountryImpl(CountryRepository countryRepository, LocationRepository locationRepository,
      RegionRepository regionRepository) {
    this.countryRepository = countryRepository;
    this.locationRepository = locationRepository;
    this.regionRepository = regionRepository;
  }

  @Override
  public Country getById(String id) {
    Optional<Country> country = countryRepository.findById(id);
    if (country.isPresent()) {
      return country.get();
    }
    return null;
  }


  @Override
  public List<Country> getAll() {
    return countryRepository.findAll();
  }






  @Override
  public GenericResponse saved(Country country) {

    GenericResponse response = new GenericResponse();

    Optional<Region> region = regionRepository.findById(country.getRegion().getId());
    if (region.isPresent()) {

      country.setRegion(region.get());

      Country countrySaved = countryRepository.save(country);
      response.setBody(countrySaved.toDto());
      response.setStatusCode(HttpStatus.CREATED);
      response.setMessage("Country saved");

    } else {
      response.setStatusCode(HttpStatus.NOT_FOUND);
      response.setMessage("Region not found");

    }

    return response;
  }

  @Override
  public GenericResponse update(Country country) {

    GenericResponse response = new GenericResponse();

    if (countryRepository.findById(country.getId()).isPresent()) {

      Optional<Region> region = regionRepository.findById(country.getRegion().getId());
      if (region.isPresent()) {

        country.setRegion(region.get());
        response.setBody(countryRepository.save(country).toDto());
        response.setStatusCode(HttpStatus.OK);
        response.setMessage("Country updated");

      } else {
        response.setStatusCode(HttpStatus.NOT_FOUND);
        response.setMessage("Error update. Country not found");
      }
    }

      return response;
    }



  @Override
  public GenericResponse deleteById(String id) {

    GenericResponse response = new GenericResponse();

    countryRepository.deleteById(id);
    response.setStatusCode(HttpStatus.OK);
    response.setMessage("Country deleted");

    return response;
  }

  @Override
  public void delete(Country country) {
    countryRepository.delete(country);

  }

  @Override
  public void deleteAll() {
    countryRepository.deleteAll();

  }

}
