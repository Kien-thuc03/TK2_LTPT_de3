package server;

import implement.FacilityDAO;
import implement.FacilityImpl;
import implement.PersonDAO;
import implement.PersonImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * @description
 * @author: nktng,
 * @date:18/04/2024,
 */
public class Server {
    private static final String URL = "rmi://FIL:8611/";

    public static void main(String[] args) {
        try {
            Context context = new InitialContext();

            FacilityDAO facilityDAO = new FacilityImpl();

            PersonDAO personDAO = new PersonImpl();

            LocateRegistry.createRegistry(8611);

            context.bind(URL + "facilityDAO", facilityDAO);
            context.bind(URL + "personDAO", personDAO);

            System.out.println("Server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
