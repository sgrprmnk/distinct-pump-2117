package worldTourist.usecases;

import java.util.Scanner;

import worldTourist.dao.CustomerDao;
import worldTourist.dao.CustomerDaoImpl;
import worldTourist.exception.CustomerException;
import worldTourist.model.Customer;

public class registerCustomerUseCase {
	public static void registerCustomer() throws CustomerException {
		Scanner sc =new Scanner(System.in);
		System.out.println("Please enter user id");
		int id=sc.nextInt();
		
		System.out.println("Please enter a username");
		String username =sc.next();
		System.out.println("Please enter your password");
		String password=sc.next();
		
		System.out.println("Please enter source of Travel");
		String source =sc.next();
		System.out.println("Please enter destination of Travel");
		String destination=sc.next();
		
		CustomerDao dao =new CustomerDaoImpl();
		
		try {
			Customer customer =new Customer(id,username, password,source,destination);
			String res=dao.registerCustomer(customer);
			System.out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
	}
	
	
	
public static void main(String[] args) throws CustomerException {

	registerCustomer();
}
}
