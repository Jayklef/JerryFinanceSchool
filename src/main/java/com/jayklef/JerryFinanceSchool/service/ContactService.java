package com.jayklef.JerryFinanceSchool.service;

import com.jayklef.JerryFinanceSchool.controller.ContactController;
import com.jayklef.JerryFinanceSchool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactService {

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }
}
