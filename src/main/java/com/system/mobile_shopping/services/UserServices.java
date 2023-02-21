package com.system.mobile_shopping.services;

import com.system.mobile_shopping.entity.User;
import com.system.mobile_shopping.pojo.UserPojo;

public interface UserServices {
    String save (UserPojo userpojo);
    User findByEmail(String email);
}
