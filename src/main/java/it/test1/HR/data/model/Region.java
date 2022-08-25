package it.test1.HR.data.model;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.dto.RegionDto;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "regions")
public class Region implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "regionId", nullable = false)
  private Integer id;

  @Column(name = "regionName", length = 25)
  private String regionName;

  @OneToMany(mappedBy = "region")
  private Set<Country> countries = new LinkedHashSet<>();

  @Override
  public RegionDto toDto() {
    return RegionDto.builder().id(id).regionName(regionName).countries(toDto().getCountries()).build();
  }
}