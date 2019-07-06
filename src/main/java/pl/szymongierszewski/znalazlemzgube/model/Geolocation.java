package pl.szymongierszewski.znalazlemzgube.model;

import javax.validation.constraints.NotNull;

public class Geolocation {

    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
}
