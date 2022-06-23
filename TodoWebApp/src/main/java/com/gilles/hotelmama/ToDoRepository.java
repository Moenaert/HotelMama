package com.gilles.hotelmama;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {

}