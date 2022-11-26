package com.alexandr.demo;

import org.hibernate.boot.internal.MetadataBuildingContextRootImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawpass = "1";
        String encodedpass = encoder.encode(rawpass);
        System.out.println(encodedpass);
    }
}
