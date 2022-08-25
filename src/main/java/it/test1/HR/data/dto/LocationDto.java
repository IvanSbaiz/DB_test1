package it.test1.HR.data.dto;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.dto.CountryDto;
import it.test1.HR.data.model.Department;
import it.test1.HR.data.model.Location;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto implements Dto {

  private Integer id;
  private String streetAddress;
  private String postalCode;
  private String city;
  private String stateProvince;
  private CountryDto country;
  private Set<Department> departments = new LinkedHashSet<>();

  @Override
  public Location toModel() {
    return Location.builder().id(id).streetAddress(streetAddress).postalCode(postalCode).city(city).stateProvince(stateProvince).country(country.toModel())
        .departments(toModel().getDepartments()).build();
  }
}
