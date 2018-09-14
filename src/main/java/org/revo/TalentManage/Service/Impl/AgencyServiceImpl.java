package org.revo.TalentManage.Service.Impl;

import org.revo.TalentManage.Domain.Agency;
import org.revo.TalentManage.Repository.AgencyRepository;
import org.revo.TalentManage.Service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Long count() {
        return agencyRepository.count();
    }

    @Override
    public List<Agency> save(List<Agency> agencies) {
        return StreamSupport.stream(agencyRepository.saveAll(agencies).spliterator(), false).collect(toList());
    }

    @Override
    public Optional<Agency> findByUsername(String username) {
        return agencyRepository.findByUsername(username);
    }

    @Override
    public List<Agency> findAll() {
        return StreamSupport.stream(agencyRepository.findAll().spliterator(), false).collect(toList());
    }

    @Override
    public Agency save(Agency agency) {
        agency.setPassword(encoder.encode(agency.getPassword()));
        return agencyRepository.save(agency);
    }


}
