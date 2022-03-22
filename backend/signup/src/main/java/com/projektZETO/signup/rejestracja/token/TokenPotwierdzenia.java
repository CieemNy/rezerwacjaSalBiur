package com.projektZETO.signup.rejestracja.token;

import com.projektZETO.signup.uzytkownik.Uzytkownik;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class TokenPotwierdzenia {

    @Id
    @SequenceGenerator(
            name = "token_potwierdzenia_sequence",
            sequenceName = "uzytkownik_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_potwierdzenia_sequence"
    )

    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "uzytkownik_id"
    )
    private Uzytkownik uzytkownik;

    public TokenPotwierdzenia(String token,
                              LocalDateTime createdAt,
                              LocalDateTime expiresAt,
                              Uzytkownik uzytkownik)
    {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.uzytkownik = uzytkownik;
    }


}
