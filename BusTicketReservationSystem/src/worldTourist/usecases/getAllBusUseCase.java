package worldTourist.usecases;

import java.util.List;

import worldTourist.dao.AdminDao;
import worldTourist.dao.AdminDaoImpl;
import worldTourist.exception.BusException;
import worldTourist.model.Bus;

public class getAllBusUseCase {
	public static void getAllBus() {
		AdminDao dao=new AdminDaoImpl();
		try {
			List<Bus> buses=dao.getAllBus();
			buses.forEach(b->System.out.println(b));
		} catch (BusException e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
public static void main(String[] args) {

	getAllBus();
	
}
}
