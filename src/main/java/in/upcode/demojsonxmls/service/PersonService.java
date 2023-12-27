package in.upcode.demojsonxmls.service;


import in.upcode.demojsonxmls.Repository.CarRepository;
import in.upcode.demojsonxmls.Repository.PersonRepository;
import in.upcode.demojsonxmls.model.Car;
import in.upcode.demojsonxmls.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    CarRepository carRepository;



    public ResponseEntity<?> updateAndSavePerson(Integer id, Person person){

        final Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
           return ResponseEntity.badRequest().body("could not find any person.... ");
        }
        Person existingPerson = optionalPerson.get();
        existingPerson.setName(person.getName());
        existingPerson.setAge(person.getAge());
        return ResponseEntity.ok(personRepository.save(existingPerson));
    }

    public List<Car> getAllCarOwnedBy(Integer id){
       return carRepository.findAllByOwnerId(id);
    }
}
