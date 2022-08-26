package it.test1.HR.data.dto;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.model.Region;
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
public class RegionDto implements Dto {

  private Integer id;
  private String regionName;


  @Override
  public Region toModel() {
    return Region.builder().id(id).regionName(regionName).build();
  }
}
