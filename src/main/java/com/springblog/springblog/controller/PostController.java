package com.springblog.springblog.controller;

import com.springblog.springblog.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }



}
