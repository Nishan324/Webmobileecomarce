package com.system.mobile_shopping.services.impl;

import com.system.mobile_shopping.entity.User;
import com.system.mobile_shopping.exception.AppException;
import com.system.mobile_shopping.pojo.UserPojo;
import com.system.mobile_shopping.repo.UserRepo;
import com.system.mobile_shopping.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {
    private final UserRepo userRepo;

    @Override
    public String save(UserPojo userpojo) {
        User user =new User();
        if(userpojo.getId()!=null){
            user.setId(userpojo.getId());
        }
        user.setName(userpojo.getName());
        user.setEmail(userpojo.getEmail());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(userpojo.getPassword());
        user.setPassword(encodePassword);

        userRepo.save(user);
        return "created";
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return user;
    }
}
