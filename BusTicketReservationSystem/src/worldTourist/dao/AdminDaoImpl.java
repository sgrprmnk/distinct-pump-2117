package worldTourist.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import worldTourist.model.Admin;
import worldTourist.model.Bus;
import worldTourist.utility.DbUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin signInAdmin(String username, String password) {
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
		}
		return admin;
	}

	@Override
	public String addBusDetails(Bus bus) {
		String message="Not Assigned";
		try(Connection conn=DbUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into Bus (busName,busRoute,busType,seats,sourceTravel,destinationTravel) values(?,?,?,?,?,?)");
			
			ps.setString(1,bus.getBusName());
			ps.setString(2, bus.getBusRoute());
			ps.setString(3, bus.getBusType());
			
			ps.setInt(4, bus.getSeats());
			ps.setString(5, bus.getSourceTravel());
			ps.setString(6, bus.getSourceDestination());
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Bus Assigned Successfully";
			}
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
		}
		
		return message;
	}

	@Override
	public String assignBus(int cid, int busId, int conid) {
		
	String	message="Not Confirmed";
		// TODO Auto-generated method stub
		
		try(Connection conn=DbUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from Customer where id=?");
			ps.setInt(1, cid);
			
			ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		PreparedStatement ps1=	conn.prepareStatement("select * from Bus where busId=?");
		
		ps1.setInt(2,busId);
		
	ResultSet rs1=	ps1.executeQuery();
		
	if(rs1.next()) {
	PreparedStatement ps2=	conn.prepareStatement("insert into bus_booking values(?,?,?)");
		ps2.setInt(1,busId);
		ps2.setInt(2, cid);
		ps2.setInt(3, conid);
		
		int x=ps2.executeUpdate();
		if(x>0) {
			message="Seat Confirmed";
		}
	}
		}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return message;
	}

	

}
