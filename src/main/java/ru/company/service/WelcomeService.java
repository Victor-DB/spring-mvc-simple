package ru.company.service;

import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class WelcomeService {

    private String name;

    public String getWelcome() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            builder.append(random.nextInt(9) + 1);
        }
        return String.valueOf(builder);
    }

    public void setName(String str) {
        name = str;
    }
}
