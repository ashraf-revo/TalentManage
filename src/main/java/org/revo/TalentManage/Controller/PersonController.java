package org.revo.TalentManage.Controller;

import org.revo.TalentManage.Domain.Interview;
import org.revo.TalentManage.Domain.base.BaseUser;
import org.revo.TalentManage.Service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.revo.TalentManage.Domain.base.Role.Paths.PERSON_PATH;

@RestController
@RequestMapping(PERSON_PATH)
public class PersonController {
    @Autowired
    private InterviewService interviewService;

    @GetMapping("interviews")
    public List<Interview> interviews(@AuthenticationPrincipal BaseUser baseUser) {
        return interviewService.findAllByPerson(baseUser.getId());
    }

}
