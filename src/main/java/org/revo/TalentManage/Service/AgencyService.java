package org.revo.TalentManage.Service;

import org.revo.TalentManage.Domain.Agency;
import org.revo.TalentManage.Domain.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

public interface AgencyService {

    Long count();

    List<Agency> save(List<Agency> agencies);

    Optional<Agency> findByUsername(String username);
 List<Agency> findAll();
}
