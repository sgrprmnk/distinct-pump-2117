package worldTourist.usecases;

import java.util.Scanner;

import worldTourist.dao.AdminDao;
import worldTourist.dao.AdminDaoImpl;
import worldTourist.model.Admin;

public class signInAdminUseCase {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter your username: ");
	String user=sc.next();
	
	System.out.println("Please enter your password");
	String password=sc.next();
	
	AdminDao dao=new AdminDaoImpl();
	try {
		Admin admin=dao.signInAdmin(user, password);
		System.out.println("Welcome"+admin.getUsername());
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
