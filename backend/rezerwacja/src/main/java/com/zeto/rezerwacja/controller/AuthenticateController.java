package com.zeto.rezerwacja.controller;

import com.zeto.rezerwacja.config.JwtUtils;
import com.zeto.rezerwacja.exception.ResourceNotFoundException;
import com.zeto.rezerwacja.model.JwtRequest;
import com.zeto.rezerwacja.model.JwtResponse;
import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.service.impl.UzytkownikDetalisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController
{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UzytkownikDetalisServiceImpl uzytkownikDetalisService;

    @Autowired
    private JwtUtils jwtUtils;

    public AuthenticateController() {
    }

    //generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try
        {
            authenticate(jwtRequest.getEmail(), jwtRequest.getHaslo());

        }catch(ResourceNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("Uzytkownik nie znaleziony");
        }
        /////authenticate
        UserDetails userDetails = this.uzytkownikDetalisService.loadUserByUsername(jwtRequest.getEmail());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    private void authenticate(String email,String haslo) throws Exception {

        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, haslo));

        }catch(DisabledException e)
        {
            throw new Exception("Uzytkownik zablokowany"+e.getMessage());
        }catch (BadCredentialsException e)
        {
            throw new Exception("Niepoprawne dane"+e.getMessage());
        }
    }
    @GetMapping("/current-user")
    public Uzytkownik getCurrentUser(Principal principal){
        return ((Uzytkownik)this.uzytkownikDetalisService.loadUserByUsername(principal.getName()));
    }


}
