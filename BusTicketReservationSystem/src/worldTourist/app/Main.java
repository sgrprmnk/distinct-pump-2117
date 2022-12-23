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

public class Main {
	public static void logIn() throws BusException, CustomerException, ContactException {
		Scanner sc=new Scanner(System.in);
		String userChoice;
		do {
			System.out.println("++++++++++++++++++++++++++++++");
			System.out.println("1.Check All the Bus that matches your choice"+'\n'+"2.Check Confirmation of your Journey"+'\n'+"3.Cancel Ticket"+'\n');
			System.out.println();
			System.out.println();
			System.out.println("Please Enter Your choice");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				getAllBusMatchUseCase.getAllBusMatch();
				break;
			case 2:
				getConfirmationUseCase.checkConfirmation();
				break;
			case 3:
				CancelTicketCustomerUseCase.cancelTicket();
				break;
			case 4:
				System.exit(1);
				System.out.println("System Exists");
				break;
			case 0:
				break;
			}
			System.out.println("Do You want to continue?");
			userChoice=sc.next();
			
			
		} while(userChoice.equalsIgnoreCase("Yes"));
	}
		
		
		


	
	public static void AdminlogIn() throws BusException, CustomerException, ContactException{
		Scanner sc=new Scanner(System.in);
		String userChoice;
		
		do {
			System.out.println("++++++++++++++++++++++++++++++");
			System.out.println("1.Add Bus Details"+'\n'+"2.Assign Bus to Customer"+'\n'+"3.All Bus Details Info"+'\n'+"4.All Contact Details Info"+'\n'+"5.All Customer Details Info"+'\n'+"6.Add Contact Details"+'\n'+"Press others key like 0 to exit");
			System.out.println();
			System.out.println();
			System.out.println("Please Enter your choice");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				addBusDetailsUseCase.addBus();
				break;
				
			case 2:
				AssignBusAsminUseCase.assignBus();
				break;
			case 3:
				getAllBusUseCase.getAllBus();
				break;
			case 4:
				getAllContactUseCase.getAllContact();
				break;
			case 5:
				getAllCustomerUseCase.getAllCustomer();
				break;
			case 6:
				registerContactUseCase.addContact();
				break;
			case 0:
				break;
			}
			System.out.println("Do you want to continue?");
			userChoice =sc.next();		
		}while(userChoice.equalsIgnoreCase("Yes"));
	}
	
	public static void main(String[] args) throws BusException, SQLException, CustomerException, ContactException, AdminException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Please Enter your choice:");
	System.out.println("1.Register Customer"+'\n'+"2.LogIn as a Customer"+'\n'+"3.LogIn as an Admin"+'\n'+"Press others key like 0 to exit");
System.out.println("==================================================");
	int choice=sc.nextInt();
	
	
	
	
	
	if(choice==1) {
		
	//TODO:registr contact	
	registerCustomerUseCase.registerCustomer();

	}
	else if(choice==2) {
		//sign In method
		if(signInCustomerUseCase.signInCust()) {
			logIn();
		}
		//logInH();
		
	} else if(choice==3) {
		//TODO:logIn as an Admin
	
if(signInAdminUseCase.signInAd()) {
	AdminlogIn();
}
//AdminlogIn();
	}
	else {
		System.out.println("Exists");
		System.exit(1);
	}
	
}
}
