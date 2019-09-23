package pl.szymongierszewski.znalazlemzgube.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymongierszewski.znalazlemzgube.dao.MarkerDao;
import pl.szymongierszewski.znalazlemzgube.dto.MarkerFormDto;
import pl.szymongierszewski.znalazlemzgube.model.Marker;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkerService {

    private final ModelMapper modelMapper;
    private final MarkerDao markerDao;

    @Autowired
    public MarkerService(ModelMapper modelMapper, MarkerDao markerDao) {
        this.modelMapper = modelMapper;
        this.markerDao = markerDao;
    }

    public List<MarkerFormDto> getMarkerDtoList() {
        List<MarkerFormDto> markerFormDtoList = new ArrayList<>();
        markerDao.findAll()
                .forEach(marker -> markerFormDtoList.add(
                        modelMapper.map(marker, MarkerFormDto.class)));
        return markerFormDtoList;
    }

    public void createMarker(MarkerFormDto markerFormDto) {
        Marker marker = modelMapper.map(markerFormDto, Marker.class);
        markerDao.save(marker);
    }

}
