package com.zeto.rezerwacja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rola")
public class Rola {

    @Id
    private Long rolaId;
    private String rolaNazwa;

    @OneToMany(targetEntity = UzytkownikRola.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rola")
    private Set<UzytkownikRola> UzytkownikRole =new HashSet<>();

    public Rola() {
    }

    public Set<UzytkownikRola> getUzytkownikRole() {
        return UzytkownikRole;
    }

    public void setUzytkownikRole(Set<UzytkownikRola> uzytkownikRole) {
        UzytkownikRole = uzytkownikRole;
    }

    public Rola(Long rolaId, String rolaNazwa) {
        this.rolaId = rolaId;
        this.rolaNazwa = rolaNazwa;
    }

    public Long getRolaId() {
        return rolaId;
    }

    public void setRolaId(Long rolaId) {
        this.rolaId = rolaId;
    }

    public String getRolaNazwa() {
        return rolaNazwa;
    }

    public void setRolaNazwa(String rolaNazwa) {
        this.rolaNazwa = rolaNazwa;
    }
}
