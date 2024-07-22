package de.gianlucasl.showcaserestclient.restclient.generated;

import de.gianlucasl.generated.api.DefaultApi;
import de.gianlucasl.generated.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generated")
public class GeneratedController {

    private final DefaultApi postClient;

    public GeneratedController(DefaultApi postClient) {
        this.postClient = postClient;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postClient.postsGet();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Integer id) {
        return postClient.postsIdGet(id);
    }


    // curl -X POST -H "Content-Type: application/json" http://localhost:8080/generated/posts
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postClient.postsPostWithHttpInfo(post).getBody());
    }


    // curl -X PUT -H "Content-Type: application/json" http://localhost:8080/generated/posts/1
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
        return ResponseEntity.ok(postClient.postsIdPutWithHttpInfo(id, post).getBody());
    }
}