package worldTourist.usecases;

import java.util.List;

import worldTourist.dao.ContactDao;
import worldTourist.dao.ContactDaoImpl;
import worldTourist.exception.ContactException;
import worldTourist.model.Contact;

public class getAllContactUseCase {
	public static void getAllContact() {
		ContactDao dao=new ContactDaoImpl();
		try {
			List<Contact> contacts=dao.getAllContact();
			contacts.forEach(c->System.out.println(c));
		} catch (ContactException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
public static void main(String[] args) {

	getAllContact();
}
}
