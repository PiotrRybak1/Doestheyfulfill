package pl.coderslab.doestheyfulfill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.doestheyfulfill.domain.Rating;
import pl.coderslab.doestheyfulfill.domain.Role;
import pl.coderslab.doestheyfulfill.domain.User;
import pl.coderslab.doestheyfulfill.repository.RoleRepository;

import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRole(String name){
       return roleRepository.findByName(name);
    }

}
