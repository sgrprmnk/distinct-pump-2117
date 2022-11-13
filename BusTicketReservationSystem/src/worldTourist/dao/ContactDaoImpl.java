package worldTourist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
			message=e.getMessage();
			throw new ContactException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<Contact> getAllContact() throws ContactException {
		List<Contact> contacts =new ArrayList<>();
		
		try(Connection conn=DbUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from Contact");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int i=rs.getInt("id");
				String n=rs.getString("name");
				String p=rs.getString("phone");
				Contact contact =new Contact(i,n,p);
				contacts.add(contact);
			}
			
		} catch (SQLException e) {
			
			throw new ContactException(e.getMessage());
			
		}
		if(contacts.size()==0) {
			throw new ContactException("None Yet registerd");
		}
		
		return contacts;
	}

}
