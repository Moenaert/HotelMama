package com.distributed.applications.soapservice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {

    @Query(value = "SELECT u.description FROM ToDoEntity u")
    List<String> findAllToDoes(Sort sort);

    ToDoEntity findToDoEntityById(Long id);

}