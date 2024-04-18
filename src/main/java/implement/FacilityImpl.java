package implement;

import entity.Facility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: nktng,
 * @date:18/04/2024,
 */
public class FacilityImpl extends UnicastRemoteObject implements FacilityDAO{
    private static final long serialVersionUID = 1L;
    private EntityManager em;
    public FacilityImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLDB").createEntityManager();
    }

    @Override
    public boolean updateFacility(Facility facilityNewInfor) throws RemoteException {
        FacilityDAO facilityDAO = new FacilityImpl();
        Facility existingFacility = facilityDAO.getFacilityById(facilityNewInfor.getId());

        if (existingFacility != null && facilityNewInfor.getPrice() < existingFacility.getPrice()) {
            existingFacility.setDescription(facilityNewInfor.getDescription());
            existingFacility.setPrice(facilityNewInfor.getPrice());
            existingFacility.setStatus(facilityNewInfor.getStatus());
            existingFacility.setLocation(facilityNewInfor.getLocation());

            em.getTransaction().begin();
            em.merge(existingFacility);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Facility getFacilityById(String id) throws RemoteException {
        return em.find(Facility.class, id);
    }

    @Override
    public Map<Facility, Long> countMaintenance() throws RemoteException {
        List<Object[]> results = em.createNamedQuery("Facility.countMaintenance", Object[].class)
                .getResultList();

        Map<Facility, Long> maintenanceCounts = new LinkedHashMap<>();
        for (Object[] result : results) {
            maintenanceCounts.put((Facility) result[0], (Long) result[1]);
        }
        return maintenanceCounts;
    }

}
