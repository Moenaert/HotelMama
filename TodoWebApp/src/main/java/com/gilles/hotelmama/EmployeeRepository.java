package com.gilles.hotelmama;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    //Type your wanted parameter eg: List<Employee> followed by CTRL+Space for easy Querying
    List<Employee> findEmployeesByLastNameContaining(String str);
}