package org.revo.TalentManage.Service.Impl;

import org.revo.TalentManage.Domain.Person;
import org.revo.TalentManage.Repository.PersonRepository;
import org.revo.TalentManage.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Long count() {
        return personRepository.count();
    }

    @Override
    public List<Person> save(List<Person> people) {
        return StreamSupport.stream(personRepository.saveAll(people).spliterator(), false).collect(toList());
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    @Override
    public List<Person> findAll() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false).collect(toList());
    }

    @Override
    public Person save(Person person) {
        person.setPassword(encoder.encode(person.getPassword()));
        return personRepository.save(person);
    }


}
