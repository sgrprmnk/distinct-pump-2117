package worldTourist.dao;
import worldTourist.model.Admin;
import worldTourist.model.Bus;


public interface AdminDao {
public Admin signInAdmin(String username, String password);
public String addBusDetails(Bus bus);
public String assignBus(int cid, int busId, int conid);

}
