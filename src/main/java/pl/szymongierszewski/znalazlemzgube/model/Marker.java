package pl.szymongierszewski.znalazlemzgube.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class Marker {

//    @NotNull
//    private Geolocation geolocation;
    @NotNull
    private FoundObject foundObject;
    @NotNull
    private Finder finder;
    @PastOrPresent
    private LocalDate localDate;
}
