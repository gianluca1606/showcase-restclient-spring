package de.gianlucasl.showcaserestclient.restclient.raw;

import de.gianlucasl.showcaserestclient.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raw/posts")
public class RawRestClientController {

    private final RawRestClient rawRestClient;

    public RawRestClientController(RawRestClient rawRestClient) {
        this.rawRestClient = rawRestClient;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(rawRestClient.getPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(rawRestClient.getPostById(id));
    }


    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(rawRestClient.createPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
        return ResponseEntity.ok(rawRestClient.updatePost(id, post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        rawRestClient.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}