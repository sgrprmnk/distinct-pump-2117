package worldTourist.dao;
import worldTourist.exception.AdminException;
import worldTourist.exception.BusException;
import worldTourist.exception.ContactException;
import worldTourist.exception.CustomerException;
import worldTourist.model.Admin;
import worldTourist.model.Bus;


public interface AdminDao {
public Admin signInAdmin(String username, String password) throws AdminException;
public String addBusDetails(Bus bus) throws BusException;
public String assignBus(int busId, int id,int conid) throws BusException, CustomerException, ContactException;

}
