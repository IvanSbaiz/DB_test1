package it.test1.HR.data.dto;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.model.Employee;
import it.test1.HR.data.model.Job;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class JobDto implements Dto {

  private Integer id;
  private String jobTitle;
  private BigDecimal minSalary;
  private BigDecimal maxSalary;
  private Set<Employee> employees = new LinkedHashSet<>();

  @Override
  public Job toModel() {
    return Job.builder().id(id).jobTitle(jobTitle).minSalary(minSalary).maxSalary(maxSalary)
        .employees(toModel().getEmployees()).build();
  }
}
