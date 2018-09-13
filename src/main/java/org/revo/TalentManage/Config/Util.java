package org.revo.TalentManage.Config;

import org.revo.TalentManage.Service.AgencyService;
import org.revo.TalentManage.Service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Util {
    @Bean
    public CommandLineRunner runner(Env env, PersonService personService, AgencyService agencyService) {
        return args -> {
            if (env.getPeople().size() > 0 && personService.count() == 0)
                personService.save(env.getPeople());
            if (env.getAgencies().size() > 0 && agencyService.count() == 0)
                agencyService.save(env.getAgencies());
        };
    }
}
