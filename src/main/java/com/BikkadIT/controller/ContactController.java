package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Contact;
import com.BikkadIT.Service.ContactServiceI;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping(value="/savecontact",produces="application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		boolean saved = contactServiceI.saveContact(contact);
		if(contact!=null )
		{
			String msg="data saved Sucessfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg="failed to save ";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
				
	}
	
	@GetMapping(value="/getAll",consumes="application/json")
	public ResponseEntity<List<Contact>> getAll()
	{
		List<Contact> list = contactServiceI.getAll();
		if(list!=null)
		{
			return new ResponseEntity<List<Contact>>(list, HttpStatus.OK);
		}else {
			String msg="failed to fetch data";
			return new ResponseEntity<List<Contact>>(list, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	@GetMapping(value="/getByID/{contactId}",produces="application/json")
	public ResponseEntity<Contact> getById(@PathVariable Integer contactId)
	{
		Contact contactById = contactServiceI.getContactById(contactId);
		
			return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/update",consumes="application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		boolean updateContact = contactServiceI.updateContact(contact);
		if(updateContact == true) {
			String msg="contact updated sucessfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg="failed to update";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(value="/delete/{contactId}")
	public ResponseEntity<String> deleteById(@PathVariable Integer contactId)
	{
		boolean deleteById = contactServiceI.deleteById(contactId);
		if(deleteById) {
			String msg="contact deleted successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg="failed to delete";
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST) ;
	}
	
	}

}
