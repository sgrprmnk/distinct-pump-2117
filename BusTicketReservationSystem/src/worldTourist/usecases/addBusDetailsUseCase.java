package worldTourist.usecases;

import java.sql.SQLException;
import java.util.Scanner;

import worldTourist.dao.AdminDao;
import worldTourist.dao.AdminDaoImpl;
import worldTourist.exception.BusException;
import worldTourist.model.Bus;

public class addBusDetailsUseCase {
	
	public static void addBus() throws BusException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter Bus Id");
		int bid=sc.nextInt();
		
		System.out.println("Please enter Bus Name");
		String bname=sc.next();
		
		System.out.println("Please enter Bus Route");
		String broute=sc.next();
		
		System.out.println("Please enter Bus Type AC/Non-AC");
		String btype =sc.next();
		
		System.out.println("Please enter Bus seats");
		int seats=sc.nextInt();
		
		System.out.println("Please enter the Source of Bus");
		String source=sc.next();
		
		System.out.println("Please enter the Destination of Bus");
		String dest=sc.next();
		
		AdminDao dao=new AdminDaoImpl();
		try {
			Bus bus=new Bus(bid,bname,broute,btype,seats,source,dest);
			String res=dao.addBusDetails(bus);
			System.out.println(res);
		} catch (BusException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} 
	}
	
public static void main(String[] args) throws BusException, SQLException {
	addBus();
	
}
}
