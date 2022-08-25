package it.test1.HR.data.dto;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.dto.LocationDto;
import it.test1.HR.data.model.Department;
import it.test1.HR.data.model.Employee;
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
public class DepartmentDto implements Dto {

  private Integer id;
  private String departmentName;
  private LocationDto location;
  private Set<Employee> employees = new LinkedHashSet<>();

  @Override
  public Department toModel() {
    return Department.builder().id(id).departmentName(departmentName).location(location.toModel()).employees(toModel().getEmployees()).build();
  }
}
