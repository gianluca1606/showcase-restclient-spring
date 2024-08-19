package de.gianlucasl.showcaserestclient.restclient.raw;


import de.gianlucasl.showcaserestclient.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class RawRestClient {

    private final RestClient restClient;
    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    public RawRestClient(@Autowired RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    }

    public List<Post> getPosts() {
        return restClient.get().uri("/posts").retrieve().body(new ParameterizedTypeReference<>() {
        });
    }

    public Post getPostById(int id) {
        return restClient.get().uri("/posts/" + id).retrieve().body(Post.class);
    }

    public Post createPost(Post post) {
        return restClient.post().uri("/posts").body(post).retrieve().body(Post.class);
    }

    public Post updatePost(int id, Post post) {
        return restClient.put().uri("/posts/" + id).body(post).retrieve().body(Post.class);
    }

    public void deletePost(int id) {
        restClient.delete().uri("/posts/" + id).retrieve().toBodilessEntity();
    }
}