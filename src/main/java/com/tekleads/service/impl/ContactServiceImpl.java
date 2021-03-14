package com.tekleads.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekleads.model.Contact;
import com.tekleads.repository.ContactRepository;
import com.tekleads.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {
	@Autowired
	private ContactRepository repository;

	@Override
	public boolean saveAllContacts(Contact contact) {
		Contact saved = repository.save(contact);
		return saved.getContactId() != null;
	}

	@Override
	public List<Contact> retrieveAllContacts() {
		// Contact c=new Contact();

		return repository.findAll();
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		repository.deleteById(contactId);
		return true;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Contact cont = new Contact();
		cont.getContactId();
		return true;
	}
	@Override
	public Contact getOneContact(Integer contactId) {
		Contact id = repository.getOne(contactId);
		return id;
	}

	@Override
	public String validateEmail(String contactEmail) {
		// TODO Auto-generated method stub
		return null;
	}
}
