package org.revo.TalentManage;

import org.revo.TalentManage.Config.Env;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.UUID;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@SpringBootApplication
@EnableConfigurationProperties(Env.class)
@EnableJpaAuditing
public class TalentManageApplication {

    private final RequestPredicate TalentManage =

            GET("/").
                    or(GET("/home")).
                    or(GET("/login")).
                    or(GET("/signup")).
                    or(GET("/persons")).
                    or(GET("/profile/{id}")).
                    or(GET("/account/edit"));

    public static void main(String[] args) {
        SpringApplication.run(TalentManageApplication.class, args);

    }


    @Bean
    public RouterFunction<ServerResponse> function(@Value("classpath:/static/index.html") final Resource indexHtml) {
        return route(GET("/api/userId"), serverRequest -> ok().body(fromObject(UUID.randomUUID().toString())))
                .andRoute(TalentManage, request -> ok().contentType(MediaType.TEXT_HTML).syncBody(indexHtml))
                ;
    }

}
