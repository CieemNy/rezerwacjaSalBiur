package com.zeto.rezerwacja.model;

public class JwtRequest {
    String email;
    String haslo;

    public JwtRequest() {
    }

    public JwtRequest(String email, String haslo) {
        this.email = email;
        this.haslo = haslo;
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
}
