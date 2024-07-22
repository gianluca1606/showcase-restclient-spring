package de.gianlucasl.showcaserestclient.resttemplate;

import de.gianlucasl.showcaserestclient.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class JsonPlaceHolderPostService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    public JsonPlaceHolderPostService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Post> getPosts() {
        ResponseEntity<List<Post>> response = restTemplate.exchange(baseUrl + "/posts", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

    public Post getPostById(int id) {
        return restTemplate.getForObject(baseUrl + "/posts/{id}", Post.class, id);
    }

    public Post createPost(Post post) {
        return restTemplate.postForObject(baseUrl + "/posts", post, Post.class);
    }

    public Post updatePost(int id, Post post) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/posts/{id}");
        HttpEntity<Post> entity = new HttpEntity<>(post);
        return restTemplate.exchange(builder.buildAndExpand(id).toUri(), HttpMethod.PUT, entity, Post.class).getBody();
    }
}