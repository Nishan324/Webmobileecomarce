package com.system.mobile_shopping.services;

import com.system.mobile_shopping.entity.Contact;
import com.system.mobile_shopping.pojo.ContactPojo;
import com.system.mobile_shopping.pojo.ProductPojo;

import java.io.IOException;
import java.util.List;

public interface ContactService  {
    ContactPojo saveContact(ContactPojo contactPojo) throws IOException;
    List<Contact> fetchAll();
    Contact fetchById(Integer id);
    void deleteById(Integer id);
}
