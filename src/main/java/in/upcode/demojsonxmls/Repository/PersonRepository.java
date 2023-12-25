package in.upcode.demojsonxmls.Repository;

import in.upcode.demojsonxmls.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);

    List<Person> findByNameIgnoreCase(String name);
}
