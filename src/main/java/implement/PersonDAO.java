package implement;

import entity.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface PersonDAO extends Remote {
    public List<Person> getMaintenanceWorkers(String facilityName) throws RemoteException;

}
