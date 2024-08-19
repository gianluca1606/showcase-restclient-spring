package de.gianlucasl.showcaserestclient.resttemplate;

import de.gianlucasl.showcaserestclient.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class RawRestTemplateService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    public RawRestTemplateService(@Autowired RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri(baseUrl).build();
    }

    public List<Post> getPosts() {
        ResponseEntity<List<Post>> response = restTemplate.exchange("/posts", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

    public Post getPostById(int id) {
        return restTemplate.getForObject("/posts/{id}", Post.class, id);
    }

    public Post createPost(Post post) {
        return restTemplate.postForObject("/posts", post, Post.class);
    }

    public Post updatePost(int id, Post post) {
        HttpEntity<Post> entity = new HttpEntity<>(post);
        return restTemplate.exchange("/posts/{id}", HttpMethod.PUT, entity, Post.class, id).getBody();
    }
}