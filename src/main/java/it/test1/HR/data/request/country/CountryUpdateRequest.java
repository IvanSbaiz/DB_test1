package it.test1.HR.data.request.country;

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
public class CountryUpdateRequest {

  private String id;
  private String countryName;
  private int idRegion;

  public Country toCountries() {
    Region region = new Region();
    region.setId(idRegion);
    return Country.builder().id(id).countryName(countryName).region(region).build();
  }


}
