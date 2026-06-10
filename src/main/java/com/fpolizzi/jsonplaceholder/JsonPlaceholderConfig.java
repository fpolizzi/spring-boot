package com.fpolizzi.jsonplaceholder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * Created by fpolizzi on 6/9/26
 */
@Configuration
public class JsonPlaceholderConfig {

    @Bean("rest-client")
    JsonPlaceholderService jsonPlaceholderRestClientService() {
        RestClient restClient = RestClient.create(
                "https://jsonplaceholder.typicode.com"
        );

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(JsonPlaceholderService.class);
    }

    @Primary
    @Bean("web-client")
    JsonPlaceholderService jsonPlaceholderWebClientService() {
        RestClient restClient = RestClient.create(
                "https://jsonplaceholder.typicode.com"
        );

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(JsonPlaceholderService.class);
    }

}
