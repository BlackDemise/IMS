package org.example.interviewmanagement.configurations;

import lombok.NonNull;
import org.example.interviewmanagement.entities.User;
import org.example.interviewmanagement.entities.UserRole;
import org.example.interviewmanagement.repositories.RoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Users implements UserDetails {
    private final User user;
    private RoleRepository roleRepository;

    public Users(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<UserRole> roleList = (List<UserRole>) roleRepository.findUserRoleBy(username);
//
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        if (roleList != null) {
//            for (UserRole r : roleList) {
//                GrantedAuthority ga = new SimpleGrantedAuthority(r.getRoleName());
//                grantedAuthorities.add(ga);
//            }
//        }
        return null;
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
}
