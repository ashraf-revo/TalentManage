package org.revo.TalentManage.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class Addresses {
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String street;
}
