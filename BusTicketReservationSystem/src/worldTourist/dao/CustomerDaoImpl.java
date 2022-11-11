package worldTourist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import worldTourist.model.Bus;
import worldTourist.model.Customer;
import worldTourist.utility.DbUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public String registerCustomer(Customer customer) {
String message="Not added";
		
		try(Connection conn=DbUtil.provideConnection()) {
			
	PreparedStatement ps= conn.prepareStatement("insert into Contact (name,phone) values(?,?)");
	ps.setString(1,customer.getUsername());
	ps.setString(2, customer.getPassword());
	
	int x=ps.executeUpdate();
	
	if(x>0) {
		message="Customer Registered Successfully";
	}
			
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
		}
		return message;
	}

	@Override
	public Customer signInCustomer(String username, String password) {
		Customer customer =null;
		try(Connection conn=DbUtil.provideConnection()) {
			
		PreparedStatement ps=	conn.prepareStatement("select * from Customer where username=? AND password=?");
		
		ps.setString(1,username);
		ps.setString(2, password);
	ResultSet rs=	ps.executeQuery();
	
	if(rs.next()) {
		String user=rs.getString("username");
		String pass=rs.getString("password");
		
		customer =new Customer(user,pass);
	} else {
		System.out.println("Invalid User credentials!");
	}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return customer;
	}

	
	
	@Override
	public String bookBus(int BusId, int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelBus(int BusId, int cid, int conid) {
		String message ="Not Cancelled";
		try(Connection conn=DbUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement(" delete from bus_booking where id=? AND conid=? AND busId=?");
			ps.setInt(1, cid);
			ps.setInt(2, conid);
			ps.setInt(3, BusId);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Booking Cancelled Successfully");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
		}
		
		return message;
	}

	@Override
	public List<Bus> getAllBusMatch(String source, String destination) {
		List<Bus> buses =new ArrayList<>();
		try(Connection conn=DbUtil.provideConnection()) {
	PreparedStatement ps=		conn.prepareStatement("select * from Bus where sourceTravel=? AND destinationTravel=?");
	
	ps.setString(1, source);
	ps.setString(2, destination);
	
	ResultSet rs=ps.executeQuery();
	
	while(rs.next()) {
		int bid=rs.getInt("busId");
		String bname=rs.getString("busName");
		int seats=rs.getInt("seats");
		String broute=rs.getString("busRoute");
		String sTravel=rs.getString("sourceTravel");
		String dTravel=rs.getString("destinationTravel");
		String btype =rs.getString("busType");
		
		Bus bus=new Bus(bid,bname,broute,btype,seats,sTravel,dTravel);
		buses.add(bus);
		
	}
		} catch (SQLException e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return buses;
	}

}
