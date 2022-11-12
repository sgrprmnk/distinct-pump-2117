package worldTourist.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import worldTourist.exception.AdminException;
import worldTourist.exception.BusException;
import worldTourist.exception.ContactException;
import worldTourist.exception.CustomerException;
import worldTourist.model.Admin;
import worldTourist.model.Bus;
import worldTourist.utility.DbUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin signInAdmin(String username, String password) throws AdminException{
		Admin admin =null;
		try(Connection conn=DbUtil.provideConnection()) {
			
		PreparedStatement ps=	conn.prepareStatement("select * from Admin where username=? AND password=?");
		
		ps.setString(1,username);
		ps.setString(2, password);
	ResultSet rs=	ps.executeQuery();
	
	if(rs.next()) {
		String user=rs.getString("username");
		String pass=rs.getString("password");
		
		admin =new Admin(user,pass);
	} else {
		System.out.println("Invalid User credentials!");
	}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		return admin;
	}

	@Override
	public String addBusDetails(Bus bus) throws BusException{
		String message="Not Assigned";
		try(Connection conn=DbUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into Bus (busId,busName,busRoute,busType,seats,sourceTravel,destinationTravel) values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, bus.getBusId());
			ps.setString(2,bus.getBusName());
			ps.setString(3, bus.getBusRoute());
			ps.setString(4, bus.getBusType());
			
			ps.setInt(5, bus.getSeats());
			ps.setString(6, bus.getSourceTravel());
			ps.setString(7, bus.getSourceDestination());
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Bus Assigned Successfully";
			}
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
			throw new BusException(e.getMessage());
		}
		
		return message;
	}


	@Override
	public String assignBus(int busId, int id,int conid) throws BusException,CustomerException,ContactException {
		
	String	message="Not Confirmed";
		// TODO Auto-generated method stub
		
		try(Connection conn=DbUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from Bus where busId=?");
			ps.setInt(1, busId);
			
			ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		PreparedStatement ps1=	conn.prepareStatement("select * from Customer where id=?");
		
		ps1.setInt(1,id);
		
	ResultSet rs1=	ps1.executeQuery();
	
	if(rs1.next()) {
		PreparedStatement ps2=conn.prepareStatement("select * from contact where id=?");
		ps2.setInt(1, conid);
		
		ResultSet rs2=ps2.executeQuery();
	
		
	if(rs2.next()) {
	PreparedStatement ps3=	conn.prepareStatement("insert into bus_booking (busId,id,conid)  values(?,?,?)");
		ps3.setInt(1,busId);
		ps3.setInt(2, id);
		ps3.setInt(3, conid);
		
		int x=ps3.executeUpdate();
		if(x>0) {
			message="Seat Confirmed";
		}else 
			throw new CustomerException("yet not exist customer"+id);
//		else 
//			throw new BusException("yet not exists bus");
	}
	else
		throw new BusException("yet not exist Bus"+busId);
	
	}
	else 
		throw new ContactException("yet not exist Contact"+conid);
	}	
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BusException(e.getMessage());
		}
		return message;
	}

	

		}
