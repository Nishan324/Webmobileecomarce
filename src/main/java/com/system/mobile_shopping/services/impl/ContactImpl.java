package com.system.mobile_shopping.services.impl;

import com.system.mobile_shopping.entity.Contact;
import com.system.mobile_shopping.entity.Product;
import com.system.mobile_shopping.pojo.ContactPojo;
import com.system.mobile_shopping.pojo.ProductPojo;
import com.system.mobile_shopping.repo.ContactRepo;
import com.system.mobile_shopping.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactImpl  implements ContactService {
    private final ContactRepo contactRepo;
    @Override
    public ContactPojo saveContact(ContactPojo contactPojo) throws IOException {
        Contact contact = new Contact();
        if (contactPojo.getId() != null) {
            contact = contactRepo.findById(contact.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            contact = new Contact();
        }
        contact.setName(contactPojo.getName());
        contact.setEmail(contactPojo.getEmail());
        contact.setMessage(contactPojo.getMessage());
        contact.setSubject(contactPojo.getSubject());
        contactRepo.save(contact);
        return new ContactPojo(contact);
    }

    @Override
    public List<Contact> fetchAll() {
        return contactRepo.findAll();
    }

    public Contact fetchById(Integer id) {
        return contactRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        contactRepo.deleteById(id);
    }

}
