package pl.szymongierszewski.znalazlemzgube.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class MarkerFormDto {

    @NotNull
    private Double geolocationLatitude;
    @NotNull
    private Double geolocationLongitude;
    @NotBlank
    @Size(min = 3)
    private String finderName;
    @Email
    private String finderEmail;
    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;
    @NotBlank
    @Size(max = 100)
    private String foundObjectDescription;

    public Double getGeolocationLatitude() {
        return geolocationLatitude;
    }

    public void setGeolocationLatitude(Double geolocationLatitude) {
        this.geolocationLatitude = geolocationLatitude;
    }

    public Double getGeolocationLongitude() {
        return geolocationLongitude;
    }

    public void setGeolocationLongitude(Double geolocationLongitude) {
        this.geolocationLongitude = geolocationLongitude;
    }

    public String getFinderName() {
        return finderName;
    }

    public void setFinderName(String finderName) {
        this.finderName = finderName;
    }

    public String getFinderEmail() {
        return finderEmail;
    }

    public void setFinderEmail(String finderEmail) {
        this.finderEmail = finderEmail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFoundObjectDescription() {
        return foundObjectDescription;
    }

    public void setFoundObjectDescription(String foundObjectDescription) {
        this.foundObjectDescription = foundObjectDescription;
    }
}
