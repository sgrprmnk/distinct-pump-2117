package worldTourist.dao;

import java.util.List;

import worldTourist.model.Bus;
import worldTourist.model.Customer;

public interface CustomerDao {

	public String registerCustomer(Customer customer);
	public Customer signInCustomer(String username, String password);
	
	public String bookBus(int BusId,int cid);
	public String cancelBus(int BusId, int cid, int conid);
	
	public List<Bus> getAllBusMatch(String source, String destination);
}
