package pl.coderslab.doestheyfulfill.domain;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

public interface MyUserDetailsService extends UserDetailsService {
    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
