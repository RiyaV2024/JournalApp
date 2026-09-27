package first.example.journalApp.service;

import first.example.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserEntryService userEntryService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userEntryService.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<String> roles = user.getRoles();
        if (roles == null || roles.isEmpty()) {
            roles = List.of("USER");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .roles(roles.toArray(new String[0]))
                .build();
    }
}