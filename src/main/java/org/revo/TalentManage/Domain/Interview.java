package org.revo.TalentManage.Domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Interview {
    @Id
    @GeneratedValue
    private Long id;
    @CreatedDate
    private Date createdDate;
    @ManyToOne
    @JoinColumn
    private Agency agency;
    @ManyToOne
    @JoinColumn
    private Person person;
    private Date interviewDate;
    @CreatedBy
    private Long createdBy;
}