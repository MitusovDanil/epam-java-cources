package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

import java.io.IOException;


public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        Person person = null;
        try {
            person = mapper.readValue(jsonString, PersonImpl.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        return readWithJackson(new ObjectMapper(), jsonString);
    }
}
