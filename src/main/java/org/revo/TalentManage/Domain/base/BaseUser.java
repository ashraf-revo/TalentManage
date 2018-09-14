package org.revo.TalentManage.Domain.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static java.util.stream.Collectors.toList;

@MappedSuperclass
public abstract class BaseUser implements UserDetails {
    private String type = "000";

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String username;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @JsonProperty(access = WRITE_ONLY)
    @NotBlank
    private String password;
    @NotBlank
    @Column(unique = true)
    private String phone;

    public BaseUser() {
    }

    public BaseUser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roles = new ArrayList<>();
        if (getType().charAt(0) == '1') {
            roles.add(Role.ADMIN.getBuildRole());
            roles.add("ROLE_ACTUATOR");
        }
        if (getType().charAt(1) == '1') {
            roles.add(Role.PERSON.getBuildRole());
        }
        if (getType().charAt(2) == '1') {
            roles.add(Role.AGENCY.getBuildRole());
        }
        return roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
