package worldTourist.dao;



import java.util.List;

import worldTourist.exception.BusException;
import worldTourist.exception.ContactException;
import worldTourist.exception.CustomerException;
import worldTourist.model.Bus;
import worldTourist.model.Customer;

public interface CustomerDao {

	public String registerCustomer(Customer customer) throws CustomerException;
	public Customer signInCustomer(String username, String password) throws CustomerException;
	
	public String bookBus(int BusId,int cid) throws CustomerException,BusException;
	public String cancelBus(int BusId, int cid, int conid) throws CustomerException, BusException, ContactException;
	
	public List<Bus> getAllBusMatch(String source, String destination) throws BusException;
	//public Contact getAllBusMatch(int conid);
	//public String checkCnfirmation(int cid);
	
}
