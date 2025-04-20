package ahm.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {

    @RequestMapping(value="/login", method={RequestMethod.GET, RequestMethod.POST})
    public String requestMethodName(@RequestParam(value="error", required = false) String param, 
                                    @RequestParam(value="logout", required = false) String param2) {
        return "login";
    }
    

}