package worldTourist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import worldTourist.exception.BusException;
import worldTourist.exception.ContactException;
import worldTourist.exception.CustomerException;
import worldTourist.model.Bus;
import worldTourist.model.BusCustomerDTO;
import worldTourist.model.Customer;
import worldTourist.utility.DbUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public String registerCustomer(Customer customer) throws CustomerException{
String message="Not added";
		
		try(Connection conn=DbUtil.provideConnection()) {
			
	PreparedStatement ps= conn.prepareStatement("insert into Customer (username,password,sourceOfTravel,destinationOfTravel) values(?,?,?,?)");
	ps.setString(1,customer.getUsername());
	ps.setString(2, customer.getPassword());
	ps.setString(3, customer.getSourceOfTravel());
	ps.setString(4, customer.getDestinationOfTravel());
	
	int x=ps.executeUpdate();
	
	if(x>0) {
		message="Customer Registered Successfully";
	}
			
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
			throw new CustomerException(e.getMessage());
		}
		return message;
	}

	@Override
	public Customer signInCustomer(String username, String password) throws CustomerException{
		Customer customer =null;
		try(Connection conn=DbUtil.provideConnection()) {
			
		PreparedStatement ps=	conn.prepareStatement("select * from Customer where username=? AND password=?");
		
		ps.setString(1,username);
		ps.setString(2, password);
	ResultSet rs=	ps.executeQuery();
	
	if(rs.next()) {
		String user=rs.getString("username");
		String pass=rs.getString("password");
		String source=rs.getString("sourceOfTravel");
		String destina=rs.getString("destinationOfTravel");
		
		
		customer =new Customer(user,pass,source,destina);
		
		
	} else {
		System.out.println("Invalid User credentials!");
	}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		return customer;
	}

	
	
	@Override
	public String bookBus(int BusId, int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelBus(int BusId, int cid, int conid) throws BusException{
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
			throw new BusException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Bus> getAllBusMatch(String source, String destination) throws BusException{
		List<Bus> buses =new ArrayList<>();
		try(Connection conn=DbUtil.provideConnection()) {
	PreparedStatement ps=conn.prepareStatement("select * from Bus where sourceTravel=? AND destinationTravel=?");
	
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
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new BusException(e.getMessage());
		}
		
		return buses;
	}

	@Override
	public List<BusCustomerDTO> getConfirmation(int id) throws BusException, CustomerException, ContactException {
		List<BusCustomerDTO> dtos=new ArrayList<>();
		try(Connection conn=DbUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement
					("select b.busId,b.busName,b.busRoute,b.busType, co.id,co.name,co.phone from Bus b INNER JOIN Contact co INNER JOIN Customer c INNER JOIN bus_booking bk ON\r\n"
							+ "b.busId=bk.busId AND co.id=bk.conid AND c.id=?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				BusCustomerDTO dto=new BusCustomerDTO();
				dto.setBusId(rs.getInt("busId"));
				dto.setBusName(rs.getString("busName"));
				dto.setBroute(rs.getString("busRoute"));
				dto.setBtype(rs.getString("busType"));
				
				dto.setConid(rs.getInt("id"));
				dto.setConName(rs.getString("name"));
				dto.setCphone(rs.getString("phone"));
				dtos.add(dto);
				
			}
			if(dtos.size()==0) {
				throw new BusException("No seats confirmed for the customer");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BusException(e.getMessage());
		}
		return dtos;
	}

	

}
