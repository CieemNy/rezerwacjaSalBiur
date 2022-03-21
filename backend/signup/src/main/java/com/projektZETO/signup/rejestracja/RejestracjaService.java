package com.projektZETO.signup.rejestracja;

import com.projektZETO.signup.uzytkownik.Uzytkownik;
import com.projektZETO.signup.uzytkownik.UzytkownikRola;
import com.projektZETO.signup.uzytkownik.UzytkownikService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RejestracjaService {

    private final UzytkownikService uzytkownikService;
    private final EmailValidator emailValidator;
    public String rejestracja(RejestracjaRequest request) {

        boolean isValidEmail = emailValidator.
                test(request.getAdresEmail());
        if(!isValidEmail)
        {
            throw new IllegalStateException("email nieprawidlowy");
        }
        return uzytkownikService.rejestracjaUzytkownik(
                new Uzytkownik(
                        request.getImie(),
                        request.getNazwisko(),
                        request.getAdresEmail(),
                        request.getHaslo(),
                        request.getNrTelefonu(),
                        UzytkownikRola.KLIENT
                )
        );
    }
}
