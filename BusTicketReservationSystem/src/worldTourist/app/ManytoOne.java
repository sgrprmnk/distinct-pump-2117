package worldTourist.app;

import java.sql.SQLException;
import java.util.Scanner;

import worldTourist.exception.AdminException;
import worldTourist.exception.BusException;
import worldTourist.exception.ContactException;
import worldTourist.exception.CustomerException;
import worldTourist.usecases.AssignBusAsminUseCase;
import worldTourist.usecases.CancelTicketCustomerUseCase;
import worldTourist.usecases.addBusDetailsUseCase;
import worldTourist.usecases.getAllBusMatchUseCase;
import worldTourist.usecases.getAllBusUseCase;
import worldTourist.usecases.getAllContactUseCase;
import worldTourist.usecases.getAllCustomerUseCase;
import worldTourist.usecases.getConfirmationUseCase;
import worldTourist.usecases.registerContactUseCase;
import worldTourist.usecases.registerCustomerUseCase;
import worldTourist.usecases.signInAdminUseCase;
import worldTourist.usecases.signInCustomerUseCase;

public class ManytoOne {
	public static void logIn() throws BusException, CustomerException, ContactException {
		Scanner sc=new Scanner(System.in);
//	signInCustomerUseCase.signInCustomer();
		System.out.println("5.Check All the Bus that matches your choice"+'\n'+"9.Check Confirmation of your Journey"+'\n'+"4.Cancel Ticket"+'\n'+"Press any others key like 0 to exit.");
		System.out.println("++++++++++++++++++++++++++++++");
		int c2=sc.nextInt();
		if(c2==5) {
			getAllBusMatchUseCase.getAllBusMatch();
		} else if(c2==9) {
			//TODO:checkConfirmation()
			getConfirmationUseCase.checkConfirmation();
		} else if(c2==4) {
			//TODO:cancelTicket()
			CancelTicketCustomerUseCase.cancelTicket();
		} else {
			System.out.println("Exists:");
			System.exit(1);
		}
	
	}
	

	
	public static void AdminlogIn() throws BusException, SQLException, CustomerException, ContactException {
		Scanner sc=new Scanner(System.in);
		System.out.println("2.Add Bus Details"+'\n'+"3.Assign Bus to Customer"+'\n'+"6.All Bus Details Info"+'\n'+"7.All Contact Details Info"+'\n'+"8.All Customer Details Info"+'\n'+"10.Add Contact Details"+'\n'+"Press others key like 0 to exit");
		System.out.println("++++++++++++++++++++++++++++++");
		int a1=sc.nextInt();
		if(a1==2) {
			//TODO:addbus()
			addBusDetailsUseCase.addBus();
		} else if(a1==3) {
			//TODO:assignBus()
			AssignBusAsminUseCase.assignBus();
		} else if(a1==6) {
			//TODO:getAllBus()
			getAllBusUseCase.getAllBus();
		} else if(a1==7) {
			//TODO:getAllContact()
			getAllContactUseCase.getAllContact();
		} else if(a1==8) {
			//TODO:getAllCustomer()
			getAllCustomerUseCase.getAllCustomer();
		} else if(a1==10) {
			//TODO:addContact()
			registerContactUseCase.addContact();
		}
		else {
			System.out.println("Exists");
			System.exit(1);
		}
	}

public static void main(String[] args) throws BusException, SQLException, CustomerException, ContactException, AdminException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Please Enter your choice:");
	System.out.println("1.Register Customer"+'\n'+"2.LogIn as a Customer"+'\n'+"3.LogIn as an Admin"+'\n'+"4.Access Credntial as Customer"+'\n'+"5.Access as an Admin"+'\n'+"Press others key like 0 to exit");
System.out.println("==================================================");
	int choice=sc.nextInt();
	if(choice==1) {
		
	//TODO:registr contact	
	registerCustomerUseCase.registerCustomer();

	}
	else if(choice==2) {
		//sign In method
		signInCustomerUseCase.signInCustomer();
		//logInH();
		logIn();
	} else if(choice==3) {
		//TODO:logIn as an Admin
		//--------->Implement this after launch
signInAdminUseCase.signInAdmin();
//AdminlogIn();
		
	} else if(choice==4) {
		logIn();
	} else if(choice==5) {
		AdminlogIn();
	}
	else {
		System.out.println("Exists");
		System.exit(1);
	}
	
}
}