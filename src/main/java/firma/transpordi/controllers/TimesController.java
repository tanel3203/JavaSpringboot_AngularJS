package firma.transpordi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimesController {

    @RequestMapping("/times")
    public String getTimes() {
        return "times";
    }

}