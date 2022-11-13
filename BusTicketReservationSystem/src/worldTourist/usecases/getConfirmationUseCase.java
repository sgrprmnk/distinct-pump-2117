package worldTourist.usecases;

import java.util.List;
import java.util.Scanner;

import worldTourist.dao.CustomerDao;
import worldTourist.dao.CustomerDaoImpl;
import worldTourist.exception.BusException;
import worldTourist.exception.ContactException;
import worldTourist.exception.CustomerException;
import worldTourist.model.BusCustomerDTO;


public class getConfirmationUseCase {
public static void main(String[] args) throws BusException,CustomerException,ContactException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter your customer id");
	int id=sc.nextInt();
	
	CustomerDao dao=new CustomerDaoImpl();
	
	try {
		List<BusCustomerDTO> lists=dao.getConfirmation(id);
		lists.forEach(l->System.out.println(l));
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {
		sc.close();
	}
}
}
