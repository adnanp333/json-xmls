package in.upcode.demojsonxmls.controller;


import in.upcode.demojsonxmls.Repository.PersonRepository;
import in.upcode.demojsonxmls.model.Person;
import in.upcode.demojsonxmls.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {


    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;




//    @RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
//    List<Person> listOfAllPersonInXml(){
//        return personRepository.findAll(Sort.by("name"));
//    }

    @GetMapping("")
    List<Person> listOfAllPersons(@RequestParam(value = "name", required = false) String name){
        if (name == null)
           return personRepository.findAll();
        return personRepository.findByName(name);
    }

    @GetMapping("/{id}")
    ResponseEntity getAPersonWithID(@PathVariable("id")Integer id){
        final Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return ResponseEntity.ok(optionalPerson.get());
        }
        return ResponseEntity.badRequest().body("could not find any person:");
    }

//    @RequestMapping("/name/{name}")
//    Person getMeAPersonWithID(@PathVariable("name")String name){
//        System.out.println(name);
//        final Optional<Person> optionalPerson = personRepository.findByNameIgnoreCase(name);
//        if (optionalPerson.isPresent()) {
//            return optionalPerson.get();
//        }
//        throw new RuntimeException("not found!!!");
//    }

    @PutMapping(value = "/{id}")
    ResponseEntity updateAPersonWithID(@PathVariable("id")Integer id, @RequestBody Person person){
//        System.out.println(person);
//        System.out.println("====,-===");

//        final Optional<Person> optionalPerson = personRepository.findById(id);
//        if (optionalPerson.isEmpty()) {
//            return ResponseEntity.badRequest().body("could not find any person.... ");
//        }
//        Person existingPerson = optionalPerson.get();
//        existingPerson.setName(person.getName());
//        existingPerson.setAge(person.getAge());

        return personService.updateAndSavePerson(id, person);


    }
}
