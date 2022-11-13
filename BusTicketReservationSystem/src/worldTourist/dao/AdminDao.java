package worldTourist.dao;
import java.util.List;

import worldTourist.exception.AdminException;
import worldTourist.exception.BusException;
import worldTourist.exception.ContactException;
import worldTourist.exception.CustomerException;
import worldTourist.model.Admin;
import worldTourist.model.Bus;

import worldTourist.model.Customer;


public interface AdminDao {
public Admin signInAdmin(String username, String password) throws AdminException;
public String addBusDetails(Bus bus) throws BusException;
public String assignBus(int busId, int id,int conid) throws BusException, CustomerException, ContactException;
public List<Bus> getAllBus() throws BusException;
public List<Customer> getAllCustomer() throws CustomerException;

}
