package org.revo.TalentManage.Repository;

import org.revo.TalentManage.Domain.Interview;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InterviewRepository extends CrudRepository<Interview, Long> {
    List<Interview> findByAgency_Id(Long id);

    List<Interview> findByPerson_Id(Long id);
}
