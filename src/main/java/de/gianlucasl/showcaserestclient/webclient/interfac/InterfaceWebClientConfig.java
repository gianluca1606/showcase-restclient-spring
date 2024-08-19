package de.gianlucasl.showcaserestclient.webclient.interfac;

import de.gianlucasl.showcaserestclient.JsonPlaceHolderPostClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class InterfaceWebClientConfig {

    @Bean("jsonPlaceHolderPostWebClient")
    JsonPlaceHolderPostClient jsonPlaceHolderPostWebClient() {
        WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(client))
                .build();
        return factory.createClient(JsonPlaceHolderPostClient.class);
    }
}
