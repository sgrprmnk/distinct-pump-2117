package worldTourist.usecases;

import java.util.Scanner;

import worldTourist.dao.ContactDao;
import worldTourist.dao.ContactDaoImpl;
import worldTourist.exception.ContactException;
import worldTourist.model.Contact;

public class registerContactUseCase {

	public static void main(String[] args) throws ContactException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please enter contact Id");
		int id=sc.nextInt();
		
		System.out.println("Please Enter Contact name");
		String name =sc.next();
		
		System.out.println("Please Enter Phone Number ");
		String phone=sc.next();
		
		ContactDao dao =new ContactDaoImpl();
		
		try {
			Contact contact =new Contact(id,name,phone);
			
			String res=dao.register(contact);
			System.out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
		
	}
}
