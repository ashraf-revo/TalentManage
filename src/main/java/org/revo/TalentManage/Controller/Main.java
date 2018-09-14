package org.revo.TalentManage.Controller;

import org.revo.TalentManage.Domain.base.BaseUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @GetMapping("/auth/user")
    public BaseUser user(@AuthenticationPrincipal BaseUser baseUser) {
        return baseUser;
    }
}
