package org.revo.TalentManage.Service;

import org.revo.TalentManage.Domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Long count();

    List<Person> save(List<Person> people);

    Optional<Person> findByUsername(String username);

    List<Person> findAll();
}
