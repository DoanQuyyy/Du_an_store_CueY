package com.example.cueyshop.services;

import com.example.cueyshop.model.CustomUserDetail;
import com.example.cueyshop.model.User;
import com.example.cueyshop.model.User_roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailServies implements UserDetailsService {

    @Autowired
    private UserServies userServies;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServies.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<User_roles> roles = user.getUserRoles();
        for (User_roles userrole : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(userrole.getRole().getName()));
        }
        return new CustomUserDetail(user, grantedAuthorities);
    }

}
