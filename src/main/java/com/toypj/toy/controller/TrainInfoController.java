package com.toypj.toy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.RedirectView;
import org.springframework.web.reactive.result.view.Rendering.RedirectBuilder;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.util.*;
import com.toypj.toy.com.config.WebClientConfig;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.*;

@Slf4j
@RestController
@AllArgsConstructor
public class TrainInfoController {
    
    private final WebClientConfig webclinet;

    @GetMapping("/trainInfo")
    public Mono<?> getTest(
        ServerWebExchange exchange
    ) throws UnsupportedEncodingException, MalformedURLException, RuntimeException {
      
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        queryParams.add("serviceKey", "T8%2B4yDPNk7sKBdBZdJp%2Bjysa%2BzV6PZu%2BXbLJSqN3ZQ8eEKwb19FfEh0WQZVNaG9n9gN0KSDvout9uepmxJX%2FrQ%3D%3D");
        queryParams.add("pageNo","1");
        queryParams.add("numOfRows","200");
        queryParams.add("stationCode","3762");
        queryParams.add("week","DAY");
        queryParams.add("trainDirection","UP");

        // UriComponents builder = UriComponentsBuilder.fromUriString("/B553766/smt-schedule/schedule")
        //                     .queryParam("serviceKey", "T8%2B4yDPNk7sKBdBZdJp%2Bjysa%2BzV6PZu%2BXbLJSqN3ZQ8eEKwb19FfEh0WQZVNaG9n9gN0KSDvout9uepmxJX%2FrQ%3D%3D")
        //                     .queryParam("pageNo","1")
        //                     .queryParam("numOfRows","200")
        //                     .queryParam("stationCode","3762")
        //                     .queryParam("week","DAY")
        //                     .queryParam("trainDirection","UP")
        //                     .build(false);
        //                     String url = builder.toString();
        return webclinet.webclient()
            .get()
            // .uri(url)
            // .uri(urlBuilder.toString())
            .uri("/B553766/smt-schedule/schedule", param -> param.queryParams(queryParams).build())
            .exchangeToMono(res -> {
                log.info("" + res.statusCode());
                return res.toEntity(String.class);
            })
            .map(res -> {
                log.info(res.getBody());
                return res.getBody();
            });
            
          
        // return Mono.just("test");
    }
}
