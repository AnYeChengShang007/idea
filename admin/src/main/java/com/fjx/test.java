package com.fjx;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
        System.out.println(encode.length());
    }
}
