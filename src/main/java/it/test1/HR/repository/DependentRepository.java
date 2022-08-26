package it.test1.HR.repository;

import it.test1.HR.data.model.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository extends JpaRepository<Dependent, Integer> {

}