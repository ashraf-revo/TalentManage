package org.revo.TalentManage.Domain;

import lombok.Getter;
import lombok.Setter;
import org.revo.TalentManage.Domain.base.BaseUser;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Agency extends BaseUser {
    public Agency() {
    }

    public Agency(Long id) {
        super(id);
    }

    @NotBlank
    private String agencyName;
    @NotBlank
    private String website;
    @Embedded
    @NotNull
    private Addresses addresses;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agency")
    private List<Interview> interviews = new ArrayList<>();

}
