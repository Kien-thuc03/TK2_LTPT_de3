package implement;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @description
 * @author: nktng,
 * @date:18/04/2024,
 */
public class PersonImpl extends UnicastRemoteObject implements PersonDAO{
    private static final long serialVersionUID = 1L;
    private EntityManager em;
    public PersonImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLDB").createEntityManager();
    }

    @Override
    public List<Person> getMaintenanceWorkers(String facilityName) throws RemoteException {
        return em.createNamedQuery("Maintenance.findByFacilityName", Person.class)
                .setParameter("facilityName", facilityName)
                .getResultList();
    }

}
