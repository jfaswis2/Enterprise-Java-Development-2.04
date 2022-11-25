import org.example.Person;
import org.example.PersonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javax.naming.InvalidNameException;
import static org.junit.jupiter.api.Assertions.*;

public class TestPersonList {
    Person person1;
    PersonList list;

    @BeforeEach
    void setObjects(){
        person1 = new Person(1,"Jhon Aristizabal", 25,"Student");
        list = new PersonList();
    }

    //EJERCICIO 1
    @Test
    @DisplayName("Comprobar que la edad no debe de ser menos de 0")
    void checkAgeBelow(){
        //El primer argumento es el error que esperamos recibir
        assertThrows(IllegalArgumentException.class, ()-> person1.setAge(-1));
    }

    //EJERCICIO 2
    @Test
    @DisplayName("Comprobar que le nombre esta correctamente formateado")
    void checkNameFormat(){
        assertThrows(IllegalArgumentException.class,()-> list.findByName("Pepito"));
    }

    @Test
    @DisplayName("El nombre si esta en la lista")
    void nameIsInList() throws InvalidNameException {
        assertEquals(person1.getName(), list.findByName("Jhon Aristizabal").getName());
    }

    @Test
    @DisplayName("El nombre NO esta en la lista")
    void name_is_not_in_list(){
        assertThrows(IllegalArgumentException.class, ()-> list.findByName("asd asda"));
    }

    //EJERCICIO 3
    @Test
    @DisplayName("Comprobar que el id es diferente")
    void checkId() {
        assertEquals(2, Person.clone(person1).getId());
    }

    @Test
    @DisplayName("Comprobar que el clon es correcto")
    void checkClone() {
        assertEquals(person1, Person.clone(person1));
    }
}
