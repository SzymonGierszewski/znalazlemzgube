package pl.szymongierszewski.znalazlemzgube.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymongierszewski.znalazlemzgube.dao.MarkerDao;
import pl.szymongierszewski.znalazlemzgube.dto.MarkerDto;
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

    public List<MarkerDto> getMarkerDtoList() {
        List<MarkerDto> markerDtoList = new ArrayList<>();
        markerDao.findAll()
                .forEach(marker -> markerDtoList.add(
                        modelMapper.map(marker, MarkerDto.class)));
        return markerDtoList;
    }

    public void createMarker(MarkerDto markerDto) {
        Marker marker = modelMapper.map(markerDto, Marker.class);
        markerDao.save(marker);
    }

}
