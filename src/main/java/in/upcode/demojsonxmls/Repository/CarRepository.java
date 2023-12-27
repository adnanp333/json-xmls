package in.upcode.demojsonxmls.Repository;

import in.upcode.demojsonxmls.model.Car;
import in.upcode.demojsonxmls.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByOwnerId(Integer ownerId);
}
