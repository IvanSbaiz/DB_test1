package it.test1.HR.data.model;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.dto.DependentDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "dependents")
public class Dependent implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dependent_id", nullable = false)
  private Integer id;

  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;

  @Column(name = "relationship", nullable = false, length = 25)
  private String relationship;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "employee_id", nullable = false)
  private Employee employee;

  @Override
  public DependentDto toDto() {
    return DependentDto.builder().id(id).firstName(firstName).lastName(lastName).relationship(relationship).employee(employee.toDto()).build();
  }
}