package implement;

import entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getMaintenanceWorkers() throws RemoteException {
        PersonDAO personDAO = new PersonImpl();
        List<Person> persons = personDAO.getMaintenanceWorkers("conference");
        persons.forEach(person -> {
            System.out.println(person);
        });
        assertEquals(1, personDAO.getMaintenanceWorkers("conference").size());
    }
}