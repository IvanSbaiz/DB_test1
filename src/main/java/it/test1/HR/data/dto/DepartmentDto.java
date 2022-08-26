package it.test1.HR.data.dto;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.model.Department;
import it.test1.HR.data.model.Location;
import java.io.Serializable;
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

  @Override
  public Department toModel() {
    return Department.builder().id(id).departmentName(departmentName).location(location.toModel()).build();
  }
}
