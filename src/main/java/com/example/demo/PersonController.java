package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/persons")

public class PersonController {

    private PersonService repository;

    @GetMapping("/{id}")
    Person readPerson(@PathVariable Long id) {
        return this.repository.findById(id)
                .orElseThrow(PersonNotFoundException::new);
    }

    @PostMapping
    ResponseEntity addPerson(@RequestBody Person person){
        Person result = this.repository.save(person);
       // URI location = ServletUriComponentsBuilder
         //       .fromCurrentRequest()
           //     .path("/{id}")
             //   .buildAndExpand(result.getId())
               // .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    Person updatePerson(@RequestBody Person person) {
        return this.repository.update(person)
                .orElseThrow(PersonNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Long id) {
        this.repository.delete()
                .orElseThrow(PersonNotFoundException::new);
    }
}
