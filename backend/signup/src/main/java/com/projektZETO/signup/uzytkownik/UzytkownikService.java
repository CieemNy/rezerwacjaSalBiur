package com.projektZETO.signup.uzytkownik;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UzytkownikService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "Email %s nie jest powiazany z zadnym kontem!";
    private final UzytkownikRepository uzytkownikRepository;
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return uzytkownikRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
}
