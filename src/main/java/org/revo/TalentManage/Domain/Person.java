package org.revo.TalentManage.Domain;

import lombok.Getter;
import lombok.Setter;
import org.revo.TalentManage.Domain.base.BaseUser;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Person extends BaseUser {
    public Person() {
    }

    public Person(Long id) {
        super(id);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Interview> interviews = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    public List<String> skills;
}
