package pl.coderslab.doestheyfulfill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.doestheyfulfill.domain.Role;
import pl.coderslab.doestheyfulfill.domain.User;
import pl.coderslab.doestheyfulfill.repository.RoleRepository;
import pl.coderslab.doestheyfulfill.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void add(User user){
        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);
        user.getRoles().add(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public List<User> users() {
        return userRepository.findAll();
    }

    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void update(User user) {
        userRepository.save(user);

    }

    public void registerDefaultUser(String email, String userName, String password) {
        if (userRepository.findByEmail(email) == null) {
            User user = new User();
            user.setEmail(email);
            user.setUserName(userName);
            user.setPassword(passwordEncoder.encode(password));
            user.setEnabled(true);

            // Set<Role> roles = new HashSet<>();
            user.getRoles().add(roleRepository.findByName("ROLE_USER"));
            //user.setRoles(roles);

            userRepository.save(user);
        }
    }


    public void registerAdmin(String email, String username, String password) {
        if (userRepository.findByEmail(email) == null) {
            User user = new User();
            user.setEmail(email);
            user.setUserName(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setEnabled(true);
            user.getRoles().add(roleRepository.findByName("ROLE_USER"));
            user.getRoles().add(roleRepository.findByName("ROLE_ADMIN"));
            userRepository.save(user);
        }
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
            return userRepository.findUserByUserName(username);
        }
        return null;
    }
}


