package worldTourist.usecases;

import java.util.Scanner;

import worldTourist.dao.CustomerDao;
import worldTourist.dao.CustomerDaoImpl;

public class CancelTicketCustomerUseCase {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter customer id:");
	int cid=sc.nextInt();
	System.out.println("Please enter contactid:");
	int conid=sc.nextInt();
	System.out.println("Please enter busId:");
	int busid=sc.nextInt();
	
	CustomerDao dao=new CustomerDaoImpl();
	
	String result;
	try {
		result=dao.cancelBus(busid, cid, conid);
		System.out.println(result);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
}
}
