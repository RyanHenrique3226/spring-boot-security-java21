package spring.boot.security.java21;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome(){
        return "Bem vindo a API Spring Boot";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('MANAGER', 'USER')")
    public String users(){
        return "Autorized user";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAnyRole('MANAGER')")
    public String manager(){
        return "Autorized manager";
    }

}
