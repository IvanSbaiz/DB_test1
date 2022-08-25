package it.test1.HR.data.model;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.dto.JobDto;
import java.math.BigDecimal;
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
@Table(name = "jobs")
public class Job implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "jobId", nullable = false)
  private Integer id;

  @Column(name = "jobTitle", nullable = false, length = 35)
  private String jobTitle;

  @Column(name = "minSalary", precision = 8, scale = 2)
  private BigDecimal minSalary;

  @Column(name = "maxSalary", precision = 8, scale = 2)
  private BigDecimal maxSalary;

  @OneToMany(mappedBy = "job")
  private Set<Employee> employees = new LinkedHashSet<>();

  @Override
  public JobDto toDto() {
    return JobDto.builder().id(id).jobTitle(jobTitle).minSalary(minSalary).maxSalary(maxSalary).employees(toDto().getEmployees()).build();
  }
}