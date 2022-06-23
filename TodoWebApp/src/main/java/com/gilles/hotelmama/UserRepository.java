package com.gilles.hotelmama;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    @NotNull
    Iterable<User> findAll();
}