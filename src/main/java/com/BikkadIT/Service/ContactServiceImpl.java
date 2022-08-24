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

	@Override
	public boolean updateContact(Contact contact) {
		Contact contact2 = contactRepository.save(contact);
		if(contact2 !=null) {
		return true;
		}else {
		return false;
	}
	}

	@Override
//	public boolean deleteById(Integer contactId) {
//		boolean existsById = contactRepository.existsById(contactId);
//		if(existsById)
//		{
//			contactRepository.deleteById(contactId);
//			return true;
//		}else {
//			
//			return false;
//		}
//		
//	}
	
//	public boolean deleteById(Integer contactId) {
//		Optional<Contact> findById = contactRepository.findById(contactId);
//		if(findById.isPresent())
//		{
//			contactRepository.deleteById(contactId);
//			return true;
//		}else {
//			return false;
//
//		}
//				
//	}
	
	public boolean deleteById(Integer contactId) {
		Optional<Contact> contact = contactRepository.findById(contactId);
		if(contact.isPresent())
		{
			Contact contact2 = contact.get();
			contact2.setActiveSwitch('N');
			contactRepository.save(contact2);
			return true;
		}else {
		return false;
		}
	}
	
	
	
	
	
	
	
	
	

}
