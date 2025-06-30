package ar.edu.unnoba.pdyc.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder){
        //Se configuran las rutas personalizadas para los distintos servicios.
        return builder.routes()
                        .route("song-service", r -> r.path("/songs/**")
                                .uri("lb://song-service"))
                        .route("playlist-service", r -> r.path("/playlists/**")
                                .uri("lb://playlist-service"))
                        .build();
    }

}


/*Si fuese un .yml
* spring:
  cloud:
    gateway:
      routes:
        - id: song-service
          uri: lb://song-service
          predicates:
            - Path=/songs/**
        - id: playlist-service
          uri: lb://playlist-service
          predicates:
            - Path=/playlists/**
* */