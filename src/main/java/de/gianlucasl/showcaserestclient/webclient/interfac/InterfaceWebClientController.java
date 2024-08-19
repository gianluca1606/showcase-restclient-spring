package de.gianlucasl.showcaserestclient.webclient.interfac;

import de.gianlucasl.showcaserestclient.JsonPlaceHolderPostClient;
import de.gianlucasl.showcaserestclient.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webclient2/posts")
public class InterfaceWebClientController {

    private final JsonPlaceHolderPostClient postClient;

    @Autowired
    public InterfaceWebClientController(@Qualifier("jsonPlaceHolderPostWebClient") JsonPlaceHolderPostClient jsonPlaceHolderPostWebClient) {
        this.postClient = jsonPlaceHolderPostWebClient;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postClient.getPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(postClient.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postClient.createPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
        return ResponseEntity.ok(postClient.updatePost(id, post));
    }
}