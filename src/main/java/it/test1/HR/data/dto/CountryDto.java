package it.test1.HR.data.dto;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.model.Country;
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
public class CountryDto implements Dto {

  private String id;
  private String countryName;
  private RegionDto region;


  @Override
  public Country toModel() {
    return Country.builder().id(id).countryName(countryName).region(region.toModel()).build();
  }
}
