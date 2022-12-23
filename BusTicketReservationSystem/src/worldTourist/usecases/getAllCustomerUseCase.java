package worldTourist.usecases;

import java.util.List;

import worldTourist.dao.AdminDao;
import worldTourist.dao.AdminDaoImpl;
import worldTourist.exception.CustomerException;
import worldTourist.model.Customer;

public class getAllCustomerUseCase {
	public static void getAllCustomer() {
		AdminDao dao=new AdminDaoImpl();

		try {
			List<Customer> customers=dao.getAllCustomer();
			customers.forEach(c->System.out.println(c));
			
		} catch (CustomerException e) {
			// TODO: handle exception
		//	e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
public static void main(String[] args) {

	getAllCustomer();
}
}
