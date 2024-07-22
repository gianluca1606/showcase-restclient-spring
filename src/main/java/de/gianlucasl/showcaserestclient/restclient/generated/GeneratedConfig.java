package de.gianlucasl.showcaserestclient.restclient.generated;

import de.gianlucasl.generated.ApiClient;
import de.gianlucasl.generated.api.DefaultApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratedConfig {

    @Bean
    public ApiClient apiClient() {
        final var apiClient = new ApiClient();
        apiClient.setBasePath("https://jsonplaceholder.typicode.com/");
        return apiClient;
    }

    @Bean
    public DefaultApi postClient(ApiClient apiClient) {
        return new DefaultApi(apiClient);
    }

}