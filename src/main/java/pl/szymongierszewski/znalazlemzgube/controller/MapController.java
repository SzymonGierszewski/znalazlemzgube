package pl.szymongierszewski.znalazlemzgube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.szymongierszewski.znalazlemzgube.dto.MarkerFormDto;

import javax.validation.Valid;

@Controller
public class MapController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayMap() {
        return "map";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addMarker(@ModelAttribute("markerForm") @Valid MarkerFormDto markerFormDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        } else {
            return "map";
        }
    }
}
