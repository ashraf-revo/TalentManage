package org.revo.TalentManage.Controller;

import org.revo.TalentManage.Domain.Agency;
import org.revo.TalentManage.Domain.Interview;
import org.revo.TalentManage.Domain.base.BaseUser;
import org.revo.TalentManage.Repository.AgencyRepository;
import org.revo.TalentManage.Service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static org.revo.TalentManage.Domain.base.Role.Paths.AGENCY_PATH;

@RestController
@RequestMapping(AGENCY_PATH)
public class AgencyController {
    @Autowired
    private AgencyRepository agencyRepository;
    @Autowired
    private InterviewService interviewService;

    @GetMapping("profile/{id}")
    public Agency agency(@PathVariable("id") Long id) {
        Agency agency = agencyRepository.findById(id).get();
        agency.setInterviews(null);
        return agency;
    }

    @PostMapping("interview")
    public void interview(@RequestBody Interview interview, @AuthenticationPrincipal BaseUser baseUser) {
        System.out.println("come");
        if (interview.getPerson().getId() != interview.getAgency().getId()) {
            interview.setCreatedBy(baseUser.getId());
            interviewService.save(interview);
        }
    }

}
