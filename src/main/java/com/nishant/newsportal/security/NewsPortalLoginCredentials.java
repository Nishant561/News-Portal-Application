package com.nishant.newsportal.security;


import com.nishant.newsportal.model.Role;
import com.nishant.newsportal.model.User;
import com.nishant.newsportal.repository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class NewsPortalLoginCredentials implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public  Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        User result = userRepository.findByEmail(email);

        if(result!=null && result.getUserId()>0 && passwordEncoder.matches(pwd, result.getPassword())){
            return new UsernamePasswordAuthenticationToken(
                    result.getEmail(),
                    null,
                    getGrantedAuthorities(result.getUserRoles())

            );
        }
        throw new BadCredentialsException("Invalid credentials!");

    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


    private List<GrantedAuthority> getGrantedAuthorities(Set<Role> role){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role1 : role){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role1.getRoleName()));
        }

        return grantedAuthorities;
    }
}
