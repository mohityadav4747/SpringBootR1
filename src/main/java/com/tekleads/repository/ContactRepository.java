package com.tekleads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tekleads.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	@Query("select e.contactName from Contact e")
	public String getName();
	
	@Query("update Contact set contactName=:contactName,contactEmail=:contactEmail,contactNumber=:contactNumber where contactId=:contactId")
	public Contact updateContact(String contactName,String contactEmail,long contactNumber,Integer contactId);
}
