package com.tekleads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tekleads.model.Contact;
import com.tekleads.service.IContactService;

@Controller
@RequestMapping("contact")
public class ContactController {
	@Autowired
	private IContactService service;
	
	@RequestMapping("/reg")
	public String showRegPage() {
		return "ContactReg";
	}
	@RequestMapping(value ="/save",method = RequestMethod.POST)
    public String saveContactDtls(@ModelAttribute Contact contact,Model model) {
		boolean isSaved=service.saveAllContacts(contact);
		if(isSaved) {
		model.addAttribute("msg","contact saved");
		}else
		{
			model.addAttribute("errmsg","contact not saved");
		}
    	return "ContactReg";
    }
	@RequestMapping("/view")
	public String showAllContacts(Model model) {
		List<Contact> list=service.retrieveAllContacts();
		model.addAttribute("list",list);
		return "ContactData";
		
	}
	@RequestMapping("/delete")
	public String deleteContactById(@RequestParam("contactId")Integer contactId,Model model) {
		service.deleteContactById(contactId);
		model.addAttribute("msg","deleted:"+contactId);
		List<Contact> list=service.retrieveAllContacts();
		model.addAttribute("list",list);
		return "ContactData";
		
	}
	@RequestMapping("/edit")
	public String updateContactById(
			@RequestParam("contactId") Integer contactId, Model model) {
		Contact cont=service.getOneContact(contactId);
		model.addAttribute("Contact",cont);
		return "EditContact";
		
	}

	/*
	 * @RequestMapping(value="/update", method=RequestMethod.POST) public String
	 * updateContact(@ModelAttribute Contact contact,Model model) {
	 * service.updateContact(contact); String
	 * msg="Contact'"+contact.getContactId()+"'updated";
	 * model.addAttribute("msg",msg);
	 * List<Contact>list=service.retrieveAllContacts();
	 * model.addAttribute("list",list); //Contact c = new Contact(); //
	 * BeanUtils.copyProperties(c, info); //boolean msg =
	 * service.updateContact(contact); //model.addAttribute("ob", c);
	 * //model.addAttribute("msg", msg); return "ContactData"; }
	 */
		@RequestMapping("/validateEmail")
		public @ResponseBody String validateEmail(@RequestParam("contactEmail")String contactEmail ) {
			
			return service.validateEmail(contactEmail);
			
		}
		
	}