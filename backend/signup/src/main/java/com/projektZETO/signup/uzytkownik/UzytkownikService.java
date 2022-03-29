package com.projektZETO.signup.uzytkownik;

import com.projektZETO.signup.rejestracja.token.TokenPotwierdzenia;
import com.projektZETO.signup.rejestracja.token.TokenPotwierdzeniaService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UzytkownikService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "Email %s nie jest powiazany z zadnym kontem!";
    private final UzytkownikRepository uzytkownikRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenPotwierdzeniaService tokenPotwierdzeniaService;

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
        String token = UUID.randomUUID().toString();

        TokenPotwierdzenia tokenPotwierdzenia = new TokenPotwierdzenia(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                uzytkownik
        );

        tokenPotwierdzeniaService.zapiszTokenPotwierdzenia(
                tokenPotwierdzenia);

        return token;
    }

    public int enableUzytkownik(String email)
    {
        return uzytkownikRepository.enableUzytkownik(email);
    }

    public List<Uzytkownik> listAll()
    {
        return (List<Uzytkownik>) uzytkownikRepository.findAll();
    }

    public void save(Uzytkownik uzytkownik)
    {
        uzytkownikRepository.save(uzytkownik);
    }
}
