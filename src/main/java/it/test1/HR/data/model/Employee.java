package it.test1.HR.data.model;

import it.test1.HR.data.archetype.Dto;
import it.test1.HR.data.archetype.Model;
import it.test1.HR.data.dto.EmployeeDto;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "employees")
public class Employee implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employeeId", nullable = false)
  private Integer id;

  @Column(name = "firstName", length = 20)
  private String firstName;

  @Column(name = "lastName", nullable = false, length = 25)
  private String lastName;

  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @Column(name = "phoneNumber", length = 20)
  private String phoneNumber;

  @Column(name = "hireDate", nullable = false)
  private LocalDate hireDate;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "jobId", nullable = false)
  private Job job;

  @Column(name = "salary", nullable = false, precision = 8, scale = 2)
  private BigDecimal salary;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "managerId")
  private Employee manager;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "departmentId")
  private Department department;

  @OneToMany(mappedBy = "manager")
  private Set<Employee> employees = new LinkedHashSet<>();

  @Override
  public EmployeeDto toDto() {
    return EmployeeDto.builder().id(id).firstName(firstName).lastName(lastName).email(email).phoneNumber(phoneNumber).hireDate(hireDate)
        .job(job.toDto()).salary(salary).manager(manager).department(department.toDto()).employees(toDto().getEmployees()).build();
  }
}