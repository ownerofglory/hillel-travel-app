package ua.ithillel.travelapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.ithillel.travelapp.auth.AppUserDetails;
import ua.ithillel.travelapp.model.entity.User;
import ua.ithillel.travelapp.repo.UserRepo;

@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userRepo.findByUsername(username);

        return new AppUserDetails(byUsername);

//        return org.springframework.security.core.userdetails.User
//                .withUsername(byUsername.getEmail())
//                .password(byUsername.getPassword())
//                .build();
    }
}
