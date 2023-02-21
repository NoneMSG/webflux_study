package com.toypj.toy.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import java.net.*;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webclient() {
        return WebClient
                .builder()
                .baseUrl("https://apis.data.go.kr")
                .filter(ExchangeFilterFunction.ofRequestProcessor(req -> {
                    try {
                        URI url = new URI(req.url().toString().replace("25",""));
                        ClientRequest newRequest = ClientRequest.from(req)
                                                .url(url)
                                                .build();

                       return Mono.just(newRequest);                         
                    } catch(URISyntaxException ex) {
                        return Mono.error(ex);
                    }
                }))
                .build();
    }
    
}
