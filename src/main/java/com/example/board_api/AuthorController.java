package com.example.board_api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {
    AuthorController(){
        Author.authors.add(new Author("한솥", "hansot@naver.com", "password1"));
        Author.authors.add(new Author("봉구스", "bong@naver.com", "password1"));
        Author.authors.add(new Author("이삭", "issac@naver.com", "password1"));
    }
    @PostMapping("/author/register1")
    @ResponseBody
    public String authorRegister1(@RequestBody Author body){
        Author.authors.add(body);
        return "ok";
    }

    @PostMapping("/author/register2")
    @ResponseBody
    public String authorRegister2(Author body){
        Author.authors.add(body);
        return "ok";
    }
    @GetMapping("/author/list")
    @ResponseBody
    public List<Author> authorList(){
        return Author.authors;
    }

    @GetMapping("/author/detail/{id}")
    @ResponseBody
    public Author authorDetail(@PathVariable Long id) {
        for(Author a : Author.authors){
            if(a.getId()==id){
                return a;
            }
        }
        return null;
    }

    @GetMapping("/author/detailparam")
    @ResponseBody
    public Author authorDetailParam(@RequestParam Long id) {
        for(Author a : Author.authors){
            if(a.getId()==id){
                return a;
            }
        }
        return null;
    }
}
