package com.zeto.rezerwacja.controller;

import com.zeto.rezerwacja.config.JwtUtils;
import com.zeto.rezerwacja.service.impl.UzytkownikDetalisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController
{



    @Autowired
    private AuthenticatedAuthorizationManager authenticatedAuthorizationManager;

    @Autowired
    private UzytkownikDetalisServiceImpl uzytkownikDetalisService;

    @Autowired
    private JwtUtils jwtUtils;


    private void authenticate(String email,String haslo)
    {

    }

}
