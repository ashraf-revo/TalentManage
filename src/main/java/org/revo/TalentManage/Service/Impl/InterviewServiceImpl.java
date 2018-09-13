package org.revo.TalentManage.Service.Impl;

import org.revo.TalentManage.Domain.Interview;
import org.revo.TalentManage.Repository.InterviewRepository;
import org.revo.TalentManage.Service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public Interview save(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public List<Interview> findAll() {
        return StreamSupport.stream(interviewRepository.findAll().spliterator(), false).collect(toList());
    }

    @Override
    public List<Interview> findAllByPerson(Long id) {
        return interviewRepository.findByPerson_Id(id);
    }

    @Override
    public List<Interview> findAllByAgency(Long id) {
        return interviewRepository.findByAgency_Id(id);
    }

}
