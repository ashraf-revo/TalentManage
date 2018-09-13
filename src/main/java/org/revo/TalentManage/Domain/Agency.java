package org.revo.TalentManage.Domain;

import org.revo.TalentManage.Domain.base.BaseUser;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Agency extends BaseUser {
    public Agency() {
    }

    public Agency(Long id) {
        super(id);
    }

    private String agencyName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agency")
    private List<Interview> interviews = new ArrayList<>();
}
