package com.springblog.springblog.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    // User Entity Class
    private String author;

    @Column(name = "title", nullable = false, length = 30)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;

    public Post() {}

}
