package cinema.service.impl;

import static org.springframework.security.core.userdetails.User.withUsername;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetalisService implements UserDetailsService {
    private final UserService userService;
    
    public CustomUserDetalisService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByEmail(username).orElseThrow(()
                -> new UsernameNotFoundException("User not found"));
        UserBuilder userBuilder = withUsername(username).password(user.getPassword())
                .roles(user.getRoles().stream()
                        .map(Role::getRoleName).toArray(String[]::new));
        return userBuilder.build();
    }
}
