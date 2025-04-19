package com.org.isdb62.repository;

import com.org.isdb62.model.CustomUser;import org.springframework.stereotype.Repository;


public interface CustomUserRepository {
    CustomUser findCustomUserByEmail(String email);
}
