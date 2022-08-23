package com.BikkadIT.Service;

import org.springframework.stereotype.Service;

import com.BikkadIT.Model.Contact;

@Service
public interface ContactServiceI {
	
	boolean saveContact(Contact contact);

}
