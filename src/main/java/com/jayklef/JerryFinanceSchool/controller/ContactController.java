package com.jayklef.JerryFinanceSchool.controller;

import com.jayklef.JerryFinanceSchool.model.Contact;
import com.jayklef.JerryFinanceSchool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class ContactController {

    private final ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = {"/contact"})
    public String displayContactPage(){
        return "contact.html";
    }

 /*   @RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String phoneNumber,
                                    @RequestParam String email, @RequestParam String subject,
                                    @RequestParam String message){
        return new ModelAndView("redirect: /contact");
    } */
    @PostMapping("/saveMsg")
    public ModelAndView saveMessage(Contact contact){
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
