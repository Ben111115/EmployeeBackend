package com.getarrays.employeemanager.repo;

import com.getarrays.employeemanager.model.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(long id);

    Optional<Employee> findEmployeeById(long id);
}
