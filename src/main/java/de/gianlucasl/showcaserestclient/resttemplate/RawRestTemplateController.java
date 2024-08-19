package de.gianlucasl.showcaserestclient.resttemplate;

import de.gianlucasl.showcaserestclient.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resttemplate/posts")
public class RawRestTemplateController {

    private final RawRestTemplateService rawRestTemplateService;

    public RawRestTemplateController(RawRestTemplateService postService) {
        this.rawRestTemplateService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(rawRestTemplateService.getPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(rawRestTemplateService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(rawRestTemplateService.createPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {
        return ResponseEntity.ok(rawRestTemplateService.updatePost(id, post));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        rawRestTemplateService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}