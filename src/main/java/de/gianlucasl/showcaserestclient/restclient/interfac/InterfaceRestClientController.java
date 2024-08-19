package de.gianlucasl.showcaserestclient.restclient.interfac;


import de.gianlucasl.showcaserestclient.JsonPlaceHolderPostClient;
import de.gianlucasl.showcaserestclient.Post;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interface/posts")
public class InterfaceRestClientController {

    private final JsonPlaceHolderPostClient jsonPlaceHolderPostClient;

    public InterfaceRestClientController(@Qualifier("jsonPlaceHolderPostRestClient") JsonPlaceHolderPostClient jsonPlaceHolderPostRestClient) {
        this.jsonPlaceHolderPostClient = jsonPlaceHolderPostRestClient;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(jsonPlaceHolderPostClient.getPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(jsonPlaceHolderPostClient.getPostById(id));
    }

    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(jsonPlaceHolderPostClient.createPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
        return ResponseEntity.ok(jsonPlaceHolderPostClient.updatePost(id, post));
    }
}