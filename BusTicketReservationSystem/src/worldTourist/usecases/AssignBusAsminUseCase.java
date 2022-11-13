package worldTourist.usecases;


import java.util.Scanner;

import worldTourist.dao.AdminDao;
import worldTourist.dao.AdminDaoImpl;
import worldTourist.exception.BusException;
import worldTourist.exception.CustomerException;

public class AssignBusAsminUseCase {
public static void main(String[] args) throws BusException, CustomerException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter bus Id");
	int busid=sc.nextInt();
	
	System.out.println("Please enter customer Id:");
	int cid=sc.nextInt();
	
	System.out.println("Please Enter contact Person Id: ");
	int conid=sc.nextInt();

	
	AdminDao dao =new AdminDaoImpl();
	
	try {
		String result=dao.assignBus(busid,cid,conid);
		System.out.println(result);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println(e.getMessage());
		
	} finally {
		sc.close();
	}
	
}
}
