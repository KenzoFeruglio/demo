package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface PersonService extends CrudRepository<Person, Long> {}


