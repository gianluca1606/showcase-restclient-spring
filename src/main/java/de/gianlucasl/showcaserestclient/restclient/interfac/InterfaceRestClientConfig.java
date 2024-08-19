package de.gianlucasl.showcaserestclient.restclient.interfac;


import de.gianlucasl.showcaserestclient.JsonPlaceHolderPostClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class InterfaceRestClientConfig {

    @Bean("jsonPlaceHolderPostRestClient")
    JsonPlaceHolderPostClient jsonPlaceHolderPostRestClient() {
        RestClient client = RestClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(client))
                .build();
        return factory.createClient(JsonPlaceHolderPostClient.class);
    }
}
