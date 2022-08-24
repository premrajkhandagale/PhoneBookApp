package com.BikkadIT.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Model.Contact;
import com.BikkadIT.Repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiceI{
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {
		Contact save = contactRepository.save(contact);
		if(save !=null)
		{
			return true;
		}else {
			
			return false;
		}
	}

	@Override
	public List<Contact> getAll() {
		List<Contact> list = contactRepository.findAll();
		Stream<Contact> stream = list.stream();
		Stream<Contact> filter = stream.filter(contact->contact.getActiveSwitch()=='Y');
		List<Contact> collect = filter.collect(Collectors.toList());
		return collect;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Contact findById = contactRepository.findById(contactId).get();
		
		return findById;
	}

	

}
