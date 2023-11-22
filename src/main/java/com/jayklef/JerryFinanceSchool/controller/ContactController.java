package com.jayklef.JerryFinanceSchool.controller;

import com.jayklef.JerryFinanceSchool.model.Contact;
import com.jayklef.JerryFinanceSchool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
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
    public String displayContactPage(Model model){
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

 /*   @RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String phoneNumber,
                                    @RequestParam String email, @RequestParam String subject,
                                    @RequestParam String message){
        return new ModelAndView("redirect: /contact");
    } */
    @PostMapping("/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if (errors.hasErrors()){
            log.info("Contact form validation failed due to: " + errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
}
