package org.revo.TalentManage.Service;

import org.revo.TalentManage.Domain.Interview;

import java.util.List;

public interface InterviewService {

    Interview save(Interview interview);

    List<Interview> findAll();

    List<Interview> findAllByPerson(Long id);

    List<Interview> findAllByAgency(Long id);

}
