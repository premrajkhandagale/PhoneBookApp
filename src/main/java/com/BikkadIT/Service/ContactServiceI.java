package com.BikkadIT.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BikkadIT.Model.Contact;

@Service
public interface ContactServiceI {
	
	boolean saveContact(Contact contact);
	
	List<Contact> getAll();

}
