package com.toypj.toy.com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

import java.util.*;

@Configuration
@Data
public class CacheConfig {
    
    @Value("${data-spec}")
    private List<String> specList;

}
