package de.gianlucasl.showcaserestclient.restclient.interfac;

import de.gianlucasl.showcaserestclient.Post;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface JsonPlaceHolderPostClient {

    @GetExchange("/posts")
    List<Post> getPosts();

    @GetExchange("/posts/{id}")
    Post getPostById(@PathVariable int id);

    @PostExchange("/posts")
    Post createPost(@RequestBody Post post);

    @PutExchange("/posts/{id}")
    Post updatePost(@PathVariable int id, @RequestBody Post post);
}