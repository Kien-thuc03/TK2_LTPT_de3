package implement;

import entity.Facility;
import entity.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FacilityImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updateFacility() throws RemoteException {
        FacilityDAO facilityDAO = new FacilityImpl();
        Facility facility = facilityDAO.getFacilityById("F001");
        facility.setDescription("abc");
        facility.setPrice(900);
        facility.setLocation("Floor 1");
        facility.setStatus(Status.AVAILABLE);
        assertTrue(facilityDAO.updateFacility(facility));
    }

    @Test
    void countMaintenance() throws RemoteException {
        FacilityDAO facilityDAO = new FacilityImpl();
        Map<Facility, Long> map = facilityDAO.countMaintenance();
        map.entrySet().forEach(entry -> {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        });

    }
}