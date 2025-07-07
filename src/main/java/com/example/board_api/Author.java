package com.example.board_api;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Author {
    static Long staticId=1L;
    static List<Author> authors = new ArrayList<>();
    private Long id;
    private String name;
    private String email;
    private String password;

    Author(String name, String email, String password){
        this.id = staticId++;
        this.name  = name;
        this.email = email;
        this.password = password;
    }
}
