package de.gianlucasl.showcaserestclient.restclient.raw;

import de.gianlucasl.showcaserestclient.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raw")
public class RawRestController {

    private final RawRestClient rawRestClient;

    public RawRestController(RawRestClient rawRestClient) {
        this.rawRestClient = rawRestClient;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(rawRestClient.getPosts());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(rawRestClient.getPostById(id));
    }


    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(rawRestClient.createPost(post));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
        return ResponseEntity.ok(rawRestClient.updatePost(id, post));
    }
}