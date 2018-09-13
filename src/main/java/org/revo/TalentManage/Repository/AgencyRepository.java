package org.revo.TalentManage.Repository;

import org.revo.TalentManage.Domain.Agency;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AgencyRepository extends CrudRepository<Agency, Long> {
    Optional<Agency> findByUsername(String username);
}
