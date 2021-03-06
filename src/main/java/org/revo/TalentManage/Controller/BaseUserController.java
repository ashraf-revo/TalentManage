package org.revo.TalentManage.Controller;

import org.revo.TalentManage.Domain.Agency;
import org.revo.TalentManage.Domain.Interview;
import org.revo.TalentManage.Domain.Person;
import org.revo.TalentManage.Domain.base.BaseUser;
import org.revo.TalentManage.Repository.AgencyRepository;
import org.revo.TalentManage.Repository.PersonRepository;
import org.revo.TalentManage.Service.AgencyService;
import org.revo.TalentManage.Service.InterviewService;
import org.revo.TalentManage.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@RequestMapping("/api")
@RestController
public class BaseUserController {
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private PersonService personService;
    @Autowired
    private AgencyService agencyService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AgencyRepository agencyRepository;

    @PostMapping("person")
    public ResponseEntity savePerson(@RequestBody @Valid Person person) {
        person.setType("010");
        return ResponseEntity.ok().body(personService.save(person));
    }

    @PostMapping("agency")
    public ResponseEntity saveAgency(@RequestBody @Valid Agency agency) {
        agency.setType("001");
        return ResponseEntity.ok().body(agencyService.save(agency));
    }

    @GetMapping("persons")
    public Iterable<Person> people() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .map(it -> {
                    it.setInterviews(null);
                    return it;
                })

                .collect(toList());
    }

    @GetMapping("user/{id}")
    public BaseUser user(@PathVariable("id") Long id) {

        Optional<Person> byId1 = personRepository.findById(id);
        if (byId1.isPresent()) {
            byId1.get().setInterviews(null);
            byId1.get().setSkills(null);
            return byId1.get();
        }
        Optional<Agency> byId2 = agencyRepository.findById(id);
        if (byId2.isPresent()) {
            byId2.get().setInterviews(null);
            return byId2.get();
        }
        return null;
    }

    @GetMapping("interviews")
    public List<Interview> interviews(@AuthenticationPrincipal BaseUser baseUser) {

        if (baseUser.getType().charAt(1) == '1')
            return interviewService.findAllByPerson(baseUser.getId()).
                    stream().map(it -> {
                it.getAgency().setInterviews(null);
                it.getPerson().setInterviews(null);
                return it;
            }).collect(toList());

        if (baseUser.getType().charAt(2) == '1')
            return interviewService.findAllByAgency(baseUser.getId()).
                    stream().map(it -> {
                it.getAgency().setInterviews(null);
                it.getPerson().setInterviews(null);
                return it;
            }).collect(toList());
        return null;
    }

}
