package it.test1.HR.data.model;

import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.dto.LocationDto;
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
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "locations")
public class Location implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "location_id", nullable = false)
  private Integer id;

  @Column(name = "street_address", length = 40)
  private String streetAddress;

  @Column(name = "postal_code", length = 12)
  private String postalCode;

  @Column(name = "city", nullable = false, length = 30)
  private String city;

  @Column(name = "state_province", length = 25)
  private String stateProvince;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "country_id", nullable = false)
  private Country country;

  @OneToMany(mappedBy = "location")
  private Set<Department> departments = new LinkedHashSet<>();

  @Override
  public LocationDto toDto() {
    return LocationDto.builder().id(id).streetAddress(streetAddress).postalCode(postalCode)
        .city(city).stateProvince(stateProvince).country(country.toDto()).build();
  }
}