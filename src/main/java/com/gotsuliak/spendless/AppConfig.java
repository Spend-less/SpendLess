package com.gotsuliak.spendless;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.UnknownHostException;

@Configuration
@ComponentScan
@EnableWebMvc
@EnableMongoRepositories
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/", "classpath:/index.html");
    }

    @Bean(name = "mongoTemplate")
    MongoTemplate getMongoTemplate() throws UnknownHostException {
        return new MongoTemplate(new MongoClient("localhost", 27017), "spendlessDB");
    }
}
