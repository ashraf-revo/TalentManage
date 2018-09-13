package org.revo.TalentManage.Service.Impl;

import org.revo.TalentManage.Domain.base.BaseUser;
import org.revo.TalentManage.Service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Optional<Long> currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null && authentication.getPrincipal() instanceof BaseUser)
            return Optional.of(((BaseUser) authentication.getPrincipal()).getId());
        return Optional.empty();
    }
}
