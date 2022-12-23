package worldTourist.usecases;

import java.util.Scanner;

import worldTourist.dao.CustomerDao;
import worldTourist.dao.CustomerDaoImpl;
import worldTourist.exception.BusException;

public class CancelTicketCustomerUseCase {
	public static void cancelTicket() throws BusException{
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Please enter bus id:");
		int busid=sc.nextInt();
		System.out.println("Please enter customerid:");
		int id=sc.nextInt();
		System.out.println("Please enter contactId:");
		int cid=sc.nextInt();
		CustomerDao dao=new CustomerDaoImpl();
		
		String result;
		try {
			//result=dao.cancelBus( cid, conid,busid);
//			result=dao.cancelBus(busid, cid, conid);
			result=dao.cancelBus(busid, id, cid);
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} 
	}
	
public static void main(String[] args) throws BusException {

	cancelTicket();
	
}
}
