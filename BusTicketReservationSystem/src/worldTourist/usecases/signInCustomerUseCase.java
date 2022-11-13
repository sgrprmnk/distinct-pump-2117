package worldTourist.usecases;

import java.util.Scanner;

import worldTourist.dao.CustomerDao;
import worldTourist.dao.CustomerDaoImpl;
import worldTourist.model.Customer;

public class signInCustomerUseCase {
public static void main(String[] args) {
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
		e.printStackTrace();
	} finally {
		sc.close();
	}
}
	
}
