package com.system.mobile_shopping.pojo;

import com.system.mobile_shopping.entity.Contact;
import com.system.mobile_shopping.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactPojo {
    private Integer id;

    private String name;
    private String Email;

    private String message;


    private String subject;

    public ContactPojo(Contact contact) {
        this.id = contact.getId();
        this.name = contact.getName();
        this.Email = contact.getEmail();
        this.message = contact.getMessage();
        this.subject = contact.getSubject();
    }
}

