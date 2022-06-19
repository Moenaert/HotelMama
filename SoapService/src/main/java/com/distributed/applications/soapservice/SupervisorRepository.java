package com.distributed.applications.soapservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupervisorRepository extends CrudRepository<Supervisor, Long> {
    List<Supervisor> findSupervisorsByLastNameContaining(String str);
}
