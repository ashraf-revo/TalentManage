package org.revo.TalentManage.Config;

import lombok.Getter;
import lombok.Setter;
import org.revo.TalentManage.Domain.Agency;
import org.revo.TalentManage.Domain.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties("org.revo.env")
@Getter
@Setter
public class Env {
    private List<Person> people = new ArrayList<>();
    private List<Agency> agencies = new ArrayList<>();
}
