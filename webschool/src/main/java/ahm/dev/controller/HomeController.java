package ahm.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/home", "index"})
public class HomeController {
    @RequestMapping
    public String home() {
        return "home";
    }
}
