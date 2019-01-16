package com.userForm.userform.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class WelcomeController {

    @RequestMapping(path = "/")
    public @ResponseBody String Welcome() {
        return "Wecome to Userform API";
    }
}
