package com.projektZETO.signup.uzytkownik;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Uzytkownik implements UserDetails{

    @Id
    @SequenceGenerator(
            name = "uzytkownik_sequence",
            sequenceName = "uzytkownik_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "uzytkownik_sequence"
    )
    private Long idUzytkownik;
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    private String nrTelefonu;
    @Enumerated(EnumType.STRING)
    private UzytkownikRola uzytkownikRola;
    private Boolean locked = false;
    private Boolean enabled = false;

    public Uzytkownik(String imie,
                      String nazwisko,
                      String email,
                      String haslo,
                      String nrTelefonu,
                      UzytkownikRola uzytkownikRola)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.nrTelefonu = nrTelefonu;
        this.uzytkownikRola = uzytkownikRola;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(uzytkownikRola.name());
        return Collections.singletonList(authority);
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    @Override
    public String getUsername(){
        return email;
    }
    @Override
    public String getPassword() {
        return haslo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}