package com.system.mobile_shopping.repo;

import com.system.mobile_shopping.entity.Contact;
import com.system.mobile_shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Integer> {

}
