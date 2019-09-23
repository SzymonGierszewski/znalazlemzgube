package pl.szymongierszewski.znalazlemzgube.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.szymongierszewski.znalazlemzgube.dao.MarkerDao;
import pl.szymongierszewski.znalazlemzgube.dto.MarkerFormDto;
import pl.szymongierszewski.znalazlemzgube.model.Marker;

import javax.validation.Valid;

@Controller
public class MapController {

    private final ModelMapper modelMapper;
    private final MarkerDao markerDao;

    @Autowired
    public MapController(ModelMapper modelMapper, MarkerDao markerDao) {
        this.modelMapper = modelMapper;
        this.markerDao = markerDao;
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
            Marker marker = modelMapper.map(markerFormDto, Marker.class);
            markerDao.save(marker);
            return "map";
        }
    }
}
