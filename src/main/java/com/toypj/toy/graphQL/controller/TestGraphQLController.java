package com.toypj.toy.graphQL.controller;

import graphql.kickstart.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ServerWebExchange;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/graphql")
@Slf4j
@AllArgsConstructor
public class TestGraphQLController {
    
        
    @RequestMapping(value = "/test", method  = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<?> getGraphQL(ServerWebExchange serverWebExchange) {
        
        return Mono.just("");
    }


}
