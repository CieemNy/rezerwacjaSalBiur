package com.projektZETO.signup.rejestracja;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/rejestracja")
@AllArgsConstructor
public class RejestracjaController {

    private RejestracjaService rejestracjaService;

    @PostMapping
    public String rejestracja(@RequestBody RejestracjaRequest request)
    {
        return rejestracjaService.rejestracja(request);
    }

}
