package com.system.mobile_shopping.controller;

import com.system.mobile_shopping.entity.Contact;
import com.system.mobile_shopping.pojo.ContactPojo;
import com.system.mobile_shopping.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;
    @GetMapping("/contact")
    public String getContact(Model model) {
       model.addAttribute("contact",new ContactPojo());
        return "contact";
    }
    @PostMapping("/saveContact")
    public String saveUser(@Valid ContactPojo  contactPojo) throws IOException {
        contactService.saveContact(contactPojo);
        return "redirect:/contact/contactList";
    }
    @GetMapping("/contactList")
    public String getPricePage(Model model){
//        model.addAttribute("priceTab",new Admin());
        List<Contact> contacts = contactService.fetchAll();


        model.addAttribute("contact", contacts.stream().map(contact ->
                Contact.builder()
                        .id(contact.getId())
                        .name(contact.getName())
                        .message(contact.getMessage())
                        .Email(contact.getEmail())
                        .subject(contact.getSubject())
                        .build()

        ));
        return "contactList";
    }
    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable("id") Integer id, Model model){
        model.addAttribute("contactTab",contactService.fetchById(id));
        return "Editcontact";
    }

    @GetMapping("/editContact/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model){
        Contact contact =contactService.fetchById(id);
        model.addAttribute("currentUser", new ContactPojo(contact));
        return "redirect:/contact/edit/{id}";
    }
    @GetMapping("/{id}")
    public String deletePrice(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        contactService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Row delete successfully");
        return "contactList";
    }
}
