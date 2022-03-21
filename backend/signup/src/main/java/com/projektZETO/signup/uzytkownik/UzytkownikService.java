package com.projektZETO.signup.uzytkownik;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UzytkownikService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "Email %s nie jest powiazany z zadnym kontem!";
    private final UzytkownikRepository uzytkownikRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return uzytkownikRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
    public String rejestracjaUzytkownik(Uzytkownik uzytkownik)
    {
        boolean uzytkownikIstnieje = uzytkownikRepository.findByEmail(uzytkownik.getEmail())
                .isPresent();
        if (uzytkownikIstnieje)
        {
            throw new IllegalStateException("Ten email jest juz zajety");
        }
        String hasloEncoded = bCryptPasswordEncoder.encode(uzytkownik.getPassword());

        uzytkownik.setHaslo(hasloEncoded);

        uzytkownikRepository.save(uzytkownik);
        //TODO: send confirmation token
        return "dziala";
    }
}
