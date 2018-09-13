package org.revo.TalentManage.Domain.base;

import lombok.Getter;

import static org.revo.TalentManage.Domain.base.Role.Paths.*;

@Getter
public enum Role {
    PERSON("PERSON", PERSON_PATH), AGENCY("AGENCY", AGENCY_PATH), ADMIN("ADMIN", ADMIN_PATH);
    private String role;
    private String path;

    Role(String role, String path) {
        this.role = role;
        this.path = path;
    }

    public String getBuildRole() {
        return "ROLE_" + role;
    }

    public static class Paths {
        public static final String PERSON_PATH = "/api/person";
        public static final String AGENCY_PATH = "/api/agency";
        public static final String ADMIN_PATH = "/api/admin";
    }
}