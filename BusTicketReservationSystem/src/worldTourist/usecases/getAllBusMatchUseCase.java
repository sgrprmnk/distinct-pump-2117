package worldTourist.usecases;

import java.util.List;
import java.util.Scanner;

import worldTourist.dao.CustomerDao;
import worldTourist.dao.CustomerDaoImpl;
import worldTourist.model.Bus;

public class getAllBusMatchUseCase {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter the source of the Travel");
	String s=sc.next();
	
	System.out.println("Please enter the destination of the travel");
	String d=sc.next();
	
CustomerDao dao=new CustomerDaoImpl();
	
	
	try {
		List<Bus> buses=dao.getAllBusMatch(s, d);
		//Bus buses=dao.getAllBusMatch(s, d);
		buses.forEach(s1->System.out.println(s1));
		//System.out.println(buses);
		//buses.forEach(s->System.out.println(s));
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println(e.getMessage());
	} finally {
		sc.close();
	}
}
}
