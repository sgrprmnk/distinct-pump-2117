package worldTourist.dao;

import java.util.List;

import worldTourist.exception.ContactException;
import worldTourist.model.Contact;

public interface ContactDao {
public String register(Contact contact) throws ContactException;
public List<Contact> getAllContact() throws ContactException;
}  
