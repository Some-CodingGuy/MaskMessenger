package be.n.maskmessengerapp.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/")
    public String home(){
        return "templates/home.html";
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1> Welcome to the user home</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1> Welcome to the admin home </h1>");
    }
}
