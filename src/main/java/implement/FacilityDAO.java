package implement;

import entity.Facility;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface FacilityDAO extends Remote {
    public boolean updateFacility(Facility facilityNewInfor) throws RemoteException;
    public Facility getFacilityById(String id) throws RemoteException;
    public Map<Facility,Long> countMaintenance() throws RemoteException;
}
