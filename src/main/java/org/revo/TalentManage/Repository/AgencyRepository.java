package org.revo.TalentManage.Repository;

import org.revo.TalentManage.Domain.Agency;
import org.revo.TalentManage.Domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AgencyRepository extends CrudRepository<Agency, Long> {
    Optional<Agency> findByUsername(String username);
    Optional<Agency> findByEmail(String email);
    Optional<Agency> findByPhone(String phone);
}
