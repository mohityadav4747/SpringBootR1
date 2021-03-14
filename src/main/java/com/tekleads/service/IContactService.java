package com.tekleads.service;

import java.util.List;

import com.tekleads.model.Contact;

public interface IContactService {
	
public boolean saveAllContacts(Contact contact);
public List<Contact> retrieveAllContacts();
public boolean updateContact(Contact contact);
public boolean deleteContactById(Integer contactId);
public Contact getOneContact(Integer contactId);
public String validateEmail(String contactEmail);
}
