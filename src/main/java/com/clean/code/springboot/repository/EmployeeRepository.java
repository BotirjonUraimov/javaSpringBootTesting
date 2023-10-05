package com.clean.code.springboot.repository;

import com.clean.code.springboot.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

List<Employee> findByName(String name);
List<Employee> findByNameAndLastName(String name, String lastName);

//example by Query it equals -> List<Employee> findByName(String name);
@Query("select e from Employee e WHERE e.name = :name")
List<Employee> findByNameQuery(@Param("name") String name);

//example by Native Query it also equals -> List<Employee> findByName(String name);
@Query(value = "SELECT * FROM  employee e WHERE e.name = :name", nativeQuery = true)
List<Employee> findByNameQueryNative(@Param("name") String name);

List<Employee> findAllByNameLike(String name);

@Query(value = "SELECT * FROM  employee e WHERE e.name like CONCAT('%', :name, '%')", nativeQuery = true)
List<Employee> findByNameLikeQueryNative(@Param("name") String name);




}
