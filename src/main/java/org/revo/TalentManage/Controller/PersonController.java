package org.revo.TalentManage.Controller;

import org.revo.TalentManage.Domain.Person;
import org.revo.TalentManage.Domain.base.BaseUser;
import org.revo.TalentManage.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.revo.TalentManage.Domain.base.Role.Paths.PERSON_PATH;

@RestController
@RequestMapping(PERSON_PATH)
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("profile/{id}")
    public Person person(@PathVariable("id") Long id) {
        Person person = personRepository.findById(id).get();
        person.setInterviews(null);
        return person;
    }

    @GetMapping("skills")
    public List<String> skills(@AuthenticationPrincipal BaseUser baseUser) {
        return personRepository.findById(baseUser.getId()).get().getSkills();
    }


}
