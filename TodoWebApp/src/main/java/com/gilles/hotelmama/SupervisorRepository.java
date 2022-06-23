package com.gilles.hotelmama;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupervisorRepository extends CrudRepository<Supervisor, Long> {

    //Very simple querying using CTRL+Space !
    Supervisor findSupervisorByFirstNameContaining(String str);
    Supervisor findSupervisorById(Long id);

}