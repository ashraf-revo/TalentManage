package org.revo.TalentManage.Service;

import org.revo.TalentManage.Domain.Agency;

import java.util.List;
import java.util.Optional;

public interface AgencyService {

    Long count();

    List<Agency> save(List<Agency> agencies);

    Optional<Agency> findByUsername(String username);

    List<Agency> findAll();

    Agency save(Agency agency);
}
