package org.revo.TalentManage.Controller;

import org.revo.TalentManage.Domain.Agency;
import org.revo.TalentManage.Repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.revo.TalentManage.Domain.base.Role.Paths.AGENCY_PATH;

@RestController
@RequestMapping(AGENCY_PATH)
public class AgencyController {
    @Autowired
    private AgencyRepository agencyRepository;

    @GetMapping("profile/{id}")
    public Agency agency(@PathVariable("id") Long id) {
        Agency agency = agencyRepository.findById(id).get();
        agency.setInterviews(null);
        return agency;
    }

}
