package com.projektZETO.signup.rejestracja;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rejestracja")
@CrossOrigin("*")
@AllArgsConstructor
public class RejestracjaController {

    private RejestracjaService rejestracjaService;

    @PostMapping
    public String rejestracja(@RequestBody RejestracjaRequest request)
    {
        return rejestracjaService.rejestracja(request);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return rejestracjaService.tokenPotwierdzenia(token);
    }

}
