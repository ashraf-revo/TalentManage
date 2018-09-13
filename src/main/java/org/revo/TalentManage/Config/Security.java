package org.revo.TalentManage.Config;

import org.revo.TalentManage.Repository.AgencyRepository;
import org.revo.TalentManage.Repository.PersonRepository;
import org.revo.TalentManage.Service.AgencyService;
import org.revo.TalentManage.Service.PersonService;
import org.revo.TalentManage.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

import static org.revo.TalentManage.Domain.base.Role.*;
import static org.revo.TalentManage.Domain.base.Role.Paths.*;

@EnableWebFluxSecurity
public class Security {
    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity http) {
        http.exceptionHandling().authenticationEntryPoint((exchange, e) -> {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }).and()
                .authorizeExchange()

                .pathMatchers(PERSON_PATH, PERSON_PATH + "/*/**").hasRole(PERSON.getRole())
                .pathMatchers(ADMIN_PATH, ADMIN_PATH + "/*/**").hasRole(ADMIN.getRole())
                .pathMatchers(AGENCY_PATH, AGENCY_PATH + "/*/**").hasRole(AGENCY.getRole())

                .pathMatchers("/auth/user").authenticated()
                .anyExchange().permitAll()
                .and().csrf().and()
                .formLogin()
                .loginPage("/login")
                .authenticationFailureHandler((exchange, e) -> {
                    exchange.getExchange().getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return Mono.empty();
                })
                .authenticationSuccessHandler((webFilterExchange, authentication) -> {
                    webFilterExchange.getExchange().getResponse().setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                })
                .and()
                .logout()
                .logoutUrl("/signout")
                .logoutSuccessHandler((exchange, authentication) -> {
                    exchange.getExchange().getResponse().setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                });
        return http.build();
    }

    @Bean
    public ReactiveUserDetailsService userDetailsService(PersonService personService, AgencyService agencyService) {
        return s -> {
            Mono<UserDetails> personMono = personService.findByUsername(s)
                    .map(Mono::just)
                    .orElseGet(Mono::empty)
                    .cast(UserDetails.class);
            Mono<UserDetails> agencyMono = agencyService.findByUsername(s)
                    .map(Mono::just)
                    .orElseGet(Mono::empty)
                    .cast(UserDetails.class);
            return personMono.switchIfEmpty(agencyMono);
        };
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuditorAware<Long> aware(UserService userService) {
        return userService::currentUser;
    }
}
