package org.revo.TalentManage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.revo.TalentManage.Domain.Agency;
import org.revo.TalentManage.Domain.Interview;
import org.revo.TalentManage.Domain.Person;
import org.revo.TalentManage.Service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TalentManageApplicationTests {
    @Autowired
    private InterviewService interviewService;

    @Test
    public void contextLoads() {
        Interview inv = new Interview();
        inv.setAgency(new Agency(3L));
        inv.setPerson(new Person(2L));
        inv.setInterviewDate(new Date());

        Interview save = interviewService.save(inv);


        for (Interview interview : interviewService.findAll()) {
            System.out.println(interview.getId());
        }

    }

}
