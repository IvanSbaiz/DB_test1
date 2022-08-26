package it.test1.HR.data.dto;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.model.Dependent;
import it.test1.HR.data.model.Employee;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DependentDto implements Dto {

  private Integer id;
  private String firstName;
  private String lastName;
  private String relationship;
  private EmployeeDto employee;

  @Override
  public Dependent toModel() {
    return Dependent.builder().id(id).firstName(firstName).lastName(lastName)
        .relationship(relationship).employee(employee.toModel()).build();
  }
}
