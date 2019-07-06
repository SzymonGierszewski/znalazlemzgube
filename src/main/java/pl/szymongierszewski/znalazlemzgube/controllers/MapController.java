package pl.szymongierszewski.znalazlemzgube.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapController {

    @RequestMapping(method = RequestMethod.GET)
    public String displayMap() {
        return "map";
    }

}
