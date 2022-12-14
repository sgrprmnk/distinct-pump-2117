package worldTourist.usecases;

import java.util.Scanner;

import worldTourist.dao.CustomerDao;
import worldTourist.dao.CustomerDaoImpl;
import worldTourist.exception.CustomerException;
import worldTourist.model.Customer;

public class signInCustomerUseCase {
	public static void signInCustomer() throws CustomerException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your username");
		String username=sc.next();
		
		System.out.println("Please enter your password");
		String pass=sc.next();
		
		CustomerDao dao=new CustomerDaoImpl();
		try {
			Customer customer =dao.signInCustomer(username, pass);
			System.out.println("Welcome: "+customer.getUsername());
			System.out.println(customer);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} 
	}
	public static boolean signInCust() throws CustomerException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your username");
		String username=sc.next();
		
		System.out.println("Please enter your password");
		String pass=sc.next();
		
		CustomerDao dao=new CustomerDaoImpl();
		try {
			Customer customer =dao.signInCustomer(username, pass);
			if(customer!=null)
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} 
		return false;
	}
	
public static void main(String[] args) throws CustomerException {

	signInCustomer();
}
	
}
