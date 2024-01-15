package com.dev.dscommerce.services;

import com.dev.dscommerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserService userService;
    public void validateSelfOrAdmin(Long userId) {
        //Get loged User
        User me = userService.authenticated();
        //Testing if this User is not User or Admin
        if (!me.hasHole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbbidenException("Access denied");

        }
    }
}
