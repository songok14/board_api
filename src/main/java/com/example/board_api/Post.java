package com.example.board_api;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
    static Long staticId = 1L;
    static List<Post> posts = new ArrayList<>();
    private Long id;
    private String title;
    private String contents;

    Post(String title, String contents){
        this.id = staticId++;
        this.title = title;
        this.contents  = contents;
    }
}
