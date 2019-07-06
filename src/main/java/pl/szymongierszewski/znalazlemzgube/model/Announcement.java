package pl.szymongierszewski.znalazlemzgube.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class Announcement {

//    @NotNull
//    private Geolocation geolocation;
    @NotNull
    private Content content;
    @NotNull
    private Finder finder;
    @PastOrPresent
    private LocalDate localDate;
}
