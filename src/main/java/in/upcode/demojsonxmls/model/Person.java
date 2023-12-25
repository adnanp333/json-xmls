package in.upcode.demojsonxmls.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    private Integer id;

    private String name;
    private int age;



    @Override
    public String toString() {
        return name + "with age: "+ age;
    }
}
