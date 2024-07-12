package pl.coderslab.doestheyfulfill.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.coderslab.doestheyfulfill.domain.Role;
import pl.coderslab.doestheyfulfill.repository.RoleRepository;
import pl.coderslab.doestheyfulfill.service.UserService;

@Component
@RequiredArgsConstructor
public class UserAdminTest implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserService userService;


    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName("ROLE_USER") == null) {
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        userService.registerDefaultUser("user@gmail.com", "user", "password");
        userService.registerAdmin("admin@gmail.com", "admin", "adminpassword");
    }
}

