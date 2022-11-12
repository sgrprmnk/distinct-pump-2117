package worldTourist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import worldTourist.exception.ContactException;
import worldTourist.model.Contact;
import worldTourist.utility.DbUtil;

public class ContactDaoImpl implements ContactDao{

	@Override
	public String register(Contact contact) throws ContactException{
		String message="Not added";
		
		try(Connection conn=DbUtil.provideConnection()) {
			
	PreparedStatement ps= conn.prepareStatement("insert into Contact (name,phone) values(?,?)");
	ps.setString(1,contact.getName() );
	ps.setString(2, contact.getPhone());
	
	int x=ps.executeUpdate();
	
	if(x>0) {
		message="Contact Added Successfully";
	}
			
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
			throw new ContactException(e.getMessage());
		}
		return message;
	}

}
