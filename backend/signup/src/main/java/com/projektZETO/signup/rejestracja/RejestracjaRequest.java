package com.projektZETO.signup.rejestracja;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RejestracjaRequest {
    private final String imie;
    private final String nazwisko;
    private final String email;
    private final String nrTelefonu;
    private final String haslo;
}
