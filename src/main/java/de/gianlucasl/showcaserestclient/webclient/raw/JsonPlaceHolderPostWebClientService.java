package de.gianlucasl.showcaserestclient.webclient.raw;

import de.gianlucasl.showcaserestclient.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class JsonPlaceHolderPostWebClientService {

    private final WebClient webClient;

    @Autowired
    public JsonPlaceHolderPostWebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public List<Post> getPosts() {
        return this.webClient.get().uri("/posts")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Post.class)
                .collectList()
                .block();
    }

    public Post getPostById(int id) {
        return this.webClient.get().uri("/posts/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Post.class)
                .block();
    }

    public Post createPost(Post post) {
        return this.webClient.post().uri("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(post)
                .retrieve()
                .bodyToMono(Post.class)
                .block();
    }

    public Post updatePost(int id, Post post) {
        return this.webClient.put().uri("/posts/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(post)
                .retrieve()
                .bodyToMono(Post.class)
                .block();
    }
}