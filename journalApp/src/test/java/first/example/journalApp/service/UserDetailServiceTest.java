package first.example.journalApp.service;

import first.example.journalApp.entity.User;
import first.example.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserDetailServiceTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void loadUserByUsernameTest() {
        User testUser = User.builder()
                .userName("riya")
                .password("inrinrick")
                .roles(new ArrayList<>())
                .build();

        when(userRepository.findByUserName(anyString())).thenReturn(testUser);

        UserDetails user = userDetailsService.loadUserByUsername("riya");
        Assertions.assertNotNull(user);
    }
}