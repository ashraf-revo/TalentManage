package org.revo.TalentManage.Repository;

import org.revo.TalentManage.Domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findByUsername(String username);
}
