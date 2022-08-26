package it.test1.HR.data.request.country;

import it.test1.HR.data.dto.RegionDto;
import it.test1.HR.data.model.Country;
import it.test1.HR.data.model.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryInsertRequest {

  private String id;
  private String countryName;
  private Integer idRegion;

  public Country toCountries() {
    Region region = new Region();
    region.setId(idRegion);
    return Country.builder().id(id).countryName(countryName).region(region).build();
  }
  
}
