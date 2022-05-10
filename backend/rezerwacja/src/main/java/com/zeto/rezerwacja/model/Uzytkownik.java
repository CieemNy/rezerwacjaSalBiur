package com.zeto.rezerwacja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "uzytkownicy")
public class Uzytkownik implements UserDetails
{

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long idUzytkownik;
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    private String telefon;

    // uzytkownik ma wiele rol
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, mappedBy = "uzytkownik")
    @JsonIgnore
    private Set<UzytkownikRola> UzytkownikRole=new HashSet<>();



    public Uzytkownik() {

    }

    public Set<UzytkownikRola> getUzytkownikRole() {
        return UzytkownikRole;
    }

    public void setUzytkownikRole(Set<UzytkownikRola> uzytkownikRole) {
        UzytkownikRole = uzytkownikRole;
    }

    public Uzytkownik(Long idUzytkownik, String imie, String nazwisko, String email, String haslo, String telefon) {
        this.idUzytkownik = idUzytkownik;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.telefon = telefon;
    }

    public Long getIdUzytkownik() {
        return idUzytkownik;
    }

    public void setIdUzytkownik(Long idUzytkownik) {
        this.idUzytkownik = idUzytkownik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Authority> set = new HashSet<>();

        this.UzytkownikRole.forEach(uzytkownikRola -> {
            set.add(new Authority(uzytkownikRola.getRola().getRolaNazwa()));
        });

        return set;
    }

    @Override
    public String getPassword() {
        return haslo;
    }

    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

