package worldTourist.usecases;

import java.util.Scanner;

import worldTourist.dao.AdminDao;
import worldTourist.dao.AdminDaoImpl;
import worldTourist.exception.AdminException;
import worldTourist.model.Admin;

public class signInAdminUseCase {
	public static void signInAdmin() throws AdminException{
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
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} 
	}
	
	public static boolean signInAd() throws AdminException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your username: ");
		String user=sc.next();
		
		System.out.println("Please enter your password");
		String password=sc.next();
		
		AdminDao dao=new AdminDaoImpl();
		try {
			Admin admin=dao.signInAdmin(user, password);
			if(admin!=null)
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} 
		return false;
	}
public static void main(String[] args) throws AdminException {

	signInAdmin();
}
}
