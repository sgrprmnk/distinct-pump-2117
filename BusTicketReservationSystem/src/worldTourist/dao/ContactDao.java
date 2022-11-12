package worldTourist.dao;

import worldTourist.exception.ContactException;
import worldTourist.model.Contact;

public interface ContactDao {
public String register(Contact contact) throws ContactException;
}  
