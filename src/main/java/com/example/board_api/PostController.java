package com.example.board_api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    PostController() {
        Post.posts.add(new Post("title1", "hello world1"));
        Post.posts.add(new Post("title2", "hello world2"));
        Post.posts.add(new Post("title3", "hello world3"));
    }

    @PostMapping("/post/register1")
    @ResponseBody
    public String postRegister1(@RequestBody Post body) {
        Post.posts.add(body);
        return "ok";
    }

    @PostMapping("/post/register2")
    @ResponseBody
    public String postRegister2(Post body) {
        Post.posts.add(body);
        return "ok";
    }

    @GetMapping("/post/list")
    @ResponseBody
    public List<Post> postList() {
        return Post.posts;
    }

    @GetMapping("/post/detail/{id}")
    @ResponseBody
    public Post postDetail(@PathVariable Long id) {
        boolean check = false;
        for (Post a : Post.posts) {
            if (a.getId() == id) {
                check = true;
                return a;
            }
        }
        if (!check) {
            throw new IllegalArgumentException("없는 ID입니다.");
        }
        return null;
    }

    @GetMapping("/post/detailparam")
    @ResponseBody
    public Post postDetailParam(@RequestParam Long id) {
        boolean check = false;
        for (Post a : Post.posts) {
            if (a.getId() == id) {
                check = true;
                return a;
            }
        }
        if (!check) {
            throw new IllegalArgumentException("없는 ID입니다.");
        }
        return null;
    }
}
