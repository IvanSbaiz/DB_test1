package it.test1.HR.data.dto;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.model.Employee;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
public class EmployeeDto implements Dto {

  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private LocalDate hireDate;
  private JobDto job;
  private BigDecimal salary;
  private Employee manager;
  private DepartmentDto department;
  private Set<Employee> employees = new LinkedHashSet<>();

  @Override
  public Employee toModel() {
    return Employee.builder().id(id).firstName(firstName).lastName(lastName).email(email).phoneNumber(phoneNumber).hireDate(hireDate).job(job.toModel())
        .salary(salary).manager(manager).department(department.toModel()).employees(toModel().getEmployees()).build();
  }
}
