package it.test1.HR.data.model;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.dto.CountryDto;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "countries")
public class Country implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "country_id", nullable = false, length = 2)
  private String id;

  @Column(name = "country_name", length = 40)
  private String countryName;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "region_id", nullable = false)
  private Region region;

  @OneToMany(mappedBy = "country")
  private Set<Location> locations = new LinkedHashSet<>();

  @Override
  public CountryDto toDto() {
    return CountryDto.builder().id(id).countryName(countryName).region(region.toDto()).build();
  }
}