package it.test1.HR.controller;

import it.test1.HR.data.dto.CountryDto;
import it.test1.HR.data.model.Country;
import it.test1.HR.data.request.country.CountryInsertRequest;
import it.test1.HR.data.request.country.CountryUpdateRequest;
import it.test1.HR.data.response.GenericResponse;
import it.test1.HR.service.CountryService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

  private final CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping
  public List<CountryDto> getAll() {

    return countryService.getAll().stream()
        .map(Country::toDto)
        .collect(Collectors.toList());

  }

  @GetMapping("/{id}")
  public Country getById(@PathVariable String id) {
    return countryService.getById(id);
  }

  @PostMapping
  public GenericResponse save(@RequestBody CountryInsertRequest request) {
    return countryService.saved(request.toCountries());
  }

  @PutMapping
  public GenericResponse update(@RequestBody CountryUpdateRequest request) {
    return countryService.update(request.toCountries());
  }

  @DeleteMapping("/{id}")
  public GenericResponse deleteByID(@PathVariable String id) {
    return countryService.deleteById(id);
  }

}


