package pl.szymongierszewski.znalazlemzgube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.szymongierszewski.znalazlemzgube.dto.MarkerFormDto;
import pl.szymongierszewski.znalazlemzgube.service.MarkerService;

import javax.validation.Valid;

@Controller
public class MapController {

    private final MarkerService markerService;

    @Autowired
    public MapController(MarkerService markerService) {
        this.markerService = markerService;
    }

    @GetMapping("/")
    public ModelAndView displayMap() {
        return new ModelAndView("map", "markerForm", new MarkerFormDto());
    }

    @PostMapping("/")
    public String addMarker(@ModelAttribute("markerForm") @Valid MarkerFormDto markerFormDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        } else {
            markerService.createMarker(markerFormDto);
            return "map";
        }
    }
}
